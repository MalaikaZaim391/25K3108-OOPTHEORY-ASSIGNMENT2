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



public class SparePart {

    //data members
    private final int partId;      // constant
    private String partName;
    private String category;
    private String brand;
    private double price;
    private int stock;

    private static int totalParts = 0;  // static

    //getter
    public double getPrice(){
        return price;
    }

    //paramtererised constructor
    public SparePart(int partId, String partName, String category,
                     String brand, double price, int stock) {

        this.partId = partId;
        this.partName = partName;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        totalParts++;
    }

    public String getCategory() {
        return category;
    }

    //member funcs
    public void updateStock(int quantity) {
        stock += quantity;
    }

    public void reduceStock(int quantity) {
        if (stock >= quantity)
            stock -= quantity;
    }

    public void displayPart() {
        System.out.println(partName + " | Price: " + price);
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public static int getTotalParts() {
        return totalParts;
    }
}
