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



//abstract class ensures that all vehicle types implement
//their own specific details while sharing common attributes.
public abstract class Vehicle {
    //data members
    private final int vehicleID;
    private String brand;
    private String model;
    private int year;
    private double price;
    private double mileage;

    //getter + setter
    public void setPrice(double price) {
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public double getMileage() {
        return mileage;
    }

    //constructors
    //parameterised
    public Vehicle(int vehicleId, String brand, String model, int year, double price, double mileage) {
        this.vehicleID = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

    //abstraction
    //abstract method forces subclasses (Car, Bike, Truck)
    //to implement their own specific behavior.
    public abstract void displaySpecificDetails();

    //added abstraction for pricing logic across all vehicles,
    //ensuring consistent structure for future extensions.
    public abstract double calculateBasePrice();

    //member funcs
    public void updatePrice(double price) {
        this.price = price;
    }
    public void displayDetails() {
        System.out.println("ID: " + vehicleID);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("Mileage: " + mileage);
    }
    public boolean isAvailable() {
        return true;
    }
    public int getVehicleId() {
        return vehicleID;
    }

    //composition: Engine is tightly bound to Vehicle,
    //meaning it cannot exist independently.
    //Engine is a member inner class because it cannot logically exist without a Vehicle (strong "has-a" relationship).
    public class Engine {
        private int horsepower;

        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }

        public void showEngineDetails() {
            System.out.println("Horsepower: " + horsepower);
        }
    }

}
