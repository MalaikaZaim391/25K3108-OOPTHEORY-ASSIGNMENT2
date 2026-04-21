package minipakwheels;
import java.util.Arrays;
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



public class DataStore<T> {

    //generic DataStore class used to replace raw arrays for better flexibility and reuse.
    //generics allow this structure to store any object type (User, String, etc.)
    //without rewriting the class, demonstrating type abstraction.
    private T[] items;

    //count is maintained manually instead of using dynamic collections
    //to demonstrate understanding of array-based storage management.
    private int count;

    public DataStore(int size) {
        //java does not allow direct generic array creation,
        //so Object[] is used and casted. This is a common workaround.
        items = (T[]) new Object[size];
        count = 0;
    }

    public void add(T item) {
        //manual boundary check instead of dynamic resizing (ArrayList)
        //to maintain control over memory usage as per assignment constraints.
        if (count < items.length) {
            items[count++] = item;
        } else {
            System.out.println("DataStore is full!");
        }
    }

    public T get(int index) {
        if (index >= 0 && index < count) {
            return items[index];
        }
        return null;
    }

    public int size() {
        return count;
    }

    //generic method: Searching using equals()
    public int search(T target) {
        //uses equals() instead of == to ensure logical equality,
        //allowing object comparison based on content (e.g., email in User class)
        for (int i = 0; i < count; i++) {
            if (items[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // Generic method: Swapping elements
    public void swap(int i, int j) {
        if (i >= 0 && i < count && j >= 0 && j < count) {
            T temp = items[i];
            items[i] = items[j];
            items[j] = temp;
        } else {
            System.out.println("Invalid swap indexes.");
        }
    }

    // Generic method: Sorting using Comparator
    public void sort(Comparator<T> comparator) {
        Arrays.sort(items, 0, count, comparator);
    }

    // Utility method (optional but good for demo)
    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}