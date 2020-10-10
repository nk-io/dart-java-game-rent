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

    Customer(String name, String password){
        super(name,password);
    }

    // Getters
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

    public boolean hasEnoughCreditsToRent() {
        if (this.storeCredits >= 5) {
            return true;
        }
        return false;
    }


    public void incrementStoreCredits() {
        this.storeCredits = this.storeCredits + this.membership.getStoreCredits();
    }

    public void decrementStoreCredits() {
        if (hasEnoughCreditsToRent()) {
            this.storeCredits = this.storeCredits - 5;
        }
    }

}