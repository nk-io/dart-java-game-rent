public class GameLibrary extends ItemLibrary{

    public Game registerGame(String title, String genre, double dailyRentFee){
        Game newGame = new Game(title, dailyRentFee, genre);
        addItemToList(newGame);
        return newGame;
    }

}
