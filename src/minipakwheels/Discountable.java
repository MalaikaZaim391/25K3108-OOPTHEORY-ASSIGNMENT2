package minipakwheels;

//Allows flexible discount logic across different objects
//without forcing them into a rigid class hierarchy.
public interface Discountable {
    public double applyDiscount(double percent);
}