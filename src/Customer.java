import java.util.ArrayList;

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
    private boolean upgradeRequest = false;
    //private ArrayList<RentalRecord> records = new ArrayList<>();
    private int numOfCurrentRentedItems = 0;

    Customer(String name, String password){
        super(name,password);
    }

    // Getters
    public boolean getUpgradeRequest() { return upgradeRequest; }
    public int getNumOfCurrentRentedItems(){
        return numOfCurrentRentedItems;
    }
    public Membership getMembership() {
        return membership;
    }
    public int getStoreCredits() {
        return storeCredits;
    }
    public double getDiscount() { return membership.getDiscount();}

    // Setters
    public void setMembership(Membership membership) {
        this.membership = membership;
    }
    public void addToNumOfCurrentRentedItems(){
        this.numOfCurrentRentedItems  += 1;
    }
    public void setUpgradeRequest(boolean upgrade) { upgradeRequest = upgrade; }
    public void subFromNumOfCurrentRentedItems(){
        this.numOfCurrentRentedItems -= 1;
    }

    public void addCredits(){
        if (getMembership() == Membership.SILVER){
            storeCredits += 1;
        } else if (getMembership() == Membership.GOLD){
            storeCredits += 2;
        } else if (getMembership() == Membership.PLATINUM){
            storeCredits += 3;
        } else if (getMembership() == Membership.NONE){
            storeCredits += 5;
        }
    }

    /*
    public boolean hasEnoughCreditsToRent() {
        if (this.storeCredits >= 5) {
            return true;
        }
        return false;
    }


    public void incrementStoreCredits() {
        this.storeCredits = this.storeCredits + this.membership.getStoreCredits();
    }

 */

    public void decrementStoreCredits() {
        this.storeCredits = this.storeCredits - 5;
    }

/*
    public void addRecord(RentalRecord record) {
        records.add(record);
    }

    public ArrayList<RentalRecord> getRecords() {
        return records;
    }


    public void showRentalRecords() {
        for (RentalRecord record: records) {
            String ID = record.itemID;
            String userID = record.userID;
            String rentDate = record.rentalDate.toString();
            String returnDate = (record.getReturnDate() != null) ? record.getReturnDate().toString() : "Not returned yet.";
            int credits = record.getStoreCredits();
            System.out.println(
                    "ID: " + ID + "\n" +
                            "userID: " + userID + "\n" +
                            "Rented on: " + rentDate + "\n" +
                            "Returned on: " + returnDate + "\n" +
                            "Credits earned: " + credits);
        }
    }

    public RentalRecord findNonReturnedRecord(String itemId) {
        for (RentalRecord record: records) {
            if (record.getItemID().equals(itemId) && record.getReturnDate() == null) {
                return record;
            }
        }
        return null;
    }

 */
}