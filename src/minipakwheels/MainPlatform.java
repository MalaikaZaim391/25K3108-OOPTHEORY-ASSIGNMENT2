package minipakwheels;
import java.util.Comparator;

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


public class MainPlatform {


    //MainPlatform represents the central controller of the system.
    //it follows composition because VehicleMarketplace and AutoStore
    //cannot logically exist without the platform itself.

    //composition: these parts cannot exist independently.
    //mainPlatform "owns" them and controls their lifecycle.
    private final VehicleMarketplace vehicleMarketplace;
    private final AutoStore autoStore;
    //private VehicleMarketplace vehicleMarketplace;  //composition
    //private AutoStore autoStore;                    //composition



    //DataStore is used instead of ArrayList to demonstrate custom generic structure usage
    //and avoid reliance on Java Collections Framework.
    private DataStore<User> users;

    private static final int MAX_USERS = 100;

    private final String platformName;              //constant
    private static int totalPlatforms = 0;

    //parameterised constructor
    public MainPlatform(String platformName) {
        users = new DataStore<>(MAX_USERS);
        this.platformName = platformName;
        vehicleMarketplace = new VehicleMarketplace("Vehicle Section");
        autoStore = new AutoStore("AutoStore Section");
        //users = new User[100];   // array of objects
        //userCount = 0;
        totalPlatforms++;
    }


    //PRIVATE helper to check duplicate email
    //email uniqueness is enforced to maintain system integrity,
    //ensuring no duplicate accounts exist.
    private boolean emailExists(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    //REGISTER BUYER
    public void registerBuyer(int id, String name, String email, String password, String phone,
                              double budget, String location, String mship) {
        if (users.size() >= MAX_USERS) {   // since DataStore capacity = 100
            System.out.println("User limit reached.");
            return;
        }
        if (emailExists(email)) {
            System.out.println("Email already registered.");
            return;
        }
        Buyer buyer = new Buyer(id, name, email, password, phone, budget, location, mship);
        users.add(buyer);
        System.out.println("Buyer registered successfully.");
    }



    //REGISTER SELLER
    public void registerSeller(int id, String name, String email, String password, String phone,
                               String role, String mship) {
        if (users.size()>= MAX_USERS) {
            System.out.println("User limit reached.");
            return;
        }
        if (emailExists(email)) {
            System.out.println("Email already registered.");
            return;
        }
        Seller seller = new Seller(id, name, email, password, phone, role, mship);
        users.add(seller);
        System.out.println("Seller registered successfully.");
    }

    //REGISTER ADMIN
    public void registerAdmin(int id, String name, String email, String password, String phone,
                              int adminLevel, String department) {
        if (users.size() >= MAX_USERS) {
            System.out.println("User limit reached.");
            return;
        }
        if (emailExists(email)) {
            System.out.println("Email already registered.");
            return;
        }
        Admin admin = new Admin(id, name, email, password, phone, adminLevel, department);
        users.add(admin);
        System.out.println("Admin registered successfully.");
    }



    //LOGIN USER
    //polymorphism: returns User type but actual object can be Buyer/Seller/Admin
    public User login(String email, String password) {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return u;   // polymorphism (returns Buyer/Seller/Admin as User)
            }
        }
        System.out.println("Invalid credentials.");
        return null;
    }

    //more member funcs
    public void showPlatformInfo() {
        System.out.println("Platform: " + platformName);
    }
    public VehicleMarketplace getVehicleMarketplace() {
        return vehicleMarketplace;
    }
    public AutoStore getAutoStore() {
        return autoStore;
    }
    public static int getTotalPlatforms() {
        return totalPlatforms;
    }

    public void sortUsersByEmail() {
        users.sort(new Comparator<User>() {   // Anonymous Inner Class used here too
            @Override
            public int compare(User u1, User u2) {
                return u1.getEmail().compareTo(u2.getEmail());
            }
        });

        System.out.println("Users sorted by email successfully.");
    }

    public void swapUsers(int i, int j) {
        users.swap(i, j);
        System.out.println("Users swapped successfully.");
    }

    public int searchUser(User target) {
        return users.search(target);
    }

    public void displayAllUsers() {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).displayInfo();
        }
    }




}