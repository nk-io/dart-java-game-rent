import java.util.ArrayList;
import java.util.Collections;

public class MessageLibrary {
    private ArrayList<Message> messageList = new ArrayList<>();

    public Message sendAMessage(String receiverID, String senderID, String senderName, CustomerLibrary customerLibrary, String message ){
        Customer receiver = (Customer) customerLibrary.doesUserExist(receiverID);
        if(receiver != null){
            Message newMessage = new Message(senderID, senderName, receiverID, message);
            messageList.add(newMessage);
            return newMessage;
        } else {
            return null;
        }
    }

    private ArrayList<Message> findAllMessagesOfCustomer(String customerID){
        ArrayList<Message> messagesOfCurrentCustomer = new ArrayList<>();
        for(int i=0; i<messageList.size(); i++){
            if (messageList.get(i).getRecipientID().equals(customerID)){
                messagesOfCurrentCustomer.add(messageList.get(i));
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

    public String showCustomersMessages(String customerID){
        ArrayList<Message> messagesOfCurrentCustomer = findAllMessagesOfCustomer(customerID);
        if(messagesOfCurrentCustomer.size() == 0){
            return "You have no messages in your inbox! ";
        }
        else{
            StringBuilder builder = new StringBuilder();
            for(int i=0; i<messagesOfCurrentCustomer.size(); i++){
                builder.append("Message "+ (i+1) + " ");
                if (!messagesOfCurrentCustomer.get(i).checkIfIsRead()){
                    builder.append("Unread ");
                    messagesOfCurrentCustomer.get(i).setRead();

                }
                builder.append(messagesOfCurrentCustomer.get(i).toString());
            }
            return builder.toString();
        }
    }

    public void deleteAMessage(String customerID){
        ArrayList<Message> messagesOfCurrentCustomer = findAllMessagesOfCustomer(customerID);
        if(messagesOfCurrentCustomer != null){
            System.out.println(showCustomersMessages(customerID));
            int messageIndexToDelete = InputClass.askIntInput("Please enter the index of the message you want to delete: \n(Enter -1 to exit)" );
            while(messageIndexToDelete == 0 || messageIndexToDelete < -1 || messageIndexToDelete > messagesOfCurrentCustomer.size()){
                System.out.println("Invalid input!");
                messageIndexToDelete = InputClass.askIntInput("Please enter the index of the message you want to delete: \n(Enter -1 to exit)" );
            }
            if (messageIndexToDelete != -1){
                messageList.remove(messageIndexToDelete-1);
                System.out.println("The message you wanted to remove has been deleted");
            }
            else{
                System.out.println("Returning to customer menu...");
            }
        }
    }
}
