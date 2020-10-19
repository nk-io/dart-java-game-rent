package Exceptions;

public class GameEmptyGenreException extends RuntimeException{
    public GameEmptyGenreException(){
        super("Invalid data. Game genre cannot be empty.");
    }
}