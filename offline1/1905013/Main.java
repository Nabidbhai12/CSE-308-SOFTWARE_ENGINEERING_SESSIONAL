import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//the common interface.THe builder interface
interface pcBuilder {
    void addProcessor();

    void addBasecomponent();

    void addCooler();

    void addDVDDrive();

    void addRam(int choice);

    void addGraphicscard(int choice);
    Pc getPc();


}

class Type1Pc implements pcBuilder {


    private  Pc pc;

    Type1Pc() {
        pc = new Pc("Type1");
     //   System.out.println("hi");
       // System.out.println(pc.getPcName());


    }

    @Override
    public void addProcessor() {
        pc.addProcessor("AMD Ryzen 7 5700X", 28000);
        pc.changeAddPrice(28000);

    }

    @Override
    public void addBasecomponent() {
        pc.addBaseComponent();

    }

    @Override
    public void addCooler() {
        pc.addCooler("CPU Cooler", 36000);
        pc.changeAddPrice(36000);
    }

    @Override
    public void addDVDDrive() {
        pc.addDvdDrive(" ", -1);

    }

    @Override
    public void addRam(int choice) {
        pc.addRam(choice);


    }

    @Override
    public void addGraphicscard(int choice) {
        pc.addGraphicsCard(choice);

    }

    @Override
    public Pc getPc() {
        return this.pc;
    }
}

class Type2Pc implements pcBuilder {
    private Pc pc;

    Type2Pc() {
        pc = new Pc("Type2");
    }


    @Override
    public void addProcessor() {
        pc.addProcessor(" Intel Core i3", 20000);
        pc.changeAddPrice(20000);


    }

    @Override
    public void addBasecomponent() {
        pc.addBaseComponent();

    }

    @Override
    public void addCooler() {
        pc.addCooler("Liquid cooler", 17000);
        pc.changeAddPrice(17000);

    }

    @Override
    public void addDVDDrive() {
        pc.addDvdDrive(" ", -1);

    }

    @Override
    public void addRam(int choice) {
        pc.addRam(choice);

    }

    @Override
    public void addGraphicscard(int choice) {
        pc.addGraphicsCard(choice);

    }

    @Override
    public Pc getPc() {
        return pc;
    }
}

class Type3Pc implements pcBuilder {
    private Pc pc;

    Type3Pc() {
        pc = new Pc("Type3");
    }

    @Override
    public void addProcessor() {
        pc.addProcessor("Intel core i5", 37000);
        pc.changeAddPrice(37000);


    }

    @Override
    public void addBasecomponent() {
        pc.addBaseComponent();

    }

    @Override
    public void addCooler() {
        pc.addCooler(" ", -1);

    }

    @Override
    public void addDVDDrive() {
        pc.addDvdDrive(" DVD Drive", 6000);
        pc.changeAddPrice(6000);


    }

    @Override
    public void addRam(int choice) {
        pc.addRam(choice);

    }

    @Override
    public void addGraphicscard(int choice) {
        pc.addGraphicsCard(choice);

    }

    @Override
    public Pc getPc() {
        return pc;
    }
}

class Type4Pc implements pcBuilder {
    private Pc pc;

    Type4Pc() {
        pc = new Pc("Type4");
    }

    @Override
    public void addProcessor() {
        pc.addProcessor("Intel core i7", 65000);
        pc.changeAddPrice(65000);


    }

    @Override
    public void addBasecomponent() {
        pc.addBaseComponent();

    }

    @Override
    public void addCooler() {
        pc.addCooler(" ", -1);
    }

    @Override
    public void addDVDDrive() {
        pc.addDvdDrive(" ", -1);
    }

    @Override
    public void addRam(int choice) {
        pc.addRam(choice);


    }

    @Override
    public void addGraphicscard(int choice) {
        pc.addGraphicsCard(choice);

    }

    @Override
    public Pc getPc() {
        return pc;
    }
}


class Component {
    private String name;
    private int price;

    Component(String name, int price) {
        this.name = name;
        this.price = price;


    }

    Component() {
        this.name = null;
        this.price = -1;

    }


    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Component : " +
                "name='" + name + '\'' +
                ", price=" + price +
                ' ';
    }
}

class Pc {
    private String pcName;
    private Component processor;
    private Component Cpu;
    private Component motherboard;
    private Component HDD;
    private Component Ram;
    private Component graphicsCard;
    private Component cooler;
    private Component dvdDrive;
    private LinkedList<Component> addlist;

    private int totalPrice;
    private int basePrice;
    private int addPrice;

    Pc(String pcName) {
        this.pcName=pcName;
        addlist=new LinkedList<Component>();

        totalPrice = 0;
        basePrice = 0;
        addPrice = 0;
    }

    public String getPcName() {
        return pcName;
    }

    void addProcessor(String model, int price) {
        processor = new Component(model, price);
        addlist.add(processor);

    }

    void addBaseComponent() {
        Cpu = new Component("CPU", -1);
        motherboard = new Component("Motherboard", -1);
        HDD = new Component("1 TB HDD", -1);
        totalPrice =totalPrice+ 70000;
        basePrice = basePrice+70000;

    }

    void addCooler(String model, int price) {
        if (price == -1) {
            cooler = new Component();
            //addlist.add(cooler);

        } else {
            cooler = new Component(model, price);
            addlist.add(cooler);
        }

    }

    void addDvdDrive(String model, int price) {
        if (price == -1) {
            dvdDrive = new Component();
            //addlist.add(dvdDrive);

        } else {
            dvdDrive = new Component(model, price);
            addlist.add(dvdDrive);
        }

    }

    void addRam(int choice) {
        if (choice == 1) {
            Ram = new Component("8GB DDR4 RAM 2666 MHz", 2620);
            changeAddPrice(2620);
            addlist.add(Ram);

        } else {
            Ram = new Component("8GB DDR4 RAM 3200 MHz", 2950);
            changeAddPrice(2950);
            addlist.add(Ram);

        }

    }

    void addGraphicsCard(int choice) {
        if (choice == 1) {
            graphicsCard = new Component("2 GB Graphics card", 6500);
            changeAddPrice(6500);
            addlist.add(graphicsCard);


        } else {
            graphicsCard = new Component("4 GB Graphics card", 7600);
            changeAddPrice(7600);
            addlist.add(graphicsCard);

        }
    }

    void print()
    {
        System.out.println("You have purchased "+pcName+" !");
        Iterator it=addlist.iterator();
        System.out.println("LIst of the additional components: ");
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println("Total price of the additional components = "+getAddPrice());
        System.out.println("TOal price = "+getTotalPrice());


    }


   /* void changeTotalPrice(int add) {
        totalPrice = totalPrice + add;


    }*/


    void changeBasePrice(int add) {

        basePrice = basePrice + add;
        totalPrice = totalPrice + add;
    }

    void changeAddPrice(int add) {

        addPrice = addPrice + add;
        totalPrice = totalPrice + add;
    }

    int getTotalPrice() {
        return totalPrice;
    }

    int getBasePrice() {
        return basePrice;
    }

    int getAddPrice() {
        return addPrice;
    }


}

class Director {
    pcBuilder builder;

    void construct(pcBuilder builder, int ch1, int ch2) {
        this.builder = builder;
        System.out.println(" "+builder.getPc().getPcName());
        builder.addProcessor();
        builder.addBasecomponent();
        builder.addCooler();
        builder.addDVDDrive();
        if(ch1!=-1)
        builder.addRam(ch1);
        if(ch2!=-1)
        builder.addGraphicscard(ch2);


    }

}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pcBuilder pcbuilder = null;
       // System.out.println(pcbuilder.getPc().getPcName());
        Director director = new Director();
        String in;
        while (true)
        {
            System.out.println("ENter o to place an order or q to exit");

            in = sc.nextLine();
            System.out.println(in);

            while (in.equalsIgnoreCase("O") == false && in.equalsIgnoreCase("Q") == false)
            {
                in = sc.nextLine();
                System.out.println(in);
            }

            if (in.equalsIgnoreCase("O"))
            {
                System.out.println("Welcome to our store!..");
                System.out.println("Press 1/2/3/4 to choose your pc");
                System.out.println("1-> Gaming Pc with AMD");
                System.out.println("2-> CORE I3");
                System.out.println("3-> core i5");
                System.out.println("4 -> core i7");
                in = sc.nextLine();
                while (in.equalsIgnoreCase("1")==false && in.equalsIgnoreCase( "2")==false && in.equalsIgnoreCase( "3") && in.equalsIgnoreCase( "4"))
                {


                    System.out.println("Please select your pc type");
                    in = sc.nextLine();
                    if (in .equalsIgnoreCase( "E"))
                        System.out.println("Cant exit. Select atleast Type of your pc");
                    if (in .equalsIgnoreCase( "O"))
                        System.out.println("ALready in a order");
                }
                System.out.println(in);
                int i = Integer.parseInt(in);
                System.out.println(i);

                switch (i)
                {
                    case 1:
                        //System.out.println("Hello");
                        pcbuilder = new Type1Pc();
                        System.out.println(pcbuilder.getPc().getPcName());

                        break;
                    case 2:
                        pcbuilder = new Type2Pc();
                        break;
                    case 3:
                        pcbuilder = new Type3Pc();
                        break;
                    case 4:
                        pcbuilder = new Type4Pc();
                        break;

                }

                System.out.println("Do you want add Extra Ram? Press");
                System.out.println("1.Add 8GM 2666 MHz ram");
                System.out.println("2.Add 8GM 3000 MHz ram");
                System.out.println("3.SKip");
                System.out.println("E.checkout");
                in = sc.nextLine();
                while (in.equalsIgnoreCase("1") == false && in.equalsIgnoreCase("2") == false && in.equalsIgnoreCase("3") == false && in.equalsIgnoreCase("E") == false)
                {
                    System.out.println("Please input correct option");
                    in = sc.nextLine();
                    if (in .equalsIgnoreCase( "O"))
                        System.out.println("ALready in a order");

                }
                int iram;
                if (in.equalsIgnoreCase("1") || in.equalsIgnoreCase("2"))
                {
                    iram = Integer.parseInt(in);
                } else
                    iram = -1;


                if (in.equalsIgnoreCase("E"))
                {

                    director.construct(pcbuilder, iram, -1);
                    Pc pc = pcbuilder.getPc();
                    pc.print();

                    continue;
                }


                System.out.println("Do you want add Extra Graphics card? Press");
                System.out.println("1.Add 2GB Graphics card");
                System.out.println("2.Add 4GB Graphics card");
                System.out.println("E.checkout");
                in = sc.nextLine();
                while (in.equalsIgnoreCase("1") == false && in.equalsIgnoreCase("2") == false && in.equalsIgnoreCase("E") == false)

                    {
                        System.out.println("Please input correct option");
                        in = sc.nextLine();
                        if (in .equalsIgnoreCase( "O"))
                            System.out.println("ALready in a order");

                    }
                    int ig;
                    if (in.equalsIgnoreCase("1") || in.equalsIgnoreCase("2"))
                        ig = Integer.parseInt(in);
                    else
                        ig = -1;


                    if (in.equalsIgnoreCase("E")) {
                        director.construct(pcbuilder, iram, ig);
                        Pc pc = pcbuilder.getPc();
                        pc.print();

                        continue;
                    }
                    System.out.println("Press E to exit");
                    while (in.equalsIgnoreCase("E") == false)
                        in = sc.nextLine();
                    if (in.equalsIgnoreCase("E")) {
                        director.construct(pcbuilder, iram, ig);
                        Pc pc = pcbuilder.getPc();
                        pc.print();
                    }


                }

                if (in.equalsIgnoreCase( "Q")) {
                    System.out.println("break");
                    break;
                }

            }


        }

    }
