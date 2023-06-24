import java.util.Scanner;

abstract class Car
{
   protected String color;
    protected String manCountry;
    protected String engine;
    protected String driveTrain;
    String getcolor()
    {
        return this.color;
    }
    String  getmanCountry()
    {
        return this.manCountry;
    }
    String getEngine()
    {
        return this.engine;

    }
    String drivetrain()
    {
        return driveTrain;
    }
    void Print()
    {
        System.out.println("Congratulations! Your car details -->\n");
        System.out.println("Color : "+this.color +", Manfactured in : "+manCountry+", Engine model : "+engine+", drive train:"+driveTrain);

    }

}
class BMW extends Car
{
    BMW()
    {
        this.color=new String("black");
        manCountry=new String("Germany");
        engine=new String("Electric engines");
        driveTrain=new String("Rear wheel drive trains");
    }
}
class Toyata extends Car{
    Toyata()
    {
        this.color=new String("red");
        manCountry=new String("Japan");
        engine=new String("Hydrogen fuel cell engines");
        driveTrain=new String("Rear wheel drive trains");

    }

}
class Tesla extends Car
{
    Tesla()
    {
        this.color=new String("white");
        manCountry=new String("Usa");
        engine=new String("Electric engines");
        driveTrain=new String("All wheels drive trains");

    }

}
class carFactory
{
    Car getaCar(String nabid)
    {
        if(nabid==null)
            return null;
        if(nabid.equalsIgnoreCase("Asia"))
        {
            return new Toyata();

        }
        else if(nabid.equalsIgnoreCase("Europe"))
        {
            return new BMW();
        }
        else if(nabid.equalsIgnoreCase("Us"))
        {
            return new Tesla();
        }
        else
        {
            return null;
        }


    }

}



public class Main2 {
    public static void main(String[] args)
    {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if(str.equalsIgnoreCase("Q"))
                break;
            carFactory carfactory = new carFactory();
            if(str.equalsIgnoreCase("ASIA")|| str.equalsIgnoreCase("EUROPE") || str.equalsIgnoreCase("US")) {
                Car car = carfactory.getaCar(str);
                car.Print();
            }
            else
            {
                System.out.println("Sorry");
            }
        }

    }
}