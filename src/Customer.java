import java.util.ArrayList;
import java.util.Collections;

// Change Log for Milestone 2
//Customer Menu and Customer classes have been merged
//Methods are no longer statics
//Some properties and methods have been inherited from parent User class
//Added sendAMessage method for User Story 9.1
//Added findAllMessagesOfCurrentCustomer and showCustomersMessages methods for User Story 9.2
//Added deleteAMessage method for VG
public class Customer extends User {
    private Membership membership = Membership.NONE;
    private int storeCredits = 0;

    Customer(String name, String password){
        super(name,password);
    }

    public void sendAMessage(){
        String receiverID = InputClass.askStringInput("Please enter the ID of the user you want to sena a message to: ");
        Customer receiver = (Customer) DartController.searchUserInList(DartController.registeredCustomerList, receiverID);
        if(receiver != null){
            String message = InputClass.askStringInput("Please enter your message: ");
            Message newMessage = new Message(getID(), getName(), receiverID, message);
            DartController.messageList.add(newMessage);
            System.out.println("Your message has been sent successfully!");
        } else {
            System.out.println("Customer with ID: "+ receiverID + " cannot found!");
        }
    }

    private ArrayList<Message> findAllMessagesOfCurrentCustomer(){
        ArrayList<Message> messagesOfCurrentCustomer = new ArrayList<>();
        for(int i=0; i<DartController.messageList.size(); i++){
            if (DartController.messageList.get(i).getRecipientID().equals(getID())){
               messagesOfCurrentCustomer.add(DartController.messageList.get(i));
            }
        }
        //lets sort messages
        for(int i=0; i<messagesOfCurrentCustomer.size()-1; i++){
            for(int j=0; j<messagesOfCurrentCustomer.size()-i-1; j++){
                if(!messagesOfCurrentCustomer.get(j).isAfter(messagesOfCurrentCustomer.get(j+1))){
                    Collections.swap(messagesOfCurrentCustomer, j,j+1);
                }
            }
        }

        return messagesOfCurrentCustomer;
    }

    public ArrayList<Message> showCustomersMessages(){
        ArrayList<Message> messagesOfCurrentCustomer = findAllMessagesOfCurrentCustomer();
        if(messagesOfCurrentCustomer.size() == 0){
            System.out.println("You have no messages in your inbox! ");
            return null;
        }
        else{
            for(int i=0; i<messagesOfCurrentCustomer.size(); i++){
                System.out.println("Message "+ (i+1));
                if (!messagesOfCurrentCustomer.get(i).checkIfIsRead()){
                    System.out.println("Unread");
                    messagesOfCurrentCustomer.get(i).setRead();

                }
                System.out.println(messagesOfCurrentCustomer.get(i).toString());
            }
            return messagesOfCurrentCustomer;
        }
    }

    public void deleteAMessage(){
        ArrayList<Message> messagesOfCurrentCustomer = showCustomersMessages();
        if(messagesOfCurrentCustomer != null){
            int messageIndexToDelete = InputClass.askIntInput("Please enter the index of the message you want to delete: \n(Enter -1 to exit)" );
            while(messageIndexToDelete == 0 || messageIndexToDelete < -1 || messageIndexToDelete > messagesOfCurrentCustomer.size()){
                System.out.println("Invalid input!");
                messageIndexToDelete = InputClass.askIntInput("Please enter the index of the message you want to delete: \n(Enter -1 to exit)" );
            }
            if (messageIndexToDelete != -1){
                DartController.messageList.remove(messageIndexToDelete-1);
                System.out.println("The message you wanted to remove has been deleted");
            }
            else{
                System.out.println("Returning to customer menu...");
            }
        }
    }

    public boolean hasEnoughStoreCredits() {
        if (this.storeCredits >= 5) {
            return true;
        }
        return false;
    }

    // Getters
    public Membership getMembership() {
        return membership;
    }
    public int getStoreCredits() {
        return storeCredits;
    }

    // Setters
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void setStoreCredits(int storeCredits) {
        this.storeCredits = storeCredits;
    }

    public void incrementStoreCredits() {
        this.storeCredits = this.storeCredits + this.membership.getStoreCredits();
    }

    public void useStoreCredits() {
        if (hasEnoughStoreCredits()) {
            this.storeCredits = this.storeCredits - 5;
        }
    }
}
