import java.util.ArrayList;

abstract class Beverage
{
    //component class
    private ArrayList<String> ingredients = new ArrayList<String>();
    void addingredients(String str)
    {
        ingredients.add(str);

    }
   abstract double  cost();
}
class Americano extends Beverage
{
    //concrete component class
    Americano()
    {
        addingredients("Water");
        addingredients("Grinded Coffee beans");
        addingredients("additional Coffee beans");

    }
    public double cost()
    {
        return 30;
    }
}
class Espresso extends Beverage
{
    //concrete component class
    Espresso()
    {
        ingredients.add("Water");
        ingredients.add("Grinded Coffee beans");
    }
    public double cost()
    {
        return 70;
    }
}








public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}