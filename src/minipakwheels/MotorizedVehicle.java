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



public abstract class MotorizedVehicle extends Vehicle{
    protected int engineCC;
    protected String fuelType;


    public MotorizedVehicle(int id, String brand, String model, int year, double price, double mileage, int engineCC, String fuelType) {
        super(id, brand, model, year, price, mileage);
        this.engineCC = engineCC;
        this.fuelType = fuelType;
    }
}