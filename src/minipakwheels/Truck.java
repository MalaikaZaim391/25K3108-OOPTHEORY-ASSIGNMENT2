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



public class Truck extends MotorizedVehicle implements Taxable, Discountable {
    private double loadCapacity;

    public Truck(int id, String brand, String model, int year, double price, double mileage,
                 int engineCC, String fuelType, double loadCapacity) {

        super(id, brand, model, year, price, mileage, engineCC, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displaySpecificDetails() {
        System.out.println("Engine CC: " + engineCC);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Truck Load Capacity: " + loadCapacity + " tons");
    }

    @Override
    public double calculateBasePrice() {
        return getPrice(); // simple logic, acceptable
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.15; // 15% tax
    }

    @Override
    public double applyDiscount(double percent) {
        return getPrice() - (getPrice() * percent / 100);
    }


}