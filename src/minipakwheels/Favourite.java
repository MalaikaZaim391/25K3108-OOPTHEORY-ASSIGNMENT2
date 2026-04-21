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



public class Favourite {

    //data members
    private final int favouriteId;    // constant

    //aggregation used because Buyer and Vehicle exist independently.
    //favourite simply links them without owning their lifecycle.
    private Buyer buyer;             // aggregation
    private Vehicle vehicle;         // aggregation

    //LocalDate used instead of String for better type safety
    //and built-in date operations.
    private LocalDate dateAdded;
    private String note;
    private boolean notificationEnabled;

    //constructors
    //default
    public Favourite() {
        this.favouriteId = 0;
        this.dateAdded = LocalDate.now();
        this.notificationEnabled = true;
    }
    //parameterised
    public Favourite(int id, Buyer buyer, Vehicle vehicle) {
        this.favouriteId = id;
        this.buyer = buyer;
        this.vehicle = vehicle;
        this.dateAdded = LocalDate.now();
        this.notificationEnabled = true;
    }
    //copy
    public Favourite(Favourite f) {
        this.favouriteId = f.favouriteId;
        this.buyer = f.buyer;
        this.vehicle = f.vehicle;
        this.dateAdded = f.dateAdded;
        this.note = f.note;
        this.notificationEnabled = f.notificationEnabled;
    }

    //member funcs
    public void addNote(String note) {
        this.note = note;
    }
    public void removeFavourite() {
        this.vehicle = null;
    }
    public void toggleNotification() {
        notificationEnabled = !notificationEnabled;
    }
    public void displayFavourite() {
        vehicle.displayDetails();
    }
    public int getFavouriteId() {
        return favouriteId;
    }


}
