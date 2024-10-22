//Milestone 3
//Constructor throws some Exceptions for Epic Feature 12
import exception.GameEmptyGenreException;

class Game extends Item {
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