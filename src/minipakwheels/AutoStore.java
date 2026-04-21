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


public class AutoStore {
    //data members
    private PartListing[] partListings;
    private int listingCount;
    private String storeName;
    private static int totalStores = 0;
    //constant data member
    private final String category = "Spare Parts";

    //parameterised constructor
    public AutoStore(String storeName) {
        this.storeName = storeName;
        partListings = new PartListing[50];
        listingCount = 0;
        totalStores++;
    }

    //member funcs
    public void addPartListing(PartListing listing) {
        partListings[listingCount++] = listing;
    }
    public void removePartListing(int index) {
        partListings[index] = null;
        listingCount--;
    }
    public void searchByCategory(String category) {
        for (int i = 0; i < listingCount; i++) {
            if (partListings[i] != null &&
                    partListings[i].getPart().getCategory().equalsIgnoreCase(category)) {
                partListings[i].displayListing();
            }
        }
    }
    public void displayAllParts() {
        for (int i = 0; i < listingCount; i++) {
            partListings[i].displayListing();
        }
    }
    public static int getTotalStores() {
        return totalStores;
    }


}