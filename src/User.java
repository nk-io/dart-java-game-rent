public class User {
    // User Story: 6.1
    public static boolean rentGame(){
        // print all games
        listAllGames();
        if(DartController.gameList.size() > 0){
            String gameToRent = InputClass.askStringInput("Enter game id of game you want to rent: ");
            // checks if game exists and is rented
            // then checks if it exists and changes its status to unavailable
            for(int i = 0; i < DartController.gameList.size(); i++){
                if(DartController.gameList.get(i).getID().equals(gameToRent) && !DartController.gameList.get(i).isGameAvailableToRent()){
                    System.out.println("Game with id: " + gameToRent + " is already rented.");
                    return false;
                } else if(DartController.gameList.get(i).getID().equals(gameToRent)){
                    System.out.println("Game with id: " + gameToRent + " has been rented!");
                    DartController.gameList.get(i).setNotAvailableToRent();
                    return true;
                }
            }
            // informs if game doesn't exist
            System.out.println("Game with id: " + gameToRent + " not found.");
        }
        return false;

    }

    public static void listAllGames(){
        //check if any games exists
        if(DartController.gameList.size() < 1){
            System.out.println("There are no games registered in the system!");
        } else {
            System.out.println("List of all games: ");
            for(int i=0; i<DartController.gameList.size(); i++){
                System.out.println(DartController.gameList.get(i).toString());
            }
        }

    }
}



