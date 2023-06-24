import java.util.Scanner;

interface state{
    void enter5tk();
    void enter10tk();
    void enter50tk();
    void enter100tk();
}
class initialState implements state
{
    vendingMachine vendingmachine;
    initialState(vendingMachine vm)
    {
        this.vendingmachine=vm;

    }


    @Override
    public void enter5tk() {
        if(vendingmachine.getPrice()==5)
        {
            System.out.println("5tk has been inserted and it is the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }


        }
        else if(vendingmachine.getPrice()>5)
        {
            System.out.println("5tk has been inserted and it is not enough");
            vendingmachine.setBalance(5);
            vendingmachine.setCurrentState(vendingmachine.getLessmoneystate());
        }
        else
        {
            System.out.println("5tk has been inserted and it is more than enough");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            int rem=5-vendingmachine.getPrice();
            System.out.println("vending machine: "+rem+" tk has been returned");
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
        }

    }

    @Override
    public void enter10tk() {

        if(vendingmachine.getPrice()==10)
        {
            System.out.println("10tk has been inserted and it is the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }


        }
        else if(vendingmachine.getPrice()>10)
        {
            System.out.println("10tk has been inserted and it is not enough");
            vendingmachine.setBalance(10);
            vendingmachine.setCurrentState(vendingmachine.getLessmoneystate());
        }
        else
        {
            System.out.println("10tk has been inserted and it is more than enough");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            int rem=10-vendingmachine.getPrice();
            System.out.println(rem+" tk has been returned");
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
        }


    }

    @Override
    public void enter50tk() {
        if(vendingmachine.getPrice()==50)
        {
            System.out.println("50tk has been inserted and it is the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }


        }
        else if(vendingmachine.getPrice()>50)
        {
            System.out.println("50tk has been inserted and it is not enough");
            vendingmachine.setBalance(50);
            vendingmachine.setCurrentState(vendingmachine.getLessmoneystate());
        }
        else
        {
            System.out.println("50tk has been inserted and it is more than enough");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            int rem=50-vendingmachine.getPrice();
            System.out.println(rem+" tk has been returned");
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
        }

    }

    @Override
    public void enter100tk() {

        if(vendingmachine.getPrice()==100)
        {
            System.out.println("100tk has been inserted and it is the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }


        }
        else if(vendingmachine.getPrice()>100)
        {
            System.out.println("100tk has been inserted and it is not enough");
            vendingmachine.setBalance(100);
            vendingmachine.setCurrentState(vendingmachine.getLessmoneystate());
        }
        else
        {
            System.out.println("100tk has been inserted and it is more than enough");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            int rem=100-vendingmachine.getPrice();
            System.out.println(rem+" tk has been returned");
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
        }

    }
}
class lessMoney implements state
{
    vendingMachine vendingmachine;
    lessMoney(vendingMachine vm)
    { this.vendingmachine=vm;

    }
    @Override
    public void enter5tk() {
        int i=vendingmachine.getBalance();
        if((i+5)==vendingmachine.getPrice())
        {
            System.out.println("5tk has been inserted in less money state and it matches the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            vendingmachine.setBalance(0);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
            else {

                vendingmachine.setCurrentState(vendingmachine.getInitialstate());
            }

        }
        else if( (i+5)>vendingmachine.getPrice())
        {
            System.out.println("5tk has been inserted in less money state and it is more than the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            int rem=i+5-vendingmachine.getPrice();
            System.out.println("vending machine: "+rem+" has been returned..");
            vendingmachine.setBalance(0);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
            else {

                vendingmachine.setCurrentState(vendingmachine.getInitialstate());
            }

        }
        else
        {
            System.out.println("5tk has been inserted in less money state and it is still less than the price..");
            vendingmachine.setBalance(vendingmachine.getBalance()+5);

        }

    }

    @Override
    public void enter10tk() {

        int i=vendingmachine.getBalance();
        if((i+10)==vendingmachine.getPrice())
        {
            System.out.println("10tk has been inserted in less money state and it matches the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            vendingmachine.setBalance(0);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
            else {

                vendingmachine.setCurrentState(vendingmachine.getInitialstate());
            }

        }
        else if( (i+10)>vendingmachine.getPrice())
        {
            System.out.println("10tk has been inserted in less money state and it is more than the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            int rem=i+10-vendingmachine.getPrice();
            System.out.println("vending machine: "+rem+" has been returned..");
            vendingmachine.setBalance(0);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
            else {

                vendingmachine.setCurrentState(vendingmachine.getInitialstate());
            }

        }
        else
        {
            System.out.println("10tk has been inserted in less money state and it is still less than the price..");
            vendingmachine.setBalance(vendingmachine.getBalance()+10);

        }

    }

    @Override
    public void enter50tk() {

        int i=vendingmachine.getBalance();
        if((i+50)==vendingmachine.getPrice())
        {
            System.out.println("50tk has been inserted in less money state and it matches the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            vendingmachine.setBalance(0);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
            else {

                vendingmachine.setCurrentState(vendingmachine.getInitialstate());
            }

        }
        else if( (i+50)>vendingmachine.getPrice())
        {
            System.out.println("50tk has been inserted in less money state and it is more than the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            int rem=i+50-vendingmachine.getPrice();
            System.out.println("vending machine: "+rem+" has been returned..");
            vendingmachine.setBalance(0);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
            else {

                vendingmachine.setCurrentState(vendingmachine.getInitialstate());
            }

        }
        else
        {
            System.out.println("50tk has been inserted in less money state and it is still less than the price..");
            vendingmachine.setBalance(vendingmachine.getBalance()+50);

        }

    }

    @Override
    public void enter100tk() {
        int i=vendingmachine.getBalance();
        if((i+100)==vendingmachine.getPrice())
        {
            System.out.println("100tk has been inserted in less money state and it matches the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            vendingmachine.setBalance(0);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
            else {

                vendingmachine.setCurrentState(vendingmachine.getInitialstate());
            }

        }
        else if( (i+100)>vendingmachine.getPrice())
        {
            System.out.println("100tk has been inserted in less money state and it is more than the price..");
            System.out.println("Here is your product...");
            vendingmachine.setAmount(vendingmachine.getAmount()-1);
            int rem=i+100-vendingmachine.getPrice();
            System.out.println("vending machine: "+rem+" has been returned..");
            vendingmachine.setBalance(0);
            if(vendingmachine.getAmount()<=0)
            {
                vendingmachine.setCurrentState(vendingmachine.getEmptyproductstate());
            }
            else {

                vendingmachine.setCurrentState(vendingmachine.getInitialstate());
            }

        }
        else
        {
            System.out.println("100tk has been inserted in less money state and it is still less than the price..");
            vendingmachine.setBalance(vendingmachine.getBalance()+100);

        }


    }
}
class noProduct implements state
{
    vendingMachine vendingmachine;
    noProduct(vendingMachine vm)
    { this.vendingmachine=vm;

    }
    @Override
    public void enter5tk() {
        System.out.println("vending machine: sorry! our product isn't available anymore");

    }

    @Override
    public void enter10tk() {
        System.out.println("vending machine: sorry! our product isn't available anymore");


    }

    @Override
    public void enter50tk() {
        System.out.println("vending machine: sorry! our product isn't available anymore");

    }

    @Override
    public void enter100tk() {
        System.out.println("vending machine: sorry! our product isn't available anymore");

    }
}
class vendingMachine
{
    private state initialstate;
    private state lessmoneystate;
    private  state emptyproductstate;
    private state currentState;
    private int amount;
    private int balance;
    private int price;

    vendingMachine()
    {
        initialstate=new initialState(this);
        lessmoneystate=new lessMoney(this);
        emptyproductstate=new noProduct(this);
        amount=4;
        price=10;
        balance=0;
        currentState=initialstate;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public state getCurrentState() {
        return currentState;
    }

    public void setCurrentState(state currentState) {
        this.currentState = currentState;
    }

    public state getEmptyproductstate() {
        return emptyproductstate;
    }

    public void setEmptyproductstate(state emptyproductstate) {
        this.emptyproductstate = emptyproductstate;
    }

    public state getInitialstate() {
        return initialstate;
    }

    public void setInitialstate(state initialstate) {
        this.initialstate = initialstate;
    }

    public state getLessmoneystate() {
        return lessmoneystate;
    }

    public void setLessmoneystate(state lessmoneystate) {
        this.lessmoneystate = lessmoneystate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }
    void insert5tk()
    {
        currentState.enter5tk();
    }
    void insert10tk()
    {
        currentState.enter10tk();
    }
    void insert50tk()
    {
        currentState.enter50tk();
    }
    void insert100tk()
    {
        currentState.enter100tk();
    }


}
class Main
{
    public static void main(String[] args)
    {
        vendingMachine vm=new vendingMachine();
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("ENter the amount of money you want to insert into the vending machine..");
            int i=sc.nextInt();
            if(i==-1)
                break;
            if(i==5)
            {
                vm.insert5tk();
            }
            else if(i==10)
            {
                vm.insert10tk();
            }
            else if(i==50)
            {
                vm.insert50tk();
            }
            else if (i==100)
            {
                vm.insert100tk();


            }
            else
            {
                System.out.println("Can't recognize your money.ENter again");
            }

        }
    }
}