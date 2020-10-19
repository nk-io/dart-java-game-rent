package Exceptions;

public class EmptyPasswordException extends RuntimeException{
    public EmptyPasswordException(String type){
        super("Invalid data. "+type+" password cannot be empty.");
    }
}