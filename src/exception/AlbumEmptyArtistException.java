package exception;

public class AlbumEmptyArtistException extends RuntimeException{
    public AlbumEmptyArtistException(){
        super("Invalid data. Album artist cannot be empty.");
    }
}
