package membership;

public class RegularMembership extends Membership {
    @Override
    public double getDiscount() {
        double discount = 0;
        return discount;
    }

    @Override
    public int getRentalLimit() {
        int rentalLimit = 1;
        return rentalLimit;
    }

    @Override
    public int getStoreCreditsPerRental() {
        int storeCreditsPerRental = 0;
        return storeCreditsPerRental;
    }

    @Override
    public String toString() {
        String membership = "Regular";
        return membership;
    }
}
