import Exceptions.EmptyNameException;
import Exceptions.GameEmptyGenreException;
import Exceptions.NegativeRentFeeException;

import java.util.ArrayList;

public class GameLibrary extends ItemLibrary{

    public Game registerGame(String title, String genre, double dailyRentFee){
        if(title.isEmpty()){
            throw new EmptyNameException("Game");
        }
        if(genre.isEmpty()){
            throw new GameEmptyGenreException();
        }
        if(dailyRentFee<0){
            throw new NegativeRentFeeException("Game");
        }
        Game newGame = new Game(title, dailyRentFee, genre);
        addItemToList(newGame);
        return newGame;
    }

    public String searchByGenre(String genre) {
        ArrayList<Item> subList = new ArrayList<>();
        String subListByGenre;
        for (int i = 0; i < getItems().size(); i++) {
            Game currentGame = (Game) getItems().get(i);
            if (currentGame.getGenre().equalsIgnoreCase(genre)) {
                subList.add(currentGame);
            }
        }
        if(subList.size() == 0){
            return "There are no games with the given genre.";
        } else {
            subListByGenre = sortByRating(subList);
            return subListByGenre   ;
        }
    }
}