// Change Log for Milestone 2
// Methods are no longer statics
// Added messageList for Epic Feature 9

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DartController {

    private GameLibrary gameLibrary;
    private AlbumLibrary albumLibrary;
    private ManagerLibrary managerLibrary;
    private EmployeeLibrary employeeLibrary;
    private CustomerLibrary customerLibrary;
    private MessageLibrary messageLibrary;
    private UserInterface userInterface;
    private ReviewLibrary reviewLibrary;
    private RentHistoryLibrary rentHistoryLibrary;

    public DartController() {
        this.gameLibrary = new GameLibrary();
        this.albumLibrary = new AlbumLibrary();
        this.managerLibrary = new ManagerLibrary();
        this.employeeLibrary = new EmployeeLibrary();
        this.customerLibrary = new CustomerLibrary();
        this.messageLibrary = new MessageLibrary();
        this.reviewLibrary = new ReviewLibrary();
        this.rentHistoryLibrary = new RentHistoryLibrary();
        this.userInterface = new UserInterface(gameLibrary, albumLibrary, managerLibrary, employeeLibrary, customerLibrary, messageLibrary, reviewLibrary,rentHistoryLibrary);
    }

    //Starts the main program loop
    public void start() {

        boolean mainMenuActive = true;

        // Starts the program by printing the main menu from DartController
        do {
            String mainMenuOption = mainMenu();
            // Formats the received input to lower case so the program doesn't need to check whether it's upper or lower case
            switch (mainMenuOption.toLowerCase()) {
                case "m" -> {
                    String enteredID = InputClass.askStringInput("Please enter your ID: ");
                    Manager currentManagerUser = (Manager) managerLibrary.doesUserExist(enteredID);
                    //lets check if user exists
                    if (currentManagerUser != null) {
                        //user exists, now we can check ask and check the password
                        String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                        if (currentManagerUser.checkPassword(enteredPassword)) {
                            managerMenu();
                        } else {
                            System.out.println("Invalid Password!");
                        }
                    } else {
                        System.out.println("Manager with ID: " + enteredID + " was not found!");
                    }
                }

                case "e" -> {
                    String enteredID = InputClass.askStringInput("Please enter your ID: ");
                    Employee currentEmployeeUser = (Employee) employeeLibrary.doesUserExist(enteredID);
                    if (currentEmployeeUser != null) {
                        //user exists, now we can check ask and check the password
                        String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                        if (currentEmployeeUser.checkPassword(enteredPassword)) {
                            employeeMenu();
                        } else {
                            System.out.println("Invalid Password!");
                        }
                    } else {
                        System.out.println("Employee with ID: " + enteredID + " was not found!");
                    }
                }

                case "c" -> {
                    String enteredID = InputClass.askStringInput("Please enter your ID: ");
                    Customer currentCustomerUser = (Customer) customerLibrary.doesUserExist(enteredID);
                    if (currentCustomerUser != null) {
                        //user exists, now we can check ask and check the password
                        String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                        if (currentCustomerUser.checkPassword(enteredPassword)) {
                            customerMenu(currentCustomerUser);
                        } else {
                            System.out.println("Invalid Password!");
                        }
                    } else {
                        System.out.println("Customer with ID: " + enteredID + " was not found!");
                    }
                }
                // Closes the scanner and terminates the program if the input is X/x
                case "x" -> {
                    System.out.println("Exiting DART...");
                    mainMenuActive = false;
                    InputClass.closeScanner();
                }
                default -> System.out.println("Invalid input! Please, try again!");
            }

        } while (mainMenuActive);
    }
    // Prints the main menu and asks for string input
    private String mainMenu() {

        String mainMenuMessage =
                "Main Menu:\n" +
                        "Welcome to DART, your good old game rental system. The competition has no steam to keep up!\n" +
                        "\n" +
                        "Please specify your role by entering one of the options given:\n" +
                        "1. Enter “M” for Manager \n" +
                        "2. Enter “E” for Employee \n" +
                        "3. Enter “C” for Customer\n" +
                        "4. Enter “X” to exit system \n";

        String mainMenuOption = InputClass.askStringInput(mainMenuMessage);

        return mainMenuOption;

    }
    // Prints the manager menu and asks for integer input
    // Calls appropriate methods to current manager
    private void managerMenu () {
        int managerMenuOption;

        // Checks the input and connects to other sub-menus depending on the input
        do {
            String managerMenuMessage =
                    "Manager Screen - Type one of the options below:\n" +
                            "1. Register an employee\n" +
                            "2. View all employees\n" +
                            "3. Remove an employee\n" +
                            "4. View the most profitable item\n"+
                            "5. View rent frequency of all items\n"+
                            "6. View the best customer\n"+
                            "7. Show total rent profits\n"+
                            "8. Show all rent transactions\n"+
                            "9. Return to Main Menu\n";

            managerMenuOption = InputClass.askIntInput(managerMenuMessage);
            switch (managerMenuOption) {
                case 1 -> userInterface.registerEmployee();
                case 2 -> userInterface.listAllEmployees();
                case 3 -> userInterface.removeEmployee();
                case 4 -> userInterface.showMostProfitableItem();
                case 5 -> userInterface.listRentFrequency();
                case 6 -> userInterface.showBestCustomer();
                case 7 -> userInterface.showTotalRentProfit();
                case 8 -> userInterface.listRentTransactions();
                case 9 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid Input! Please try again!");
            }
        } while(!(managerMenuOption == 9));

    }
    // Prints the employee menu and asks for integer input
    // Calls appropriate methods to current employee
    private void employeeMenu ()    {

        int employeeMenuOption;

        // Checks the input and connects to other sub-menus depending on the input
        do {
            String employeeMenuMessage =
                    "Employee Screen - Type one of the options below:\n" +
                            "1. Register a game\n" +
                            "2. Remove a game\n" +
                            "3. Register a song album\n" +
                            "4. Remove a song album\n" +
                            "5. Register a customer\n" +
                            "6. Remove a customer\n" +
                            "7. Membership requests \n" +
                            "8. Show total rent profits \n" +
                            "9. View all games\n" +
                            "10. View all song albums\n" +
                            "11. View all customers\n" +
                            "12. Return to Main Menu\n";

            employeeMenuOption = InputClass.askIntInput(employeeMenuMessage);

            switch (employeeMenuOption) {
                case 1 -> userInterface.registerGame();
                case 2 -> userInterface.removeGame();
                case 3 -> userInterface.registerAlbum();
                case 4 -> userInterface.removeAlbum();
                case 5 -> userInterface.registerCustomer();
                case 6 -> userInterface.removeCustomer();
                case 7 -> userInterface.upgradeCustomer();
                case 8 -> userInterface.showTotalRentProfit();
                case 9 -> userInterface.listAllGames();
                case 10 -> userInterface.listAllAlbums();
                case 11 -> userInterface.listAllCustomers();
                case 12 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid Input! Please try again!");
            }
        } while(!(employeeMenuOption == 12));

    }
    // Prints the customer menu and asks for integer input
    // Calls appropriate methods to current customer
    private void customerMenu(Customer customer) {
        int customerMenuOption;
        // Checks the input and connects to other sub-menus depending on the input
        do {
            String customerMenuMessage =
                    "Customer Screen - Type one of the options below:\n" +
                            "1. Search for an item\n" +
                            "2. View items by average rating\n" +
                            "3. View reviews of an item\n" +
                            "4. Rent a game\n" +
                            "5. Return a game\n" +
                            "6. Rent a song album\n" +
                            "7. Return a song album\n" +
                            "8. Send a message\n" +
                            "9. Read messages\n" +
                            "10. Delete a message\n" +
                            "11. Request membership upgrade\n" +
                            "12. View my credits\n" +
                            "13. Return to Main Menu\n";
            customerMenuOption = InputClass.askIntInput(customerMenuMessage);
            switch (customerMenuOption) {
                case 1 -> userInterface.searchItem();
                case 2 -> userInterface.viewByAverageRating();
                case 3 -> userInterface.viewItemReviews();
                case 4 -> userInterface.rentGame(customer);
                case 5 -> userInterface.returnGame(customer);
                case 6 -> userInterface.rentAlbum(customer);
                case 7 -> userInterface.returnAlbum(customer);
                case 8 -> userInterface.sendAMessage(customer.getID());
                case 9 -> userInterface.showCustomerMessages(customer.getID());
                case 10 -> userInterface.deleteAMessage(customer.getID());
                case 11-> userInterface.requestMembershipUpgrade(customer);
                case 12 -> userInterface.viewCredits(customer);
                case 13 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid Input! Please try again!");
            }
        } while(!(customerMenuOption == 13));
    }
    //Customer;Name;Password
    //Employee;Name;Password;BirthYear;Address;GrossSalary
    //Game;Title;Genre;DailyRentFee
    //Album;Title;Artist;Year;DailyRentFee
    public String importDataFromATxt(String filePath){
        try {
            File myFile = new File("src/temp.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder builder = new StringBuilder();
            String line = null;
            int lineCounter=0;
            int customerCounter=0;
            int employeeCounter=0;
            int gameCounter=0;
            int albumCounter=0;
            while ((line = reader.readLine()) != null) {
                lineCounter++;
                String[] partsOfCurrentLine = line.split(";");
                if(partsOfCurrentLine[0].equalsIgnoreCase("customer")){
                    customerLibrary.registerCustomer(partsOfCurrentLine[1],partsOfCurrentLine[2]);
                    customerCounter++;
                }else if(partsOfCurrentLine[0].equalsIgnoreCase("employee")){
                    employeeLibrary.registerEmployee(partsOfCurrentLine[1],partsOfCurrentLine[2],Integer.parseInt(partsOfCurrentLine[3]),partsOfCurrentLine[4], Double.parseDouble(partsOfCurrentLine[5]));
                    employeeCounter++;
                }else if(partsOfCurrentLine[0].equalsIgnoreCase("game")){
                    gameLibrary.registerGame(partsOfCurrentLine[1], partsOfCurrentLine[2], Double.parseDouble(partsOfCurrentLine[3]));
                    gameCounter++;
                }else if(partsOfCurrentLine[0].equalsIgnoreCase("album")){
                    albumLibrary.registerAlbum(partsOfCurrentLine[1], partsOfCurrentLine[2], Integer.parseInt(partsOfCurrentLine[3]), Double.parseDouble(partsOfCurrentLine[4]));
                    albumCounter++;
                }else{
                    builder.append("Invalid input at line "+line+"\n");
                }
            }
            if(customerCounter > 0){
                builder.append(customerCounter + " customers ");
            }
            if (employeeCounter > 0){
                builder.append(employeeCounter + " employees ");
            }
            if (gameCounter > 0){
                builder.append(gameCounter + " games ");
            }
            if (albumCounter > 0){
                builder.append(albumCounter + " albums ");
            }
            if(customerCounter+employeeCounter+gameCounter+albumCounter>0){
                builder.append("\nTotal: "+(customerCounter+employeeCounter+gameCounter+albumCounter)+ " records have been imported successfully");
            } else {
                builder.append("No data to import!");
            }
            reader.close();
            return builder.toString();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    //initializes some test users
    //this method created for testing purposes
    public void testingInit(){
        managerLibrary.registerManager("testManager1", "man1");
        managerLibrary.registerManager("testManager2", "man2");
        employeeLibrary.registerEmployee("testEmployee1", "emp1", 1995, "address1", 10000);
        employeeLibrary.registerEmployee("testEmployee2", "emp2", 1994, "address2", 20000);
        Customer cust1 = customerLibrary.registerCustomer("testCustomer1", "cust1");
        Customer cust2 = customerLibrary.registerCustomer("testCustomer2", "cust2");
        Game game1 = gameLibrary.registerGame("testGame","testGenre", 300);
        Game game2 =gameLibrary.registerGame("testGame2","testGenre", 350);
        Game game3 =gameLibrary.registerGame("testGame3","testGenre", 150);
        Album album1 = albumLibrary.registerAlbum("testTitle","Test Artist", 2012,200);
        Album album2 = albumLibrary.registerAlbum("testTitle2","Test Artist2", 2012,300);
        Album album3 = albumLibrary.registerAlbum("testTitle3","Test Artist3", 2012,15);
        userInterface.listAllManagers();
        userInterface.listAllEmployees();
        userInterface.listAllCustomers();

    }
}