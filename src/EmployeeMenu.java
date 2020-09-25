
public class EmployeeMenu extends UserMenu {

    // User Story 6.3

    public static void showTotalRentProfit(){
        System.out.println("The total rent profit is "+ DartController.totalRentProfit + " SEK");
    }

    //EPIC FEATURE 3
    public static void registerGame(){
        //required fields for a game
        String title;
        String genre;
        double dailyRentFee;

        //Input and Output will be change after we got the input class

        title = InputClass.askStringInput("Please enter the name of the game: ");
        genre = InputClass.askStringInput("Please enter the genre of the game: ");
        dailyRentFee = InputClass.askDoubleInput("Please enter the daily rent fee: ");
        while(dailyRentFee < 0 ){
            dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        }

        //lets create the new game
        Game newGame = new Game(title,genre,dailyRentFee);
        DartController.gameList.add(newGame);
        System.out.println("Game with "+ newGame.toString() + " has been created successfully");

    }

    // search given ID in gameList array list
    // if ID exists remove game object from the array list. return true
    // if not print a message then return false
    public static boolean removeGame(){
        //Input and Output will be change after we got the input class
        String idToRemove = InputClass.askStringInput("Please enter the ID of the game: ");

        //lets check if game exist
        for(int i=0; i<DartController.gameList.size(); i++){
            if (DartController.gameList.get(i).getID().equals(idToRemove)){
                //if ID's are equal remove the Game object from the array list
                System.out.println("Game with " + DartController.gameList.get(i).toString() + " has been removed!");
                DartController.gameList.remove(i);
                return true;
            }
        }
        System.out.println("Game with id:" + idToRemove + " not found");

        return false;

    }

    //EPIC FEATURE 4
    //add a new customer
    public static void registerCustomer(){
        //Required fields for a new customer
        String name;

        //Creating the new customer
        name = InputClass.askStringInput("Please enter the name of the customer: ");
        Customer newCustomer = new Customer(name);
        DartController.registeredCustomerList.add(newCustomer);
        System.out.println("The customer " + newCustomer.toString() + " has been created successfully.");
    }


    //remove an existing customer
    public static boolean removeCustomer() {
        String customerToRemove = InputClass.askStringInput("Please enter the ID of the customer: ");

        //check if the customer exists
        for(int i = 0; i < DartController.registeredCustomerList.size(); i++){
            if(DartController.registeredCustomerList.get(i).getID().equals(customerToRemove)){
                System.out.println("Customer with " + DartController.registeredCustomerList.get(i).toString() + " has been removed!");
                DartController.registeredCustomerList.remove(i);
                return true;
            }
        }

        //informs if the customer doesn't exist
        System.out.println("Customer with id: " + customerToRemove + " not found.");
        return false;
    }





}
