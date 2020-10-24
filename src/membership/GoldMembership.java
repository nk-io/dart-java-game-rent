package membership;

public class GoldMembership extends Membership {
    private double discount = 0.15;
    private int rentalLimit = 5;
    private int storeCreditsPerRental = 2;

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
        String membership = "Gold";
        return membership;
    }
}
