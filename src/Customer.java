import membership.*;

import java.util.ArrayList;

// Change Log for Milestone 2
//Customer Menu and Customer classes have been merged
//Methods are no longer statics
//Some properties and methods have been inherited from parent User class
class Customer extends User {
    private Membership membership = new RegularMembership();
    private int storeCredits = 0;
    private boolean upgradeRequest = false;
    private ArrayList<Item> currentRentedItemsByCustomer = new ArrayList<>();

    Customer(String name, String password){
        super(name,password);
    }

    // Getters
    public boolean getUpgradeRequest() { return upgradeRequest; }
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
    public void setUpgradeRequest(boolean upgrade) { upgradeRequest = upgrade; }
    public void subFromCurrentRentedItemsByCustomer(Item item){
        currentRentedItemsByCustomer.remove(item);
    }

    public String getCurrentRentedGamesByCustomer(){
        StringBuilder builder = new StringBuilder();
        for (Item item : currentRentedItemsByCustomer) {
            if (item instanceof Game) {
                builder.append(item.toString());
            }
        }
        return builder.toString();
    }

    public String getCurrentRentedAlbumsByCustomer(){
        StringBuilder builder = new StringBuilder();
        for (Item item : currentRentedItemsByCustomer) {
            if (item instanceof Album) {
                builder.append(item.toString());
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

    public ArrayList getItemsIDs(){
        ArrayList<String> itemsId = new ArrayList<>();
        for(int i=0; i< currentRentedItemsByCustomer.size(); i++){
            itemsId.add(currentRentedItemsByCustomer.get(i).getID());
        }
        return itemsId;
    }

    public void incrementStoreCredits() {
        this.storeCredits = this.storeCredits + this.membership.getStoreCreditsPerRental();
    }

    public void decrementStoreCredits() {
        this.storeCredits = this.storeCredits - 5;
    }

    public void upgradeCustomer(){
        if (getMembership() instanceof RegularMembership) {
            setMembership(new SilverMembership());
        } else if (getMembership() instanceof SilverMembership) {
            setMembership(new GoldMembership());
        } else if (getMembership() instanceof GoldMembership) {
            setMembership(new PlatinumMembership());
        }
        setUpgradeRequest(false);
    }

}