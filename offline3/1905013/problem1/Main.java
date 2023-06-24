import java.util.ArrayList;

abstract class crew
{
    String name;
   abstract void study();
   abstract void cook();
   abstract void maintainance();
}
class crewMates extends crew
{
    crewMates(String name)
    {
        this.name = name;
    }
   void study()
   {
      System.out.println("I am Studing about the new galaxies");
   }
   void cook()
   {
      System.out.println("Cooking dishes for fellow crewmates");
   }
   void maintainance()
   {
      System.out.println("Maintainaning and reparing the spaceship");
   }
}
abstract class outsider
{
    String name;
    abstract void pretend();
    abstract void posion();
    abstract void damage();
}
class imposters extends outsider
{

    imposters(String name)
    {
        this.name = name;
    }
    @Override
    void pretend() {
        System.out.println("I am  pretending to study");

    }

    @Override
    void posion() {
        System.out.println("While cooking,i am posing the food");

    }

    @Override
    void damage() {
        System.out.println("While repairing the spaceship,i am damaging it");
    }
}
class Adapter extends crew
{
   private outsider otsider;
    Adapter(outsider o)
    {
        this.otsider=o;
    }

    @Override
    void study() {
        this.otsider.pretend();


    }

    @Override
    void cook() {
        this.otsider.posion();

    }

    @Override
    void maintainance() {
        this.otsider.damage();
    }
}




public class Main {
    public static void main(String[] args) {
        ArrayList<crew> crewlist=new ArrayList<crew>();
        crew cr=null;
        cr=new crewMates("Farhan");
        crewlist.add(cr);
        cr=new crewMates("Rifah");
        crewlist.add(cr);
        cr=new crewMates("Anonto");
        crewlist.add(cr);
        cr=new Adapter(new imposters("Saffat"));
        crewlist.add(cr);
        cr=new Adapter(new imposters("Hafijul"));
        crewlist.add(cr);
        int q=6;
        while(q>=0)
        {
            for(crew c:crewlist)
            {
                if(q%3==1)
                {
                    c.study();
                }
                else if(q%3==2)
                {
                    c.cook();
                }
                else
                {
                    c.maintainance();
                }
                q--;
            }

        }


    }
}