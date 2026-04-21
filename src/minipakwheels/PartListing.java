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



public class PartListing {
    //data members
    private final int listingId;
    private SparePart part;    // composition
    private Seller seller;     // aggregation
    private String status;
    private int views;
    private boolean featured;


    //parameterised constructor
    public PartListing(int listingId, SparePart part, Seller seller) {
        this.listingId = listingId;
        this.part = part;
        this.seller = seller;
        this.status = "Pending";
        this.views = 0;
        this.featured = false;
    }

    public SparePart getPart() {
        return part;
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
    public void makeFeatured() {
        featured = true;
    }
    public void displayListing() {
        part.displayPart();
        System.out.println("Status: " + status);
    }


}