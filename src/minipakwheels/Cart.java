package minipakwheels;

//INHERITANCE
//Multilevel/heirarchical inheritance used:
//Vehicle → MotorizedVehicle → Car/Truck/Bike
//User → RegisteredUser → Seller/Buyer/Admin
//this reduces redundancy by sharing engine-related properties.

//POLYMORPHISM
//Polymorphism: Vehicle reference used to store different objects
//(Car, Bike, Truck),(seller, buyer) allowing runtime method overriding.

//composition used where lifecycle is dependent (mentioned)
//aggregation used where objects exist independently (mentioned)



public class Cart {
    //data members
    private Buyer buyer;   // aggregation
    private SparePart[] parts;
    private int itemCount;
    private double totalPrice;
    private boolean checkedOut;

    //copy constructor
    public Cart(Buyer buyer) {
        this.buyer = buyer;
        parts = new SparePart[20];   // array of objects
        itemCount = 0;
        totalPrice = 0;
        checkedOut = false;
    }

    //member functions
    public void addPart(SparePart part) {
        parts[itemCount++] = part;
        totalPrice += part.getPrice();
    }
    public void removePart(int index) {
        totalPrice -= parts[index].getPrice();
        parts[index] = null;
        itemCount--;
    }
    public void calculateTotal() {
        System.out.println("Total Price: " + totalPrice);
    }
    public void checkout() {
        checkedOut = true;
        System.out.println("Checkout successful.");
    }

    
}