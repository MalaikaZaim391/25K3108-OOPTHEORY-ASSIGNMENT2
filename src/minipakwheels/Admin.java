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

public class Admin extends User{

    //data members
    private int adminLevel;
    private String department;
    private int reportsHandled;
    private boolean superAdmin;
    private Listings[] managedListings;

    //constructors
    //default
    public Admin() {
        super();
        this.adminLevel = 1;
        this.department = "General";
        this.reportsHandled = 0;
        this.superAdmin = false;
        managedListings = new Listings[20];
    }
    //parameterised
    public Admin(int userID, String name, String email,
                 String password, String phone,
                 int adminLevel, String department) {

        super(userID, name, email, password, phone, "Admin");
        this.adminLevel = adminLevel;
        this.department = department;
        this.reportsHandled = 0;
        this.superAdmin = false;
        managedListings = new Listings[20];
    }
    //copy
    public Admin(Admin a) {
        super(a);
        this.adminLevel = a.adminLevel;
        this.department = a.department;
        this.reportsHandled = a.reportsHandled;
        this.superAdmin = a.superAdmin;
        managedListings = new Listings[20];
    }

    //getter
    public int getAdminLevel() {
        return adminLevel;
    }
    //setter
    public void setAdminLevel(int level){this.adminLevel = level;}

    //member functions
    public void approveListing(Listings listings) {
        listings.approve();
        reportsHandled++;
    }
    public void removeListing(Listings listings) {
        listings.remove();
        reportsHandled++;
    }
    public void promoteAdmin() {
        this.adminLevel++;
    }
    public void displayAdminInfo() {
        System.out.println("Admin: " + name + " | Level: " + adminLevel);
    }


    @Override
    public void performRoleAction() {
        System.out.println("Admin can approve and remove listings.");
    }

    @Override
    public void showDashboard() {
        System.out.println(getAdminLevel());
        System.out.println(getTotalUsers());
        System.out.println(managedListings.length);
        System.out.println(reportsHandled);

    }

}
