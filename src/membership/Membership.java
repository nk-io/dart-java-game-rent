package membership;

public abstract class Membership {
    private double discount;
    private int rentalLimit;
    private int storeCreditsPerRental;

    public abstract double getDiscount();
    public abstract int getRentalLimit();
    public abstract int getStoreCreditsPerRental();
    public abstract String toString();
}
