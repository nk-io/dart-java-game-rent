//created this class for Epic Feature 9
import java.time.Instant;

class Message {
    private String ID;
    private String senderID;
    private String senderName;
    private String recipientID;
    private String message;
    private boolean isRead;
    private Instant date;

    //constructor gets senderName since we create messages inside of customer class and we now the name of the sender customer
    Message(String senderID, String senderName, String recipientID, String message){
        this.ID=RandomUID.generateRandomID();
        this.senderID=senderID;
        this.senderName=senderName;
        this.recipientID=recipientID;
        this.message=formatLongMessage(message);
        this.isRead=false;
        this.date = Instant.now();
    }
    public String getID() {
        return ID;
    }
    public String getSenderID() {
        return senderID;
    }
    public String getSenderName(){
        return senderName;
    }
    public String getRecipientID(){
        return recipientID;
    }
    public boolean checkIfIsRead(){
        return isRead;
    }
    public void setRead(){
        isRead=true;
    }
    public boolean isAfter(Message otherMessage){
        return date.isAfter(otherMessage.date);
    }

    //Method that inserts new lines at first space after 55 characters to increase readability of longer messages.
    private String formatLongMessage(String inputMessage){
        StringBuilder textToFormat = new StringBuilder(inputMessage);
        int pointer = 0;
        while ((pointer = textToFormat.indexOf(" ", pointer + 55)) != -1) {
            textToFormat.replace(pointer, pointer + 1, "\n");
        }
        return textToFormat.toString();
    }

    @Override
    public String toString() {
        return  "Sender: " + getSenderName() + "\n" +
                "Sender ID: " + senderID + '\n' +
                "Message: " + '\n' +
                message + '\n';

    }
}