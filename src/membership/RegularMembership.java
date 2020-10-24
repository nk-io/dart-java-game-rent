package membership;

public class RegularMembership extends Membership {
    private double discount = 0;
    private int rentalLimit = 1;
    private int storeCreditsPerRental = 0;

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
        String membership = "Regular";
        return membership;
    }
}
