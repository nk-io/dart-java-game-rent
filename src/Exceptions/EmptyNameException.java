package Exceptions;

public class EmptyNameException extends RuntimeException{
    public EmptyNameException(String type){
        super("Invalid data. "+type+" name cannot be empty.");
    }
}
