import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class user
{

    public static final String Regular="Regular";
    public static final String Premium="Premium";

   protected String name;
    protected   String type;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public abstract int Ask();
    public abstract int Ask2();
    public abstract void notify1();
    public void billing(int i)
    {
        System.out.println("Username :"+name+" your bill is = "+i+"$");

    }

}
class regularUser extends user
{
    regularUser(String name)
    {
        this.name=name;
        this.type=Regular;
    }
    public  int Ask()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Username "+name+" : whether you want to use our partially down server(some functionality maybe unavilable) or you want to use services from server DEF in exchange of 20$ per hour");
        System.out.println("ENTER 1 for limited functionality and 2 for pay 20 $");

        int i=sc.nextInt();
        return i;

    }
    public int Ask2()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Username "+name+" : our servers are down.So, we are asking  you  if want to use services from derver DEF in exchange of 20$ or wait untill we fix everything");
        System.out.println("ENTER 1 for yes and 2 for no $");

        int i=sc.nextInt();
        return i;
    }
    public void notify1()
    {
        System.out.println(name+ " : your service is now being provided by DEF Server");
    }


}
class premiumUser extends user
{
    premiumUser(String name)
    {
        this.name=name;

        type=Premium;
    }
    public int Ask()
    {

            Scanner sc=new Scanner(System.in);
            System.out.println("Username "+name+"  : we are asking you whether you want to use our partially down server or you want to use services from DEF server");
            System.out.println("ENTER 1 for limited functionality and 2 for to use service form DEF server");

            int i=sc.nextInt();
            return i;


    }
    public void notify1()
    {
        System.out.println(name+" : your service is now fully  being provided by DEF Server as our servers are down");
    }
    public int Ask2()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Username "+name+" : our servers are down.So, we are asking  you  if want to use services from derver DEF in exchange of 20$");
        System.out.println("ENTER 1 for yes and 2 for no ");

        int i=sc.nextInt();
        return i;
    }
}



interface subject
{
    void register(user e);
    void unregister(user e);
    void changeState(int nstate);
    void notifyUsers(int prevstate);
}
class serverSide implements subject
{
    public static final int Operational=1;
    public static final int PartiallyDown=2;
    public static final int FullyDown=3;
    int currentState;
    ArrayList<user> regUserList;
    ArrayList<user> preUserList;
    serverSide()
    {
        regUserList=new ArrayList<>();
        preUserList=new ArrayList<>();
        currentState=Operational;

    }

    @Override
    public void register(user e) {
        //System.out.println("A new  user has requested to register");
        if(e.type.equalsIgnoreCase("regular")==true)
        {
          //  System.out.println("He wants to be a regular user..");
            regUserList.add(e);
        }
        else {
            //System.out.println("He wants to be a premium user..");
            preUserList.add(e);
        }

    }

    @Override
    public void unregister(user e) {
        //System.out.println("A  user has requested to unregister");
        if(e.type.equalsIgnoreCase("regular")==true)
        {
          //  System.out.println("He was   a regular user..");
            regUserList.remove(e);
        }
        else {
            //System.out.println("He was a premium user..");
            preUserList.remove(e);
        }

    }

    @Override
    public void changeState(int nstate) {
        int prevState=currentState;
        this.currentState=nstate;

        notifyUsers(prevState);

    }

    @Override
    public void notifyUsers(int prevstate) {
        switch (prevstate)
        {
            case 1:
                //means previously operational state
                if(currentState==PartiallyDown)
                {
                    for(user u:regUserList)
                    {

                        u.Ask();

                    }
                    for(user u:preUserList)
                    {
                        u.Ask();
                    }

                }
                else if(currentState==FullyDown)
                {
                    for(user u:regUserList)
                    {

                        u.Ask2();

                    }
                    for(user u:preUserList)
                    {
                        u.notify1();
                    }

                }
                else
                {

                }
                break;
            case 2:
                //means partially down previously
                if(currentState==Operational)
                {
                    for(user u:regUserList)
                    {

                        u.billing(new Random().nextInt(100));

                    }


                }
                else  if(currentState==FullyDown)
                {
                    for(user u:preUserList)
                    {

                       u.notify1();

                    }

                }
                else
                {

                }

                break;
            case 3:
                //means fully down previously
                if(currentState==Operational)
                {
                    for(user u:regUserList)
                    {

                        u.billing(new Random().nextInt(100));

                    }
                }
                else {

                }
                break;
            default:
                System.out.println("Unknown error");
                break;

        }


    }
}


public class Main {
    public static void main(String[] args) {
        user prm=new premiumUser("Nabid");
        user reg=new regularUser("Farhan");
        serverSide serverside=new serverSide();
        serverside.register(prm);
        serverside.register(reg);
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter 1 for operational mode 2 for partially down and 3 for fully down");
            int i=sc.nextInt();
            if(i==-1)
                break;

            serverside.changeState(i);
        }

    }
}