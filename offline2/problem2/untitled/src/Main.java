import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class Student{
    Mediator mediator;
 private int id;
private int marks;
Student(Mediator m,int id)
{
    this.mediator=m;
    this.id=id;
    this.marks=-1;
    //System.out.println("A student has been created. Id : "+id);

}
Student(int id,int marks)
{
    this.id=id;
    this.marks=marks;
   // System.out.println("Student id : "+id+" marks = "+marks);

}


    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    void updateMarks()
    {
        if(marks==-1)
        {
            System.out.println("Result yet not published..");
        }
        else
        {
            System.out.println("Id : "+id+" Marks "+marks);
        }
    }
    void register()
    {
        mediator.registerStudent(this);

    }
}
class examiner
{

    private int id;
    private Student marksList[];

    int sizeOfMarkList;
    Mediator mediator;
    examiner(int id,int t,Mediator m)
    {
        this.mediator=m;
        this.id=id;
        sizeOfMarkList=t;
        //System.out.println("An examiner has been created . Id "+id+" and size of his markList is "+t);

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student[] getMarksList() {
        return marksList;
    }

    public void setMarksList(Student[] marksList) {
        this.marksList = marksList;
    }

    void register()
    {
        mediator.registerExaminer(this);


    }
    void submitmarks()
    {
        int t=sizeOfMarkList;
        Random random=new Random();
        marksList=new Student[t];
        for(int i=0;i<t;i++)
        {
            marksList[i]=new Student(i+1,random.nextInt(100));

        }
        mediator.submitMarks(this);

    }
   boolean recheckMarks(Student s)
    {
        System.out.println("From examiner: i received request from "+s.getId()+" to recheck his marks");
        Random random=new Random();
        int p=random.nextInt(100);
        if(p%2==0)
        {
            System.out.println("Yes.There has been some wrong evaluation..");
            s.setMarks(random.nextInt(s.getMarks()+1,100));
            System.out.println("new marks "+s.getMarks());
            return true;
        }
        else
        {
            System.out.println("Sorry!No mistake ");
            return false;
        }

    }


}
interface Mediator
{
    void registerExaminer(examiner e);
    void registerStudent(Student s);
    void submitMarks(examiner e);
    void checkMarks();
    void updateMarks();
    void recheckMarks(Student s);




}
class examController implements Mediator
{

    ArrayList<examiner> examinersList;
    ArrayList<Student> studentList;
    Student[] examMarksBefore;
    Student[] examMarksAfter;
    examiner currentExaminer;
    examController()
    {
        examinersList=new ArrayList<>();
        studentList=new ArrayList<>();



    }


    @Override
    public void registerExaminer(examiner e) {
        System.out.println("AN examiner has been registered. Id "+e.getId());
        examinersList.add(e);

    }

    @Override
    public void registerStudent(Student s) {
        System.out.println("An student has been registered . Id : "+s.getId());
        studentList.add(s);
    }

    @Override
    public void submitMarks(examiner e)
    {

        if(examinersList.contains(e)==true)
        {

            currentExaminer=e;
            System.out.println(" an examiner "+e.getId()+" has submitted marks..");
         examMarksBefore=new Student[e.sizeOfMarkList];
         examMarksAfter=new Student[e.sizeOfMarkList];
         Student temp[]=e.getMarksList();
         for(int i=0;i<e.sizeOfMarkList;i++)
         {
             examMarksBefore[i]=temp[i];
             System.out.println("id = "+temp[i].getId()+" marks = "+temp[i].getMarks());
         }
         checkMarks();
        }
        else
        {
            System.out.println("Unknown examiner.");
        }

    }

    @Override
    public void checkMarks()
    {
        System.out.println("checking marks...");
        Random random=new Random();
        int wrong=random.nextInt(5);
        System.out.println("Wrong evaluation Id "+(wrong+1));
        for(int i=0;i<examMarksBefore.length;i++)
        {
            if(i!=wrong)
            {
                examMarksAfter[i]=examMarksBefore[i];
            }
            else
            {
                int p=random.nextInt(100);
                System.out.println(" new mark = "+p+" id = "+(i+1));
                examMarksAfter[i]=new Student(i+1,p);
            }
        }
        updateMarks();

    }
    public void updateMarks()
    {
        //System.out.println("updating marks..");
        for(int i=0;i<studentList.size();i++)
        {
           Student temp=studentList.get(i);
           int id=temp.getId();
           temp.setMarks(examMarksAfter[id-1].getMarks());
            System.out.println(" id:"+studentList.get(i).getId()+" marks = "+studentList.get(i).getMarks());
        }

    }




    @Override
    public void recheckMarks(Student s) {
        System.out.println("Id : "+s.getId()+" has requested for a recheck.\n Previous Marks "+s.getMarks());
        boolean t=currentExaminer.recheckMarks(s);
        if(t==true)
        {
            System.out.println("Your mark has been changed..");

        }
        else
        {
            System.out.println("No change...");
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Mediator mediator=new examController();
        Student s1=new Student(mediator,1);
        Student s2=new Student(mediator,2);
        Student s3=new Student(mediator,3);
        Student s4=new Student(mediator,4);
        Student s5=new Student(mediator,5);
        examiner e1=new examiner(1,5,mediator);
        mediator.registerStudent(s1);
        mediator.registerStudent(s2);
        mediator.registerStudent(s3);
        mediator.registerStudent(s4);
        mediator.registerStudent(s5);
        mediator.registerExaminer(e1);
        e1.submitmarks();
        s1.updateMarks();
        s2.updateMarks();
        s3.updateMarks();
        s4.updateMarks();
        s5.updateMarks();
        mediator.recheckMarks(s1);
        s1.updateMarks();


    }
}