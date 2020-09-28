// Change Log for Milestone 2
// Password property and methods have been added to achieve password protection for every user
// UserMenu class became User class and its parent class for all user classes

//Parent class for all users
public class User {

    private String ID;
    private String name;
    private String password;

    User(String name, String password){
        this.ID=RandomUID.generateRandomID();
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ID='" + ID + '\'' +
                ", name='" + name + '\'';
    }


    public String getName(){
        return this.name;
    }
    public String getID() {
        return this.ID;
    }
    // setter for name property (in case of if we need it)
    public void setName(String name){
        this.name=name;
    }
    //Checks for the password for user
    public boolean checkPassword(String inputPassword) {
        if(this.password.equals(inputPassword)){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkID(String inputID) {
        if(this.ID.equals(inputID)){
            return true;
        }
        else {
            return false;
        }
    }

    // User Story: 6.1
    public boolean rentGame(){
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

    public boolean returnGame(){
        // gets the id of the game
        String gameReturnID = InputClass.askStringInput("Please enter the ID of the game you want to return: ");

        // gets the days rented

        double totalRent;

        // checks if the id matches
        // calculates the rent fee
        // adds the rent fee to the total profit
        // changes the rent status once returned
        for (int i = 0; i < DartController.gameList.size(); i++) {
            if (!DartController.gameList.get(i).isGameAvailableToRent()) {
                if (DartController.gameList.get(i).getID().equals(gameReturnID)) {
                    int daysRented = InputClass.askIntInput("Enter the number of days the game was rented: ");
                    while(daysRented < 0 ) {
                        daysRented = InputClass.askIntInput("Enter a valid number of days the game was rented: ");
                    }
                    totalRent = DartController.gameList.get(i).getDailyRentFee() * (double) daysRented;
                    System.out.println("Total rent fee: " + totalRent + " SEK");
                    DartController.totalRentProfit += totalRent;
                    DartController.gameList.get(i).setAvailableToRent();
                    System.out.println("Game successfully returned!");
                    return true;
                }
            }
        }

        System.out.println("Game with id: " + gameReturnID + " not found or not rented.");
        return false;

    }

    public void listAllGames(){
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



