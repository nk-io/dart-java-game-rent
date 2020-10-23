package membership;

public class PlatinumMembership extends Membership {
    @Override
    public double getDiscount() {
        double discount = 0.25;
        return discount;
    }

    @Override
    public int getRentalLimit() {
        int rentalLimit = 7;
        return rentalLimit;
    }

    @Override
    public int getStoreCreditsPerRental() {
        int storeCreditsPerRental = 3;
        return storeCreditsPerRental;
    }

    @Override
    public String toString() {
        String membership = "Platinum";
        return membership;
    }
}
