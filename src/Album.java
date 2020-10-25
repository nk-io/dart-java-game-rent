//Milestone 3
//Constructor throws some Exceptions for Epic Feature 12
import exception.AlbumEmptyArtistException;
import exception.AlbumNegativeYearException;

class Album extends Item{

    private String artist;
    private int year;

    Album(String title, double dailyRentFee, String artist, int year) throws AlbumEmptyArtistException, AlbumNegativeYearException{
        super(title, dailyRentFee);
        if(artist.isEmpty()){
            throw new AlbumEmptyArtistException();
        }
        if(year<0){
            throw new AlbumNegativeYearException();
        }
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
                " SEK. Rent status: " + getRentStatus() +
                " Average rating: " + getAverageRating() + "\n";
    }
}
