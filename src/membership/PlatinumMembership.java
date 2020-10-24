package membership;

public class PlatinumMembership extends Membership {
    private double discount = 0.25;
    private int rentalLimit = 7;
    private int storeCreditsPerRental = 3;

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
        String membership = "Platinum";
        return membership;
    }
}
