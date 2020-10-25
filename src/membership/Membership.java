/* Milestone 2 saw the implementation of Membership using enum (as the methods using Membership did not change, only the values);
For milestone 3, the enum was deleted, and Membership is now an abstract class with 4 child classes to better
demonstrate polymorphism. It was also packaged to be more visually succinct.*/


package membership;

public abstract class Membership {
    private double discount;
    private int rentalLimit;
    private int storeCreditsPerRental;
    private String type;

    Membership(double discount, int rentalLimit, int storeCreditsPerRental, String type){
        this.discount = discount;
        this.rentalLimit = rentalLimit;
        this.storeCreditsPerRental = storeCreditsPerRental;
        this.type = type;
    }

    public double getDiscount() {
        return discount;
    }

    public int getRentalLimit() {
        return rentalLimit;
    }

    public int getStoreCreditsPerRental() {
        return storeCreditsPerRental;
    }

    public String getType() { return type; }
}
