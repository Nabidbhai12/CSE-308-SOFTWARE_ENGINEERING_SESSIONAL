import java.util.ArrayList;
import java.util.Scanner;

abstract class beverage
{
    //component class
    protected String beverageDescription;
    protected double cost;
    String getBeverageDescription()
    {
        return beverageDescription;
    }
    void setBeverageDescription(String beverageDescription)
    {
        this.beverageDescription = beverageDescription;
    }
    double getCost()
    {
        return cost;
    }
    void setCost(double cost)
    {
        this.cost = cost;
    }

}
class blackCoffee extends beverage
{
    //concrete component class
    blackCoffee()
    {
        setBeverageDescription("\nWater\nGrinded Coffee beans\n");
        setCost(30);
    }

}
class milkCoffee extends beverage
{
    //concrete component class
    milkCoffee()
    {
        setBeverageDescription("\nMilk\nGrinded Coffee beans\n");
        setCost(80);

    }

}
abstract class Decorator extends beverage
{
    //decorator class
    abstract String getBeverageDescription();
}
class grindedCoffeebeans extends Decorator
{
    //concrete decorator class
    beverage bvrg;
    grindedCoffeebeans(beverage bvrg)
    {
        this.bvrg = bvrg;
    }
    String getBeverageDescription()
    {
        return bvrg.getBeverageDescription() + "Additional Grinded Coffee beans\n";
    }
    double getCost()
    {
        return bvrg.getCost() + 30;
    }
}
class Milk extends Decorator
{
    beverage bvrg;

    Milk(beverage bvrg)
    {
        this.bvrg = bvrg;

    }
    String getBeverageDescription()
    {
        return bvrg.getBeverageDescription()+"Additional Milk\n";
    }
    double getCost()
    {
        return bvrg.getCost() + 50;
    }
}
class dairyCream extends Decorator
{
    beverage bvrg;
    dairyCream(beverage bvrg)
    {
        this.bvrg = bvrg;
    }
    String getBeverageDescription()
    {
        return bvrg.getBeverageDescription()+"Dairy Cream\n";
    }
    double getCost()
    {
        return bvrg.getCost()+40;
    }
}
class cinamonPowder extends Decorator
{
    beverage bvrg;
    cinamonPowder(beverage v)
    {
        this.bvrg=v;
    }
    String getBeverageDescription()
    {
        return bvrg.getBeverageDescription()+"Cinamon Powder\n";
    }
    double getCost()
    {
        return bvrg.getCost()+50;
    }

}
class chocolateSauce extends Decorator
{
    beverage bvrg;
    chocolateSauce(beverage bvrg)
    {
        this.bvrg = bvrg;
    }
    String getBeverageDescription()
    {
        return bvrg.getBeverageDescription()+"Chocolate Sauce\n";
    }
    double getCost()
    {
        return bvrg.getCost()+60;
    }
}
class coffeeMug extends Decorator
{
    beverage bvrg;
    coffeeMug(beverage bvrg)
    {
        this.bvrg = bvrg;
    }
    String getBeverageDescription()
    {
        return bvrg.getBeverageDescription();
    }
    double getCost()
    {
        return bvrg.getCost()+100;
    }
}
class Main
{
    public static void main(String[] args)
    {

        int amricno=0,espreso=0,cpchino=0,mocha=0;
        beverage bv=null;
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("Menu: ");
            System.out.print("Enter 1 to order Americano\n");
            System.out.println("Enter 2 to oder Espresso");
            System.out.println("Enter 3 to order Cappuccino");
            System.out.println("Enter 4 to order Mocha");
            System.out.println("Enter 5 to quit");
            int order=sc.nextInt();
            switch (order)
            {
                case 1:
                    amricno++;
                    break;
                case 2:
                    espreso++;
                case 3:
                    cpchino++;
                    break;
                case 4:
                    mocha++;
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            if (order==5)
            {
                break;
            }
            System.out.println("DO you want order more?enter 1");
            System.out.println("DO you want to place this order?entr 2");
            order=sc.nextInt();
            if(order==1)
                continue;
            double cost=0.00;
            while (amricno!=0)
            {
                bv=new blackCoffee();
                bv=new grindedCoffeebeans(bv);
                bv=new coffeeMug(bv);
                System.out.println("\nAmericano");
                System.out.println(bv.getBeverageDescription());
                amricno--;
                cost+=bv.getCost();
                System.out.println("Price : "+bv.getCost());

            }
            while (espreso!=0)
            {
                bv=new blackCoffee();
                bv=new dairyCream(bv);
                bv=new coffeeMug(bv);
                System.out.println("\nEspreso");
                System.out.println(bv.getBeverageDescription());
                espreso--;
                cost+=bv.getCost();
                System.out.println("Price : "+bv.getCost());

            }
            while (cpchino!=0)
            {
                bv=new milkCoffee();
                bv=new cinamonPowder(bv);
                bv=new coffeeMug(bv);
                System.out.println("\nCapcachino");
                System.out.println(bv.getBeverageDescription());
                cpchino--;
                cost+=bv.getCost();
                System.out.println("Price : "+bv.getCost());
            }

            while (mocha!=0)
            {
                bv=new milkCoffee();
                bv=new chocolateSauce(bv);
                bv=new coffeeMug(bv);
                System.out.println("\nMocha");
                System.out.println(bv.getBeverageDescription());
                mocha--;
                cost+=bv.getCost();
                System.out.println("Price : "+bv.getCost());
            }
            System.out.println("Total bill : "+cost);

        }

    }
}
