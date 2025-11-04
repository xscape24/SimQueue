import java.util.*;

public class Main {
    public static void main (String[]args){
        
        
        //Objects
        Thread thread=new Thread();
        Random random=new Random();
        Scanner scan=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        
        //Variables
        List <String>dataList=new LinkedList<String>();//collects data from simulation
        int totalServiceTime=0,averageServiceTime;
        List<Cashier> cashierList=new LinkedList<>();

        String[]randomNamesArr={//list of random names
            "John", "Michael", "James", "Robert", "William", "Daniel", "Joseph",
            "Charles", "Thomas", "Christopher", "Matthew", "Anthony", "Mark", "Joshua",
            "Andrew", "Ryan", "Kevin", "Brian", "Justin", "Brandon", "Jacob", "Nicholas",
            "Tyler", "Jonathan", "Eric", "Stephen", "Adam", "Benjamin", "Nathan",
            "Jason", "Patrick", "Zachary", "Samuel", "Alexander", "Ethan", "Logan",
            "Aaron", "Jordan", "Kyle", "Sean", "Dylan", "Connor", "Luke", "Evan",
            "Noah", "Hunter", "Caleb", "Cameron", "Austin", "Ian", "Gavin", "Adrian",
            "Leo", "Owen", "Miles", "Cole", "Liam", "Elijah", "Mason", "Julian",
            "Wyatt", "Seth", "Spencer", "Elliot", "Troy", "Dean", "Blake", "Grant",
            "Chase", "Max", "Nolan", "Gabriel", "Isaac", "Tristan", "Dominic", "Xavier",
            "Vincent", "Simon", "Riley", "Malcolm", "Derek", "Micah", "Damian", "Felix",
            "Hugo", "Oliver", "Carter", "Jesse", "Reid", "Levi", "Arthur", "Sebastian",
            "Jonah", "Elias", "Calvin", "Wesley", "Luca", "Nathaniel", "Marcus", "Victor",
            "Mary", "Sarah", "Jessica", "Emily", "Ashley", "Amanda", "Jennifer", "Elizabeth",
            "Megan", "Lauren", "Nicole", "Rachel", "Hannah", "Samantha", "Olivia", "Emma",
            "Abigail", "Sophia", "Isabella", "Ava", "Mia", "Grace", "Chloe", "Ella",
            "Natalie", "Victoria", "Lily", "Zoe", "Anna", "Julia", "Madison", "Kayla",
            "Brianna", "Alexis", "Katherine", "Hailey", "Amber", "Brooke", "Danielle",
            "Claire", "Savannah", "Caroline", "Faith", "Naomi", "Jasmine", "Alyssa",
            "Maria", "Taylor", "Alexa", "Sydney", "Paige", "Gabriella", "Eva", "Isabelle",
            "Sienna", "Lucy", "Nora", "Leah", "Audrey", "Caitlyn", "Skylar", "Mackenzie",
            "Valeria", "Bella", "Ivy", "Aria", "Lydia", "Daisy", "Willow", "Stella",
            "Hazel", "Piper", "Autumn", "Riley", "Clara", "Faith", "Delilah", "Elena",
            "Jade", "Ruby", "Serena", "Molly", "Camila", "Alice", "Adeline", "Violet",
            "Eleanor", "Rosie", "Marina", "Lila", "Cecilia", "Summer", "Tessa", "Luna",
            "Gianna", "Harper", "Ariana", "Valentina", "Penelope", "Maeve", "Isla", "Elsie"
        };

        
        List<String>randomNames=Arrays.asList(randomNamesArr);
        List<String>randomNamesList=new ArrayList<>(randomNames);



        
        System.out.println("Welcome to the Supermarket Simulator. ");
        try {
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        System.out.println("Click any key to begin");
        
        int numOfCashier=random.nextInt(3)+3;// generates random number of cashiers bound goes from 3-5 cashiers
        
        dataList.add(("Number of Cashiers: "+numOfCashier).toString());
System.out.println("Calling all Cashiers");
        for(int i=0;i<numOfCashier;i++){
 Cashier cashier=new Cashier(new CashierQueue());
 cashierList.add(cashier);

 System.out.println("Cashier " +cashier.cashierId+ " is at queue "+cashier.queue.queueID +".");
        }
       
      
    WaitingLine line=new WaitingLine();
        
        
        String customerName;
      int randomIndex;
        int numOfCustomers=random.nextInt(6)+5; //5 to 10 (bound goes from 0-6 add 5 to both is 5-10)
        
                dataList.add(("Number of Customers: "+numOfCustomers).toString());

                System.out.println(dataList.getLast());
   for(int i=0;i<numOfCustomers;i++){
randomIndex=random.nextInt(randomNamesList.size());
            customerName=randomNamesList.get(randomIndex);
            randomNamesList.remove(randomIndex);
                   Customer customer=new Customer(customerName);
            line.line.add(customer);
            
                System.out.println(customer.name +" has entered the line.");

   }

   for(int i=0;i<cashierList.size();i++){//fills up available cashiers with customers
    cashierList.get(i).serveCustomer(line.line.poll());
   }
       
   
   

   while( line.line.size()>0) {// Simulation Starts
    
            for (int i=0;i<cashierList.size();i++){
                if(cashierList.get(i).isOccupied==true){
                    continue;
                }
                else {
                    int m=cashierList.get(i).serveCustomer(line.line.poll());
                    totalServiceTime+=m;
                    if(line.line.isEmpty()){
                        break;
                    }
                    
                }
            }
          
            
       
            
            
        }

  
    
    

      System.out.println("The simulation is complete!");
        dataList.add("Average Service Time : "+((totalServiceTime/numOfCustomers)/1000)+" seconds");
        printData(dataList);

    
}
    public static void printData(List<String>dataList){
        System.out.println("--Simulation Information--");
        for(String data: dataList){
System.out.println(data);
        }

    }
    
    
    
}
