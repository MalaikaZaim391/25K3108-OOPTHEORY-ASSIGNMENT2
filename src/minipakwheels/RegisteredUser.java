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



public abstract class RegisteredUser extends User {
    protected String membershipType;

    public RegisteredUser() {
        super(); // calls User default constructor
        this.membershipType = "Standard";
    }

    public RegisteredUser(int id, String name, String email, String password, String contact,
                String role, String membershipType) {
        super(id, name, email, password, contact, role);
        this.membershipType = membershipType;
    }
}