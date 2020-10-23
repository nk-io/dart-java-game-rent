package exception;

public class AlbumEmptyYearException extends RuntimeException{
    public AlbumEmptyYearException(){
        super("Invalid data. Album year cannot be empty.");
    }
}
