public class Album {
    private String ID;
    private String title;
    private String artist;
    private int year;
    private double dailyRentFee;
    private String rentStatus;

    Album(String title, String artist, int year, double dailyRentFee){
        this.ID = RandomUID.generateRandomID();
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.dailyRentFee = dailyRentFee;
        this.rentStatus = "Available";
    }

    public double getDailyRentFee() {
        return this.dailyRentFee;
    }

    public void setAvailableToRent(){
        this.rentStatus = "Available";
    }

    public void setNotAvailableToRent(){
        this.rentStatus = "Not available";
    }

    public boolean isAlbumAvailableToRent(){
        return this.rentStatus.equals("Available");
    }

    public String getID(){
        return this.ID;
    }

    @Override
    public String toString() {
        return
                "ID: " + ID + " : '" + title + '\'' +
                        " - by '" + artist + "'." +
                        " Released in " + year +
                        ". Price: " + dailyRentFee +
                        " SEK. Rent status: " + rentStatus;
    }
}
