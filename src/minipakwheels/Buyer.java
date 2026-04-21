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



//inherits user cuz all buyers are users first
public class Buyer extends RegisteredUser {
    //array
    private Favourite[] favourites;

    private int favouriteCount;
    private double budget;
    private String location;
    private Message[] messages;
    private int messageCount;

    //constructors
    //default
    public Buyer(){
        super();
        favourites = new Favourite[10]; //requirement of array of objs
        messages = new Message[10];
        favouriteCount = 0;
        messageCount = 0;
    }
    //parameterised
    public Buyer(int userID, String name, String email, String pw, String phone, double budget, String location, String mship){
        super(userID, name, email, pw, phone, "Buyer", mship);
        this.budget = budget;
        this.location = location;
        favourites = new Favourite[10];
        messages = new Message[10];
        favouriteCount = 0;
        messageCount = 0;
    }

    //member functions
    public void saveFavourite(Favourite fav) {
        favourites[favouriteCount++] = fav;
        System.out.println("Vehicle added to favorites.");
    }
    public void removeFavourite(int index) {
        favourites[index] = null;
        favouriteCount--;
    }
    public void searchVehicle(String brand) {
        System.out.println("Searching for brand: " + brand);
    }
    public void sendMessage(Message msg) {
        messages[messageCount++] = msg;
        System.out.println("Message sent.");
    }


    @Override
    public void performRoleAction() {
        System.out.println("Buyer can browse, save favourites, and send messages.");
    }

    @Override
    public void showDashboard() {
        System.out.println("Vehicles with favourites. ");
        System.out.println(favouriteCount);
        for (int i = 0; i < favouriteCount; i++) {
            System.out.println(favourites[i]);
        }
        System.out.println(budget);
        System.out.println(location);

    }

    
}
