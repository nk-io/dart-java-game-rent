package membership;

public class SilverMembership extends Membership {
    private double discount = 0.10;
    private int rentalLimit = 3;
    private int storeCreditsPerRental = 1;

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public int getRentalLimit() {
        return rentalLimit;
    }

    @Override
    public int getStoreCreditsPerRental() {
        return storeCreditsPerRental;
    }

    @Override
    public String toString() {
        String membership = "Silver";
        return membership;
    }
}
