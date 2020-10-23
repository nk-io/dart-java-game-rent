package exception;

public class NegativeRentFeeException extends RuntimeException{
    public NegativeRentFeeException(String type){
        super("Invalid data. "+type+" rent fee cannot be negative.");
    }
}