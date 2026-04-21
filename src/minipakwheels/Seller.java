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




public class Seller extends RegisteredUser {
    //seller extends RegisteredUser because only registered users
    //are allowed to post listings and interact within the marketplace.

    private Listings[] listings;

    //fixed-size array used instead of dynamic collections
    //to demonstrate manual memory handling.
    private int listingCount;
    private double Earnings;
    private int soldCount;
    private double rating;

    //constructors
    //default
    public Seller(){
        super();
        listings = new Listings[10];
        listingCount = 0;
    }
    //parameterised
    public Seller(int id, String name, String email,
                  String password, String contact, String role, String mship){
        super(id, name, email, password, contact, "Seller", mship);
        listings = new Listings[10];
        listingCount = 0;
    }

    //member functions
    public void addListing(Listings listings) {
        this.listings[listingCount++] = listings;
        System.out.println("Listing added.");
    }
    public void updateListing(int index) {
        System.out.println("Listing updated.");
    }
    public void deleteListing(int index) {
        listings[index] = null;
        listingCount--;
        System.out.println("Listing deleted.");
    }
    public void viewMessages() {
        System.out.println("Viewing messages.");
    }


    @Override
    public void performRoleAction() {
        System.out.println("Seller can add, update, and manage listings.");
    }

    @Override
    public void showDashboard() {
        System.out.println(name);
        System.out.println(getEmail());
        System.out.println(listingCount);
        for (int i = 0; i < listingCount; i++) {
            System.out.println(listings[i].getVehicle().getBrand());
        }



    }

}
