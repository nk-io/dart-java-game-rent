public class Item {

    private String ID;
    private String title;
    private double dailyRentFee;
    private String rentStatus;
    private double averageRating;
    private int numOfRatings;

    public Item(String title, double dailyRentFee){
        this.ID = RandomUID.generateRandomID();
        this.title = title;
        this.dailyRentFee = dailyRentFee;
        this.rentStatus = "Available";
        averageRating=0;
        numOfRatings=0;
    }

    public String getID() {
        return this.ID;
    }
    public String getTitle(){ return this.title; }

    public double getDailyRentFee() {
        return this.dailyRentFee;
    }
    public double getAverageRating(){
        return averageRating;
    }

    public void giveRating(int userRating){
        double currentTotalScore = averageRating * numOfRatings;
        numOfRatings++;
        averageRating = (currentTotalScore+userRating)/numOfRatings;
    }
    public void setAvailableToRent(){
        this.rentStatus = "Available";
    }

    public void setNotAvailableToRent(){
        this.rentStatus = "Not available";
    }

    public boolean isItemAvailableToRent(){
        return this.rentStatus.equals("Available");
    }

    public String getRentStatus() {
        return this.rentStatus;
    }

    @Override
    public String toString() {
        return  "ID:'" + ID + '\'' +
                ", title:'" + title + '\'' +
                ", daily rent fee=" + dailyRentFee +
                ", rent status='" + rentStatus + '\'';
    }

}