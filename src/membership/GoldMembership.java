package membership;

public class GoldMembership extends Membership {
    @Override
    public double getDiscount() {
        double discount = 0.15;
        return discount;
    }

    @Override
    public int getRentalLimit() {
        int rentalLimit = 5;
        return rentalLimit;
    }

    @Override
    public int getStoreCreditsPerRental() {
        int storeCreditsPerRental = 2;
        return storeCreditsPerRental;
    }

    @Override
    public String toString() {
        String membership = "Gold";
        return membership;
    }
}
