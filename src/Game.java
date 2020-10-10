public class Game extends Item {
    private String genre;

    Game(String title, double dailyRentFee, String genre){
        super(title, dailyRentFee);
        this.genre=genre;
    }
    public String getGenre() {
        return this.genre;
    }

    @Override
    public String toString() {
        return "ID: '" + getID() + '\'' +
                ", Title: '" + getTitle() + '\'' +
                ", Genre: '" + getGenre() + '\'' +
                ", Daily rent fee: " + getDailyRentFee() +
                " SEK. Rent status: " + getRentStatus() +
                ", Average rating: "+ getAverageRating() + "\n";
    }
}