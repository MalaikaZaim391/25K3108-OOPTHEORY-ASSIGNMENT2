package minipakwheels;


//ALLOWS FLEXIBLE LOGIC IMPLEMENTATION ACROSS DIFFERENT CLASSES
public interface Authenticatable {
    boolean login(String email, String password);
}
