import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Scanner;
//composite pattern
abstract class employee
{
    //component class
    protected String name;
    protected String role;
    protected String projectName;
    protected int devcount;
    void setName(String name)
    {
        this.name=name;
    }
    void setRole(String role)
    {
        this.role=role;
    }
    void setProjectName(String projectName)
    {
        this.projectName=projectName;
    }
    String getName()
    {
        return name;
    }
    String getRole()
    {
        return role;
    }
    String getProjectName()
    {
        return projectName;
    }
     void setDevCount(int devcount)
     {
            this.devcount=devcount;
     }
     int getDevCount()
    {
        return devcount;
    }
    abstract void showDetails();
    abstract void showmyDetails();
    abstract void adddeveloper(employee devs);

    abstract void removedeveloper(employee devs);

    abstract void removeproject();


}
class developer extends employee
{
    //leaf
    developer(String name)
    {
        this.role="Developer";
        this.name=name;
        this.devcount=0;
        this.projectName=null;
    }
    developer(String name,String projectName)
    {
        this.role="Developer";
        this.name=name;
        this.projectName=projectName;
        this.devcount=0;

    }
    void showDetails()
    {
        System.out.println("\t\t\t-\t"+name);

    }
    void showmyDetails()
    {

        System.out.println("Name: "+name);
        System.out.println("Role: "+role);
        if(projectName!=null)
        System.out.println("Current Project: "+projectName);
    }
    void adddeveloper(employee devs)
    {

        throw new UnsupportedOperationException();
    }
    void removedeveloper(employee devs)
    {
        throw new UnsupportedOperationException();
    }
    void removeproject()
    {
        throw new UnsupportedOperationException();
    }


}
class projectManager extends employee
{
    //composite class
    private ArrayList<employee> devlist;
    //list of devs under a project manager
    projectManager(String name)
    {
        devlist=new ArrayList<employee>();
        this.role="Project Manager";
        this.name=name;
        this.projectName=null;
    }
    projectManager(String name,String projectName)
    {
        devlist=new ArrayList<employee>();
        this.role="Project Manager";
        this.name=name;
        this.projectName=projectName;
    }

    void showDetails()
    {
        System.out.println("\t\t-\t"+name+"("+projectName+")");
        for(employee e:devlist)
        {
            e.showDetails();
        }
    }
    void showmyDetails()
    {
        System.out.println("Name: "+name);
        System.out.println("Role: "+role);
        if(projectName!=null)
        System.out.println("Current Project: "+projectName);
        System.out.println("Number of Supervisees: "+devcount);
    }
    void adddeveloper(employee devs)
    {
        devs.setProjectName(this.projectName);
        devlist.add(devs);


    }
    void removedeveloper(employee devs)
    {
        devlist.remove(devs);
        devs.setProjectName(null);
    }
    void removeproject()
    {
        for(employee e:devlist)
        {
            e.setProjectName(null);

            //dont know will work or not?
        }
        devlist.clear();
        this.projectName=null;

    }


}
class softwareCompany
{
    //client class
    private String name;
    private ArrayList<employee> emplist;
    //project manager's list
    String getName(){return name;}
    softwareCompany(String name)
    {
        this.name=name;
        emplist=new ArrayList<employee>();
    }
    void addnewProject(String projectname,projectManager pm)
    {
//        projectManager pm=new projectManager(managername,projectname);
        boolean flag=false;
        pm.setProjectName(projectname);
        for(employee e:emplist)
        {
            if(e.getName().equals(pm.getName()))
            {
                System.out.println("Project Manager already in another project");
               flag=true;
               break;
            }
        }
        if(flag==false)
        emplist.add(pm);

    }
    void removeproject(String projectname)
    {
        employee pmng=  null;
        for(employee e:emplist)
        {
            if(e.getProjectName().equalsIgnoreCase(projectname))
            {
                pmng=e;

                e.removeproject();

            }
        }
        if(pmng!=null)
        emplist.remove(pmng);
        else
            System.out.println("No such project exists");

    }
    void hireDevolper(employee devs,String projectname)
    {
        employee pmng;
        if(devs.getProjectName()!=null)
        {
            System.out.println("Developer already in another project");
            return;
        }
        for(employee e:emplist)
        {
            if(e.getProjectName().equalsIgnoreCase(projectname))
            {
                e.adddeveloper(devs);
                break;

            }
        }

    }
    void removedeveloper(String pname,employee devs)
    {
        boolean flag=false;
        for(employee e:emplist)
        {
            if(e.getProjectName().equals(pname))
            {
              e.removedeveloper(devs);
              flag=true;
                break;

            }
        }
        if(flag==false)
            System.out.println("No such developer exist in this project ");
    }



    void showDetails()
    {
        System.out.println("-\t"+name);
        for(employee e:emplist)
        {
            e.showDetails();
        }
    }
    void showmyDetails()
    {
        System.out.println("Name: "+name);
        System.out.println("Number of Projects: "+emplist.size());
    }

}
public class Main {
    static boolean checkdev(String dname,ArrayList<developer> dlist,ArrayList<projectManager> plist,ArrayList<softwareCompany> slist)
    {

        for(projectManager t:plist)
        {
            if(t.getName().equalsIgnoreCase(dname)==true)
            {
                return true;
            }



        }
        for(softwareCompany t:slist)
        {
            if(t.getName().equalsIgnoreCase(dname)==true)
            {
                return true;
            }


        }
        for(developer d:dlist)
        {
            if(d.getName().equalsIgnoreCase(dname)==true)
            {
                return true;
            }
        }
        return false;

    }
    static boolean checkprojectmnger(String pname,ArrayList<projectManager> plist,ArrayList<developer> dlist,ArrayList<softwareCompany> slist)
    {
        for(developer d:dlist)
        {
            if(d.getName().equalsIgnoreCase(pname)==true)
            {
                return true;
            }


        }
        for(softwareCompany s:slist)
        {
            if(s.getName().equalsIgnoreCase(pname)==true)
            {
                return true;
            }
        }
        for(projectManager p:plist)
        {
            if(p.getName().equalsIgnoreCase(pname)==true)
            {
                return true;
            }
        }
        return false;

    }
    static boolean checkcompany(String companyName,ArrayList<softwareCompany> slist,ArrayList<developer> dlist,ArrayList<projectManager> plist) {
        for (developer d : dlist) {
            if (d.getName().equalsIgnoreCase(companyName) == true) {
                return true;
            }
        }
        for (projectManager p : plist) {
            if (p.getName().equalsIgnoreCase(companyName) == true) {
                return true;
            }
        }
        for(softwareCompany s:slist)
        {
            if(s.getName().equalsIgnoreCase(companyName)==true)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<developer> devlist=new ArrayList<>();
        ArrayList<projectManager> managerlist=new ArrayList<>();
        ArrayList<softwareCompany> companylist=new ArrayList<>();
        while (true)
        {
            System.out.println("Enter 1 to create and 2 to do stuffs and 3 for details and 4 to exit");
            int sw=sc.nextInt();

            if(sw==1) {
                while (true)
                {
                //create stuffs
                System.out.println("Enter 1 to create a developer,2 to create a project manager\n and 3 to create a software compmany and 4 to exit");
                int t = sc.nextInt();
                if (t == 1) {
                    System.out.println("Enter developer name :");
                    String nm = sc.next();
                    if (checkdev(nm, devlist,managerlist, companylist) == true) {
                        System.out.println("Sorry!The name has to be unique.");
                        continue;
                    }
                    devlist.add(new developer(nm));
                } else if (t == 2) {
                    System.out.println("Enter project manager name :");
                    String nm = sc.next();
                    if (checkprojectmnger(nm, managerlist,devlist, companylist) == true) {
                        System.out.println("Sorry!The name has to be unique.");
                        continue;
                    }
                    managerlist.add(new projectManager(nm));
                } else if (t == 3) {
                    System.out.println("Enter software company name :");
                    String nm = sc.next();
                    if (checkcompany(nm, companylist,devlist, managerlist) == true) {
                        System.out.println("Sorry!The name has to be unique.");
                        continue;
                    }
                    companylist.add(new softwareCompany(nm));
                } else if (t == 4) {
                    break;
                } else {
                    System.out.println("invalid input");
                }
            }


            }
            else if(sw==2) {
                //generate
                softwareCompany scompnay = null;
                System.out.println("Available companies");
                for (softwareCompany s : companylist) {
                    System.out.println(s.getName());
                }
                System.out.println("Enter the company you want to select :");
                String sname = sc.next();
                for (softwareCompany s : companylist) {
                    if (s.getName().equalsIgnoreCase(sname) == true) {
                        scompnay = s;
                        break;
                    }
                }
            while (true) {



                if (scompnay == null) {
                    System.out.println("Sorry!No such company exists");
                    break;
                }
                System.out.println("Enter 1 to create a new proejct,");
                System.out.println("Enter 2 to remove a project");
                System.out.println("Enter 3 to hire a developer in a existing project");
                System.out.println("Enter 4 to remove a developer from a existing project");
                System.out.println("Enter 5 to show details of a software company");
                System.out.println("Enter 6 to quit");
                boolean flag=false;
                int or = sc.nextInt();
                switch (or) {
                    case 1:
                        System.out.println("Available project managers");
                        for(projectManager p:managerlist)
                        {
                            if(p.getProjectName()==null)
                            System.out.println(p.getName());
                        }
                        System.out.println("Enter the project name you want to create:");

                        String pname = sc.next();
                        System.out.println("Enter the project manager name for your project :");
                        String mname = sc.next();
                        projectManager pm = null;
                        for (projectManager p : managerlist) {
                            if (p.getName().equalsIgnoreCase(mname) == true) {
                                pm = p;
                                break;
                            }
                        }
                        if(pm==null)
                        {
                            System.out.println("Sorry!No such project manager exists");
                            break;
                        }
                        scompnay.addnewProject(pname, pm);

                        break;
                    case 2:
                        scompnay.showDetails();
                        System.out.println("Enter the project name you want to remove:");
                        String rname = sc.next();
                        scompnay.removeproject(rname);
                        break;
                    case 3:
                      scompnay.showDetails();
                        System.out.println("Available developers");
                        for (developer d : devlist) {
                           if(d.getProjectName()==null)
                               System.out.println(d.getName());
                        }
                        System.out.println("Enter the developer name");
                        String dname = sc.next();
                        System.out.println("Enter the project name");
                        String pname1 = sc.next();
                        developer dev = null;
                        for (developer d : devlist) {
                            if (d.getName().equalsIgnoreCase(dname) == true) {

                                    dev = d;
                                    break;



                            }
                        }
                        if(dev!=null)
                        scompnay.hireDevolper(dev, pname1);
                        else
                            System.out.println("NO such developer exists");

                        break;
                    case 4:
                        scompnay.showDetails();
                        System.out.println("Enter the developer name you want to remove");
                        String dname1 = sc.next();
                        System.out.println("Enter the project name");
                        String proname = sc.next();
                        developer dev1 = null;
                        for (developer d : devlist) {
                            if (d.getName().equalsIgnoreCase(dname1) == true) {
                                if (d.getProjectName() == null) {
                                    System.out.println("Sorry!The developer is not working in a project");
                                    break;
                                } else {
                                    dev1 = d;
                                    break;
                                }
                            }
                        }
                        scompnay.removedeveloper(proname, dev1);
                        break;
                    case 5:
                        scompnay.showDetails();
                        break;
                    case 6:
                        flag=true;
                        break;


                }
                if(flag==true)
                    break;
            }
            }
            else if(sw==3)
            {
                System.out.println("enter 1 for developer,2 for project managers,3 for compamies and" +
                        " 4 for complete hierachy");
                int l=sc.nextInt();
                String nme= null;
                switch (l)
                {
                    case 1:
                        System.out.println("Enter the developer name");
                        nme= sc.next();
                        boolean flag=false;
                        for(developer d:devlist)
                        {
                            if(d.getName().equalsIgnoreCase(nme)==true)
                            {
                                d.showmyDetails();
                                flag=true;
                                break;
                            }
                        }
                        if(flag==false)
                            System.out.println("Sorry!No such developer exists");
                        break;
                    case 2:
                        System.out.println("Enter the project manager name");
                        nme= sc.next();
                        boolean flag1=false;
                        for(projectManager p:managerlist)
                        {
                            if(p.getName().equalsIgnoreCase(nme)==true)
                            {
                                p.showmyDetails();
                                flag1=true;
                                break;
                            }
                        }
                        if(flag1==false)
                            System.out.println("Sorry!No such project manager exists");
                        break;
                        case 3:
                            System.out.println("Enter the software company name");
                            nme= sc.next();
                            boolean flag2=false;
                            for(softwareCompany s:companylist)
                            {
                                if(s.getName().equalsIgnoreCase(nme)==true)
                                {
                                    s.showmyDetails();
                                    flag2=true;
                                    break;
                                }
                            }
                            if(flag2==false)
                                System.out.println("Sorry!No such software company exists");

                            break;
                    case 4:

                        for(softwareCompany s:companylist)
                        {

                                s.showDetails();

                        }
                        break;
                    default:
                        System.out.println("Invalid input");
                }


            }
            else if(sw==4)
            {
                break;
            }
            else {

            }
        }
//


            }







        }

