public class Customer {
    // Attributes
    String name;
    static int customerIdCounter = 1;
    int customerId;

    // Constructors
    public Customer() {
        this.name = "Customer" + customerIdCounter;
        this.customerId = customerIdCounter++;
    }

    public Customer(String name) {
        this.name = name;
        this.customerId = customerIdCounter++;
    }

    // Methods
    public void enterStore() {
        System.out.println(name + " enters the store.");
    }

    public void leaveStore() {
        System.out.println(name + " leaves the store.");
    }
}
