// Change Log for Milestone 2
// Methods are no longer statics
// Added messageList for Epic Feature 9


import java.util.ArrayList;

public class DartController {

    public static double totalRentProfit;
    private GameLibrary gameLibrary;
    private AlbumLibrary albumLibrary;
    private ManagerLibrary managerLibrary;
    private EmployeeLibrary employeeLibrary;
    private CustomerLibrary customerLibrary;
    private MessageLibrary messageLibrary;
    private UserInterface userInterface;

    public DartController() {
        this.gameLibrary = new GameLibrary();
        this.albumLibrary = new AlbumLibrary();
        this.managerLibrary = new ManagerLibrary();
        this.employeeLibrary = new EmployeeLibrary();
        this.customerLibrary = new CustomerLibrary();
        this.messageLibrary = new MessageLibrary();
        this.userInterface = new UserInterface();
    }

    //Starts the main program loop
    public void start() {

        boolean mainMenuActive = true;

        // Starts the program by printing the main menu from DartController
        do {
            String mainMenuOption = mainMenu();


            // Formats the received input to lower case so the program doesn't need to check whether it's upper or lower case
            if (mainMenuOption.toLowerCase().equals("m"))  {
                String enteredID = InputClass.askStringInput("Please enter your ID: ");
                Manager currentManagerUser = (Manager) managerLibrary.doesUserExist(enteredID);
                //lets check if user exists
                if(currentManagerUser == null){
                    //user exists, now we can check ask and check the password
                    String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                    if (currentManagerUser.checkPassword(enteredPassword)) {
                        managerMenu(userInterface, employeeLibrary);
                    } else {
                        System.out.println("Invalid Password!");
                    }
                }
                else{
                    System.out.println("Manager with ID: "+enteredID+ " cannot found!");
                }


            } else if (mainMenuOption.toLowerCase().equals("e")) {
                String enteredID = InputClass.askStringInput("Please enter your ID: ");
                Employee currentEmployeeUser = (Employee) employeeLibrary.doesUserExist(enteredID);
                if(currentEmployeeUser != null){
                    //user exists, now we can check ask and check the password
                    String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                    if (currentEmployeeUser.checkPassword(enteredPassword)) {
                        employeeMenu(userInterface);
                    } else {
                        System.out.println("Invalid Password!");
                    }
                } else{
                    System.out.println("Employee with ID: "+enteredID+ " cannot found!");
                }


            } else if (mainMenuOption.toLowerCase().equals("c")) {
                String enteredID = InputClass.askStringInput("Please enter your ID: ");
                Customer currentCustomerUser = (Customer) customerLibrary.doesUserExist(enteredID);
                if(currentCustomerUser != null){
                    //user exists, now we can check ask and check the password
                    String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                    if (currentCustomerUser.checkPassword(enteredPassword)) {
                        customerMenu(userInterface);
                    } else {
                        System.out.println("Invalid Password!");
                    }
                } else{
                    System.out.println("Customer with ID: "+enteredID+ " cannot found!");
                }

                // Closes the scanner and terminates the program if the input is X/x
            } else if (mainMenuOption.toLowerCase().equals("x")) {
                System.out.println("Exiting DART...");
                mainMenuActive = false;
                InputClass.closeScanner();

            } else {
                System.out.println("Invalid input! Please, try again!");
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
    private void managerMenu (UserInterface userInterface, EmployeeLibrary employeeLibrary) {

        String managerMenuOption;

        // Checks the input and connects to other sub-menus depending on the input
        do {
            String managerMenuMessage =
                    "Manager Screen - Type one of the options below:\n" +
                            "1. Add an employee\n" +
                            "2. View all employees\n" +
                            "3. Remove an employee\n" +
                            "4. View the most profitable item\n"+
                            "5. View rent frequency of all items\n"+
                            "6. View the best customer\n"+
                            "7. Show total rent profits\n"+
                            "8. Return to Main Menu\n";

            managerMenuOption = InputClass.askStringInput(managerMenuMessage);
            if (managerMenuOption.equals("1")) {
                userInterface.registerEmployee();
            } else if (managerMenuOption.equals("2")) {
                employeeLibrary.listAll();
            } else if(managerMenuOption.equals("3")){
                userInterface.removeEmployee();
            }else if(managerMenuOption.equals("4")){
                System.out.println("Feature coming soon...");
            }else if(managerMenuOption.equals("5")){
                System.out.println("Feature coming soon...");
            }else if(managerMenuOption.equals("6")){
                System.out.println("Feature coming soon...");
            }else if(managerMenuOption.equals("7")){
                System.out.println("Feature coming soon...");
            }else if(managerMenuOption.equals("8")){
                System.out.println("Returning to Main Menu...");
            }
            else {
                System.out.println("Invalid Input! Please try again!");
            }
        } while(!managerMenuOption.equals("8"));

    }
    // Prints the employee menu and asks for integer input
    // Calls appropriate methods to current employee
    private void employeeMenu (UserInterface userInterface)    {

        String employeeMenuOption;

        // Checks the input and connects to other sub-menus depending on the input
        do {
            String employeeMenuMessage =
                    "Employee Screen - Type one of the options below:\n" +
                            "1. Register a game\n" +
                            "2. Remove a game\n" +
                            "3. Register a customer\n" +
                            "4. Remove a customer\n" +
                            "5. Register a song album\n" +
                            "6. Remove a song album \n" +
                            "7. Membership requests \n" +
                            "8. Show total rent profits \n" +
                            "9. View all games\n" +
                            "10. View all song albums\n" +
                            "11. View all customers\n" +
                            "12. Return to Main Menu\n";

            employeeMenuOption = InputClass.askStringInput(employeeMenuMessage);

            if (employeeMenuOption.equals("1")) {
                userInterface.registerGame();
            } else if (employeeMenuOption.equals("2")) {
                userInterface.removeGame();
            } else if (employeeMenuOption.equals("3")) {
                userInterface.registerCustomer();
            } else if (employeeMenuOption.equals("4")) {
                userInterface.removeCustomer();
            }else if (employeeMenuOption.equals("5")) {
                userInterface.registerAlbum();
            }else if (employeeMenuOption.equals("6")) {
                userInterface.removeAlbum();
            }else if (employeeMenuOption.equals("7")) {
                System.out.println("Feature coming soon...");
            } else if (employeeMenuOption.equals("8")) {
                //currentEmployee.showTotalRentProfit();
            } else if (employeeMenuOption.equals("9")) {
                userInterface.listAllGames();
            } else if (employeeMenuOption.equals("10")) {
                userInterface.listAllAlbums();
            } else if (employeeMenuOption.equals("11")) {
                System.out.println("Feature coming soon...");
            } else if (employeeMenuOption.equals("12")) {
                System.out.println("Returning to Main Menu...");
            } else {
                System.out.println("Invalid Input! Please try again!");
            }
        } while(!employeeMenuOption.equals("12"));

    }
    // Prints the customer menu and asks for integer input
    // Calls appropriate methods to current customer
    private void customerMenu(UserInterface userInterface) {

        String customerMenuOption;

        // Checks the input and connects to other sub-menus depending on the input
        do {
            String customerMenuMessage =
                    "Customer Screen - Type one of the options below:\n" +
                            "1. Search for an item \n" +
                            "2. Rent a game\n" +
                            "3. Return a game\n" +
                            "4. Rent a song album\n" +
                            "5. Return a song album\n" +
                            "6. Send a message\n" +
                            "7. Read messages\n" +
                            "8. Delete a message\n" +
                            "9. Request membership upgrade\n" +
                            "10. View my credits\n" +
                            "11. Return to Main Menu\n";


            customerMenuOption = InputClass.askStringInput(customerMenuMessage);
            if (customerMenuOption.equals("1")){
                System.out.println("Feature coming soon...");
            } else if (customerMenuOption.equals("2")) {
                userInterface.rentGame();
            } else if (customerMenuOption.equals("3")) {
                userInterface.returnGame();
            } else if (customerMenuOption.equals("4")) {
                userInterface.rentAlbum();
            } else if (customerMenuOption.equals("5")) {
                userInterface.returnAlbum();
            } else if (customerMenuOption.equals("6")) {
                //userInterface.sendAMessage;
            } else if (customerMenuOption.equals("7")) {
                //currentCustomer.showCustomersMessages();
            } else if (customerMenuOption.equals("8")) {
                //currentCustomer.deleteAMessage();
            } else if (customerMenuOption.equals("9")) {
                System.out.println("Feature coming soon...");
            } else if (customerMenuOption.equals("10")) {
                System.out.println("Feature coming soon...");
            } else if (customerMenuOption.equals("11")) {
                System.out.println("Returning to Main Menu...");
            } else {
                System.out.println("Invalid Input! Please try again!");
            }


        } while(!customerMenuOption.equals("11"));

    }



    //initializes some test users
    //this method created for testing purposes
    public void testingInit(){
        ManagerLibrary managerLibrary = new ManagerLibrary();
        managerLibrary.registerManager("testManager1", "man1");
        managerLibrary.registerManager("testManager2", "man2");
        EmployeeLibrary employeeLibrary = new EmployeeLibrary();
        employeeLibrary.registerEmployee("testEmployee1", "emp1", 1995, "address1", 10000);
        employeeLibrary.registerEmployee("testEmployee2", "emp2", 1994, "address2", 20000);
        CustomerLibrary customerLibrary =  new CustomerLibrary();
        customerLibrary.registerCustomer("testCustomer1", "cust1");
        customerLibrary.registerCustomer("testCustomer2", "cust2");

        System.out.println(managerLibrary.listAll());
        System.out.println(employeeLibrary.listAll());
        System.out.println(customerLibrary.listAll());

    }



    //search of an user in given arraylist
    //if finds it return the user reference
    //else return null
    public static User searchUserInList(ArrayList<User> list, String inputID){
        for(int i=0; i< list.size(); i++){
            if(list.get(i).checkID(inputID)){
                return list.get(i);
            }
        }
        return null;
    }



}
