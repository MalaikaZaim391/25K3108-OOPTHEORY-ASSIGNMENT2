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



public class VehicleMarketplace {

    //fixed-size array used to store listings,
    //avoiding ArrayList to meet assignment constraints.
    private Listings[] listings;


    private int listingCount;
    private String marketplaceName;
    private static int totalMarketplaces = 0;
    private final String category = "Vehicles";   // constant

    //parameterised constructor
    public VehicleMarketplace(String name) {
        this.marketplaceName = name;
        listings = new Listings[50];
        listingCount = 0;
        totalMarketplaces++;
    }

    //getter+setter
    public void setMarketplaceName(String name){
        this.marketplaceName = name;
    }
    public int getListingCount(){
        return listingCount;
    }

    //member funcs
    public void addListing(Listings listings) {
        this.listings[listingCount++] = listings;
    }
    public void removeListing(int index) {
        listings[index] = null;
        listingCount--;
    }
    public Listings getListingAtIndex(int index) {
        return listings[index];
    }


    //case-insensitive comparison improves usability for users
    //when searching vehicles.
    public void searchByBrand(String brand) {
        for (int i = 0; i < listingCount; i++) {
            if (listings[i] != null &&
                    listings[i].getVehicle().getBrand().equalsIgnoreCase(brand)) {
                listings[i].displayListing();
            }
        }
    }

    public void filterByPrice(double min, double max) {
        for (int i = 0; i < listingCount; i++) {
            if (listings[i] != null) {
                double price = listings[i].getVehicle().getPrice();
                if (price >= min && price <= max) {
                    listings[i].displayListing();
                }
            }
        }
    }

    public void filterByYear(int year) {
        for (int i = 0; i < listingCount; i++) {
            if (listings[i] != null &&
                    listings[i].getVehicle().getYear() == year) {
                listings[i].displayListing();
            }
        }
    }
    public void updateListingPrice(int listingId, double newPrice) {
        for (int i = 0; i < listingCount; i++) {
            if (listings[i] != null && listings[i].getListingID() == listingId) {
                listings[i].getVehicle().setPrice(newPrice);
                System.out.println("Listing updated successfully.");
                return;
            }
        }
        System.out.println("Listing not found.");
    }
    public void deleteListing(int listingId) {
        for (int i = 0; i < listingCount; i++) {
            if (listings[i] != null && listings[i].getListingID() == listingId) {
                for (int j = i; j < listingCount - 1; j++) {
                    listings[j] = listings[j + 1];
                }
                listings[--listingCount] = null;
                System.out.println("Listing deleted successfully.");
                return;
            }
        }
        System.out.println("Listing not found.");
    }

    public static int getTotalMarketplaces() {
        return totalMarketplaces;
    }

    public void displayAllListings(){
        for (int i = 0; i < listingCount; i++) {
            if (listings[i] != null) {
                listings[i].displayListing();
            }
        }
    }


}
