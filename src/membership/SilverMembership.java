package membership;

public class SilverMembership extends Membership {
    @Override
    public double getDiscount() {
        double discount = 0.10;
        return discount;
    }

    @Override
    public int getRentalLimit() {
        int rentalLimit = 3;
        return rentalLimit;
    }

    @Override
    public int getStoreCreditsPerRental() {
        int storeCreditsPerRental = 1;
        return storeCreditsPerRental;
    }

    @Override
    public String toString() {
        String membership = "Silver";
        return membership;
    }
}
