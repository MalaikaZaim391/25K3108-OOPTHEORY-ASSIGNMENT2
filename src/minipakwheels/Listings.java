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



public class Listings {
    private final int listingID;   //constant

    //composition: Vehicle is strongly owned by Listing.
    //if listing is deleted, the vehicle is assumed unavailable in marketplace.
    private Vehicle vehicle;       //composition - vehicle depends on listing, no listing no vehicle

    //aggregation: Seller exists independently of Listing.
    private Seller seller;         //aggregation - seller exists independently

    private String status;
    private int views;

    //static counter used to track total listings platform-wide,
    //demonstrating use of class-level shared data.
    private static int totalListings = 0;

    //getters
    public Vehicle getVehicle() {
        return vehicle;
    }
    public int getListingID() {
        return listingID;
    }

    //constructors
    //parameterised
    public Listings(int listingId, Vehicle vehicle, Seller seller) {
        this.listingID = listingId;
        this.vehicle = vehicle;
        this.seller = seller;
        this.status = "Pending";
        totalListings++;
    }

    //member funcs
    public void approve() {
        status = "Approved";
    }
    public void remove() {
        status = "Removed";
    }
    public void incrementViews() {
        views++;
    }
    public void displayListing() {
        vehicle.displayDetails();
        System.out.println("Status: " + status);
    }
    public static int getTotalListings() {
        return totalListings;
    }



}
