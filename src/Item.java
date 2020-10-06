import java.util.ArrayList;

public class Item {

    private String ID;
    private String title;
    private double dailyRentFee;
    private String rentStatus;

    public Item(String title, double dailyRentFee){
        this.ID = RandomUID.generateRandomID();
        this.title = title;
        this.dailyRentFee = dailyRentFee;
        this.rentStatus = "Available";
    }

    public String getID() {
        return this.ID;
    }
    public String getTitle(){ return this.title; }

    public double getDailyRentFee() {
        return this.dailyRentFee;
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
