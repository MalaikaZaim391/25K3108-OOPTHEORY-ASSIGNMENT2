package minipakwheels;
import java.time.LocalDate;


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



public class Order implements Trackable {
    //data members
    private final int orderId;

    //composition: Cart is strongly owned by Order.
    //once order is created, it represents a finalized snapshot of the cart.
    private Cart cart;       // composition

    private LocalDate orderDate;

    //Status is stored as String for simplicity,
    //but could be replaced with enum in larger systems.
    private String status;

    private String paymentMethod;
    private double totalAmount;

    //parameterised constructor
    public Order(int orderId, Cart cart, String paymentMethod) {
        this.orderId = orderId;
        this.cart = cart;
        this.orderDate = LocalDate.now();
        this.paymentMethod = paymentMethod;
        this.status = "Processing";
        this.totalAmount = 0;
    }

    @Override
    public void trackOrder() {
        System.out.println("Order status: " + status);
    }

    //member funcs
    public void confirmOrder() {
        status = "Confirmed";
    }
    public void cancelOrder() {
        status = "Cancelled";
    }
    public void calculateTotal(double amount) {
        totalAmount = amount;
    }
    public void displayOrder() {
        System.out.println("Order ID: " + orderId + " | Status: " + status);
    }

}