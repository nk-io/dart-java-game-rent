package exception;

public class AlbumNegativeYearException extends RuntimeException{
    public AlbumNegativeYearException(){
        super("Invalid data. Album year cannot be negative.");
    }
}

