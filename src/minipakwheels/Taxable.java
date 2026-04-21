package minipakwheels;

//Interface used to enforce tax calculation behavior
//across multiple vehicle types without inheritance constraints.
public interface Taxable {
    public double calculateTax(double price);
}