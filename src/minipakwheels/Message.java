package minipakwheels;
import java.time.LocalDateTime;


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


public class Message {
    //aggregation: sender and receiver exist independently of Message.
    private final int messageId;   //constant
    private User sender;           //aggregation
    private User receiver;         //aggregation
    private String content;

    //timestamp uses LocalDateTime to automatically capture real-time data
    //instead of manually storing date/time strings.
    private LocalDateTime timestamp;
    private boolean isRead;

    //constructors
    //default
    public Message() {
        this.messageId = 0;
        this.content = "";
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }
    //parameterised
    public Message(int messageId, User sender, User receiver, String content) {
        this.messageId = messageId;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }
    //copy
    public Message(Message m) {
        this.messageId = m.messageId;
        this.sender = m.sender;
        this.receiver = m.receiver;
        this.content = m.content;
        this.timestamp = m.timestamp;
        this.isRead = m.isRead;
    }

    //member funcs
    public void send() {
        //uses getter instead of direct field access to preserve encapsulatio
        System.out.println("Message sent from " + sender.getName());
    }
    public void markAsRead() {
        isRead = true;
    }
    public void deleteMessage() {
        content = "Deleted";
    }
    public void displayMessage() {
        System.out.println("Message: " + content + " | Time: " + timestamp);
    }
    public int getMessageId() {
        return messageId;
    }


}
