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



public class Car extends MotorizedVehicle implements Taxable, Discountable {
        //data members
        private String transmission;
        private int engineCapacity;
        private String bodyType;
        private int numberOfDoors;
        private boolean automatic;



    public Car(int id, String brand, String model, int year, double price, double mileage,
               int engineCC, String fuelType, int doors, boolean automatic) {

        super(id, brand, model, year, price, mileage, engineCC, fuelType);
        this.numberOfDoors = doors;
        this.automatic = automatic;
    }
    /*public Car() {
        super(0, "unknown", "unknown", 2003, 0, "56");
    }

    public Car(int id, String brand, String model) {
        super(id, brand, model, 0, 0, "Unknown");
    }

        //parameterised constructor
        public Car(int vehicleId, String brand, String model, int year, double price, double mileage,
                   String fuelType, String transmission, int engineCapacity, String bodyType, int doors,
                   boolean automatic) {
            //inheriting attributes from vehicle class
            super(vehicleId, brand, model, year, price, mileage, engineCapacity, fuelType);
            this.fuelType = fuelType;
            this.transmission = transmission;
            this.engineCapacity = engineCapacity;
            this.bodyType = bodyType;
            this.numberOfDoors = doors;
        }*/

    // Overloading (Polymorphism)
    public Car(int id, String brand, String model, int year, double price) {
        super(id, brand, model, year, price, 0, 0, "Unknown");
        this.numberOfDoors = 4;
        this.automatic = false;
    }


    @Override
    public void displaySpecificDetails() {
        System.out.println("Engine CC: " + engineCC);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Transmission: " + (automatic ? "Automatic" : "Manual"));
    }

    @Override
    public double calculateBasePrice() {
        return getPrice(); // simple logic, acceptable
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.10; // example tax 10%
    }

    @Override
    public double applyDiscount(double percent) {
        return getPrice() - (getPrice() * percent / 100);
    }



    //member funcs
    public void compareCar(Car other) {
            System.out.println("Comparing with another car.");
        }
    public void checkLuxury() {
        if (engineCapacity > 2000)
            System.out.println("Luxury Car");
    }

    public void showSpecifications() {
            System.out.println("Fuel: " + fuelType + " | Transmission: " + transmission);
    }

    /*@Override
    double calculateTax(double price) {
        System.out.println("Tax calculated 5%");
        return price*0.05;
    }

    int percent = 7;
    @Override
    double applyDiscount(int percent) {
        System.out.println("Discount applied 7%");
        return getPrice()*0.07;
    }*/


}
