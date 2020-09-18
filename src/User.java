public class User {
    // User Story: 6.1
    public static boolean rentGame(){
        System.out.println("List of games to rent: ");
        // print all games
        for(int i = 0; i < DartController.gameList.size(); i++ ){
            System.out.println(DartController.gameList.get(i));
        }

        String gameToRent = InputClass.askStringInput("Enter game id of game you want to rent: ");
        // checks if game exists and is rented
        // then checks if it exists and changes its status to unavailable
        for(int i = 0; i < DartController.gameList.size(); i++){
            if(DartController.gameList.get(i).getID().equals(gameToRent) && DartController.gameList.get(i).getRentStatus().equals("Not available")){
                System.out.println("Game with id: " + gameToRent + " is already rented.");
                return false;
            } else if(DartController.gameList.get(i).getID().equals(gameToRent)){
                System.out.println("Game with id: " + gameToRent + " has been rented!");
                DartController.gameList.get(i).setRentStatus("Not available");
                return true;
            } 
        }
        // informs if game doesn't exist
        System.out.println("Game with id: " + gameToRent + " not found.");
        return false;
    }
}



