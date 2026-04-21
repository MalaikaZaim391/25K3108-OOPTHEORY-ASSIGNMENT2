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

public class Bike extends MotorizedVehicle implements Taxable, Discountable {
    //data members
    private boolean hasABS;
    private String type;
    private String suspensionType;
    private boolean electric;
    private String fuelType;
    private boolean hasCarrier;

    public Bike(int id, String brand, String model, int year, double price, double mileage,
                int engineCC, String fuelType, boolean hasCarrier) {

        super(id, brand, model, year, price, mileage, engineCC, fuelType);
        this.hasCarrier = hasCarrier;
    }
    // Overloading
    public Bike(int id, String brand, String model, int year, double price) {
        super(id, brand, model, year, price, 0, 0, "Petrol");
        this.hasCarrier = false;
    }

    @Override
    public void displaySpecificDetails() {
        System.out.println("Engine CC: " + engineCC);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Carrier: " + (hasCarrier ? "Yes" : "No"));
    }

    @Override
    public double calculateBasePrice() {
        return getPrice(); // simple logic, acceptable
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.05; // 5% tax
    }

    @Override
    public double applyDiscount(double percent) {
        return getPrice() - (getPrice() * percent / 100);
    }


    //member funcs
    public void checkSportBike() {
        if (engineCC > 600)
            System.out.println("Sports Bike");
    }
    public void enableElectricMode() {
        if (electric)
            System.out.println("Electric mode activated");
    }
    public void displayBikeSpecs() {
        System.out.println("Type: " + type);
    }
    public void compareMileage(Bike other) {
        System.out.println("Comparing mileage.");
    }


}