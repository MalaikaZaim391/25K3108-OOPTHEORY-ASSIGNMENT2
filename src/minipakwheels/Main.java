package minipakwheels;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("     FAST WHEELS SYSTEM - ASSIGNMENT 2 DEMO");
        System.out.println("========================================\n");

        // =====================================================
        // 1. SYSTEM INITIALIZATION (COMPOSITION)
        // =====================================================
        System.out.println(">>> SYSTEM INITIALIZATION (Composition)\n");

        MainPlatform platform = new MainPlatform("FAST Wheels");

        // =====================================================
        // 2. USER REGISTRATION (INHERITANCE)
        // =====================================================
        System.out.println(">>> USER REGISTRATION (Inheritance)\n");

        platform.registerBuyer(1, "Ali", "ali@gmail.com", "123", "0300", 5000000, "Karachi", "Standard");
        platform.registerSeller(2, "Ahmed", "ahmed@gmail.com", "456", "0311", "Seller", "Standard");
        platform.registerAdmin(3, "Admin", "admin@gmail.com", "789", "0322", 5, "Listings");

        System.out.println("\nAll Registered Users:");
        platform.displayAllUsers();

        // =====================================================
        // 3. GENERICS DEMO (SORT, SWAP, SEARCH)
        // =====================================================
        System.out.println("\n>>> GENERICS DEMO (DataStore)\n");

        System.out.println("Before Sorting:");
        platform.displayAllUsers();

        platform.sortUsersByEmail();

        System.out.println("\nAfter Sorting:");
        platform.displayAllUsers();

        System.out.println("\nBefore Swap:");
        platform.displayAllUsers();

        platform.swapUsers(0, 1);

        System.out.println("\nAfter Swap:");
        platform.displayAllUsers();

        System.out.println("\nSearch Demo:");
        User target = platform.login("ali@gmail.com", "123");
        int index = platform.searchUser(target);

        if (index != -1) {
            System.out.println("User found at index: " + index);
        }

        // =====================================================
        // 4. LOGIN SYSTEM (INTERFACE)
        // =====================================================
        System.out.println("\n>>> LOGIN SYSTEM (Authenticatable Interface)\n");

        User sellerUser = platform.login("ahmed@gmail.com", "456");
        User buyerUser = platform.login("ali@gmail.com", "123");
        User adminUser = platform.login("admin@gmail.com", "789");

        // =====================================================
        // 5. DASHBOARDS (POLYMORPHISM - OVERRIDING)
        // =====================================================
        System.out.println("\n>>> DASHBOARDS (Method Overriding)\n");

        sellerUser.showDashboard();
        buyerUser.showDashboard();
        adminUser.showDashboard();

        // =====================================================
        // 6. VEHICLE SYSTEM (ABSTRACTION + INHERITANCE)
        // =====================================================
        System.out.println("\n>>> VEHICLE SYSTEM\n");

        Vehicle car = new Car(101, "Toyota", "Corolla", 2022, 3500000, 15000, 1800, "Petrol", 4, true);
        Vehicle bike = new Bike(102, "Honda", "CD70", 2020, 120000, 8000, 70, "Petrol", true);
        Vehicle truck = new Truck(103, "Hino", "500 Series", 2021, 9500000, 20000, 5000, "Diesel", 12);

        System.out.println("\n--- Car ---");
        car.displayDetails();
        car.displaySpecificDetails();

        System.out.println("\n--- Bike ---");
        bike.displayDetails();
        bike.displaySpecificDetails();

        System.out.println("\n--- Truck ---");
        truck.displayDetails();
        truck.displaySpecificDetails();

        // =====================================================
        // 7. INTERFACES (TAX + DISCOUNT)
        // =====================================================
        System.out.println("\n>>> INTERFACES (Taxable + Discountable)\n");

        System.out.println("Car Tax: " + ((Taxable) car).calculateTax(3500000));
        System.out.println("Discounted Price: " + ((Discountable) car).applyDiscount(10));

        // =====================================================
        // 8. MARKETPLACE FLOW
        // =====================================================
        System.out.println("\n>>> MARKETPLACE SYSTEM\n");

        Seller seller = (Seller) sellerUser;

        Listings l1 = new Listings(201, car, seller);
        Listings l2 = new Listings(202, bike, seller);

        platform.getVehicleMarketplace().addListing(l1);
        platform.getVehicleMarketplace().addListing(l2);

        seller.addListing(l1);
        seller.addListing(l2);

        System.out.println("\nAll Listings:");
        platform.getVehicleMarketplace().displayAllListings();

        // ADMIN ACTION
        System.out.println("\nAdmin Approves Listing:");
        Admin admin = (Admin) adminUser;
        admin.approveListing(l1);

        // BUYER ACTION
        System.out.println("\nBuyer Searches Toyota:");
        Buyer buyer = (Buyer) buyerUser;
        platform.getVehicleMarketplace().searchByBrand("Toyota");

        Favourite fav = new Favourite(301, buyer, car);
        buyer.saveFavourite(fav);

        Message msg = new Message(401, buyer, seller, "Is this available?");
        buyer.sendMessage(msg);

        // =====================================================
        // 9. AUTO STORE
        // =====================================================
        System.out.println("\n>>> AUTO STORE\n");

        SparePart part = new SparePart(501, "Engine Oil", "Lubricants", "Shell", 5000, 20);
        PartListing pl = new PartListing(601, part, seller);

        platform.getAutoStore().addPartListing(pl);

        System.out.println("\nAll Parts:");
        platform.getAutoStore().displayAllParts();

        System.out.println("\nSearch Category: Lubricants");
        platform.getAutoStore().searchByCategory("Lubricants");

        // =====================================================
        // 10. ORDER SYSTEM (INTERFACE)
        // =====================================================
        System.out.println("\n>>> ORDER SYSTEM\n");

        Cart cart = new Cart(buyer);
        cart.addPart(part);

        Order order = new Order(701, cart, "COD");
        order.calculateTotal(5000);
        order.trackOrder();

        // =====================================================
        // 11. INNER CLASSES
        // =====================================================
        System.out.println("\n>>> INNER CLASSES\n");

        // Member Inner
        Vehicle.Engine engine = car.new Engine(180);
        engine.showEngineDetails();

        // Static Nested
        User.Location loc = new User.Location("Karachi");
        System.out.println("Location: " + loc.getCity());

        // Local Inner
        class Logger {
            void log(String msg) {
                System.out.println("[LOG]: " + msg);
            }
        }
        new Logger().log("Local inner class working");

        // Anonymous Inner
        System.out.println("\nAnonymous Sorting:");
        platform.sortUsersByEmail();
        platform.displayAllUsers();

        // =====================================================
        // 12. GENERIC CLASS (DIRECT DEMO)
        // =====================================================
        System.out.println("\n>>> GENERIC CLASS DIRECT DEMO\n");

        DataStore<String> ds = new DataStore<>(5);

        ds.add("Zara");
        ds.add("Ali");
        ds.add("Ahmed");

        System.out.println("Before Sort:");
        ds.displayAll();

        ds.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println("\nAfter Sort:");
        ds.displayAll();

        System.out.println("\nSearch 'Ali' Index: " + ds.search("Ali"));

        // =====================================================
        // END
        // =====================================================
        System.out.println("\n========================================");
        System.out.println("        DEMO COMPLETED SUCCESSFULLY");
        System.out.println("========================================");
    }
}