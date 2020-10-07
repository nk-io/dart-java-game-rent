public class Album extends Item{

    private String artist;
    private int year;

    Album(String title, double dailyRentFee, String artist, int year){
        super(title, dailyRentFee);
        this.artist = artist;
        this.year = year;
    }

    public String getArtist() {
        return this.artist;
    }
    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + " : '" + getTitle() + '\'' +
                " - by '" + getArtist() + "'." +
                " Released in " + getYear() +
                ". daily rent fee: " + getDailyRentFee() +
                " SEK. Rent status: " + getDailyRentFee() + ".";
    }
}
