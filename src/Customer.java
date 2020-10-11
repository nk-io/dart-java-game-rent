import java.util.ArrayList;

// Change Log for Milestone 2
//Customer Menu and Customer classes have been merged
//Methods are no longer statics
//Some properties and methods have been inherited from parent User class
public class Customer extends User {
    private Membership membership = Membership.NONE;
    private int storeCredits = 0;
    //private ArrayList<RentalRecord> records = new ArrayList<>();
    private ArrayList<Item> currentRentedItemsByCustomer = new ArrayList<>();

    Customer(String name, String password){
        super(name,password);
    }

    // Getters
    public int getNumOfCurrentRentedItems(){
        return currentRentedItemsByCustomer.size();
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
    public void addToCurrentRentedItemsByCustomer(Item item){
        currentRentedItemsByCustomer.add(item);
    }

    public void subFromCurrentRentedItemsByCustomer(Item item){
        currentRentedItemsByCustomer.remove(item);
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
    public String getCurrentRentedGamesByCustomer(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i< currentRentedItemsByCustomer.size(); i++){
            if(currentRentedItemsByCustomer.get(i) instanceof Game) {
                builder.append(currentRentedItemsByCustomer.get(i).toString());
            }
        }
        return builder.toString();
    }
    public String getCurrentRentedAlbumsByCustomer(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i< currentRentedItemsByCustomer.size(); i++){
            if(currentRentedItemsByCustomer.get(i) instanceof Album) {
                builder.append(currentRentedItemsByCustomer.get(i).toString());
            }
        }
        return builder.toString();
    }
    public boolean checkIfTheItemRentedByCustomer(String itemID){
        for(int i=0; i<currentRentedItemsByCustomer.size(); i++){
            if(currentRentedItemsByCustomer.get(i).getID().equals(itemID)){
                return true;
            }
        }
        return false;
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

}