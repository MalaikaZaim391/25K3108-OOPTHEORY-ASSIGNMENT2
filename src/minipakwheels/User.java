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





//abstract class used to enforce a common structure across all user types.
//prevents direct instantiation of generic users.
public abstract class User implements Authenticatable {
    //data members
    //Protected access used so subclasses (Buyer, Seller, Admin)
    //can directly access fields without needing excessive getters.
    protected int userID;
    protected String name;
    protected String email;
    protected String pw;
    protected String phone;
    protected String role;

    //static variable tracks total users across the platform,
    //demonstrating class-level data shared by all instances.
    protected static int totalUsers = 0;

    //getters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return pw;
    }

    //Constructors
    //default
    public User(){
        this.userID = 0;
        this.name = "Anonymous";
        this.email = "Unavailable";
        totalUsers++;
    }
    //parameterised
    public User(int id, String name, String email, String password, String contact, String role){
        this.userID = id;
        this.name = name;
        this.email = email;
        this.pw = password;
        this.phone = contact;
        this.role = role;
        totalUsers++;
    }
    //copy
    public User(User i){
        this.userID = i.userID;
        this.name = i.name;
        this.email = i.email;
        this.pw = i.pw;
        this.phone = i.phone;
        this.role = i.role;
        totalUsers++;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean login(String email, String password) {
        return this.email.equals(email) && this.pw.equals(password);
    }

    //member functions here
    public void logIn(){
        System.out.println(name + " logged in.");
    }
    public void logOut() {
        System.out.println(name + " logged out.");
    }
    public void updateProfile(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void displayInfo() {
        System.out.println("User: " + name + " | Email: " + email);
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public abstract void showDashboard();
    public abstract void performRoleAction();

    //Location is static because it doesn't require a full User object, and can be used independently as a helper structure.
    public static class Location {
        private String city;
        public Location(String city) {
            this.city = city;
        }
        public String getCity() {
            return city;
        }
    }

    //equals() overridden to define logical equality based on email,
    //since email uniquely identifies users in the system.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User other = (User) obj;
        return this.email.equals(other.email);
    }

}
