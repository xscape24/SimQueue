import java.util.Random;
public class Cashier {

    
    //Objects
    Thread thread=new Thread();
    Random random=new Random();


    // Attributes
    String name;
        int cashierId;
    static int cashierIdCounter = 1;

    boolean isOccupied;
    CashierQueue queue;

    // Constructors
    public Cashier() {
        this.name = name;
        this.cashierId = cashierIdCounter++;
        this.isOccupied = false;
        this.queue=new CashierQueue();
    
    }

    public Cashier(String name) {
        this.name = name;
        this.cashierId = cashierIdCounter++;
        this.isOccupied = false;
          this.queue=new CashierQueue();
    }
    
      public Cashier(CashierQueue queue) {
        this.name = name;
        this.cashierId = cashierIdCounter++;
        this.isOccupied = false;
          this.queue=queue;
    }
    



    // Methods
    public void entersLine() {
        System.out.println("Cashier " + name + " is ready to serve customers.");
    }
 
    public int serveCustomer(Customer customer){
        int randomTime=(random.nextInt(2)+3)*1000;//10 to 30 seconds
    this.isOccupied=true;
    System.out.println("Cashier "+this.cashierId+" is now serving "+ customer.name+".");
        try{
        thread.sleep(randomTime);
        } catch (Exception e){
            System.out.println("Error found.");
        }
System.out.println("Cashier "+ this.cashierId + " is done serving "+ customer.name+". It took "+(randomTime/1000)+" seconds.");
System.out.println( customer.name+" leaves the queue.");
this.isOccupied=false;
return randomTime;

    }
}
