public class GameLibrary extends ItemLibrary{

    public Game registerGame(String title, String genre, double dailyRentFee){
        Game newGame = new Game(title, dailyRentFee, genre);
        addItemToList(newGame);
        return newGame;
    }

    public String searchByGenre(String genre) {
        int counter = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getItems().size(); i++) {
            Game currentGame = (Game) getItems().get(i);
            if (currentGame.getGenre().equalsIgnoreCase(genre)) {
                builder.append(currentGame.toString());
                builder.append("\n");
                counter++;
            }
        }
        if(counter == 0){
            return "There are no games with the given genre.";
        } else { return builder.toString(); }
    }
}
