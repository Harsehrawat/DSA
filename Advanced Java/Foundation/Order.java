package Foundation;

class Order {
    // what does it know/ contains
    private String id;
    private double amount;
    private boolean paid;
    

    // constructor..
    public Order( String id, double amount, boolean paid){
        this.id = id;
        this.amount = amount;
        this.paid = paid;
    }

    // contract for Order..( things expected to do..)
    public String getId(){ return id; }
    public double getAmount() { return amount; }
    public boolean isPaid() { return paid; }
}