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
