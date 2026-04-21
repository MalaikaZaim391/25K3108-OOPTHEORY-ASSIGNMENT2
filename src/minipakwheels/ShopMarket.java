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



public class ShopMarket {
    //data members
    private String platformName;
    private User[] users;
    private Listings[] listings;
    private int userCount;
    private int listingCount;
    private final String platformCountry = "Pakistan";

    //constructors
    //parameterised
    public ShopMarket(String name){
        this.platformName = name;
        users = new User[20];
        listings = new Listings[20];
    }

    //member funcs
    public void registerUser(User user) {
        users[userCount++] = user;
    }
    public void addListing(Listings listings) {
        this.listings[listingCount++] = listings;
    }
    public void searchByBrand(String brand) {
        for (int i = 0; i < listingCount; i++) {
            listings[i].displayListing();
        }
    }
    public void displayAllListings() {
        for (int i = 0; i < listingCount; i++) {
            listings[i].displayListing();
        }
    }


}
