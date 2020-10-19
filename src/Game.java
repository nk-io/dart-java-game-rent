import Exceptions.GameEmptyGenreException;

public class Game extends Item {
    private String genre;

    Game(String title, double dailyRentFee, String genre) throws GameEmptyGenreException{
        super(title, dailyRentFee);
        if(genre.isEmpty()){
            throw new GameEmptyGenreException();
        }
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