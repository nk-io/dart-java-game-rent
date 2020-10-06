public class GameLibrary extends ItemLibrary{

    public Game registerGame(String title, double dailyRentFee, String genre){
        Game newGame = new Game(title, dailyRentFee, genre);
        addItemToList(newGame);
        return newGame;
    }

}
