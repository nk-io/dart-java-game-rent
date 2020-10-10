public enum Membership {
    SILVER (0.10, 3, 1),
    GOLD (0.15, 5, 2),
    PLATINUM (0.25, 7, 3),
    NONE (0, 1, 0);

    private double discount;
    private int rentalLimit;
    private int storeCreditsPerRental;

    Membership(double discount, int rentalLimit, int storeCredits){
        this.discount = discount;
        this.rentalLimit = rentalLimit;
        this.storeCreditsPerRental = storeCredits;
    }

    public double getDiscount() {
        return discount;
    }

    public int getRentalLimit() {
        return rentalLimit;
    }

    public int getStoreCredits() {
        return storeCreditsPerRental;
    }
}