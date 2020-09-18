public class Game {
    private String ID;
    private String title;
    private String genre;
    private double dailyRentFee;
    private String rentStatus;
    //Constructor for game
    //takes title, genre and daily rent fee
    //ID will be generated automatically
    Game(String title, String genre, double dailyRentFee){
        this.ID = RandomUID.generateRandomID();
        this.title = title;
        this.genre = genre;
        this.dailyRentFee = dailyRentFee;
        this.rentStatus = "Available";
    }

    public String getRentStatus() { 
        return this.rentStatus; 
    } 

    public double getDailyRentFee() { 
        return this.dailyRentFee; 
    } 

    public void setRentStatus(String rentStatus) { 
        this.rentStatus = rentStatus; 
    } 





    //we can use this to list games later
    @Override
    public String toString() {
        return
                "ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", dailyRentFee=" + dailyRentFee +
                ", rentStatus=" + rentStatus ;
    }

    public String getID(){
        return this.ID;
    }
}
