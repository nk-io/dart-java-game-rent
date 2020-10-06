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

    public DartController(){
        this.gameLibrary = new GameLibrary();
        this.albumLibrary = new AlbumLibrary();
        this.managerLibrary = new ManagerLibrary();
        this.employeeLibrary = new EmployeeLibrary();
        this.customerLibrary = new CustomerLibrary();
        this.messageLibrary = new MessageLibrary();}

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
                if(currentManagerUser != null){
                    //user exists, now we can check ask and check the password
                    String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                    if (currentManagerUser.checkPassword(enteredPassword)) {
                        managerMenu(currentManagerUser);
                    } else {
                        System.out.println("Invalid Password!");
                    }
                }
                else{
                    System.out.println("Manager with ID: "+enteredID+ " cannot found!");
                }


            } else if (mainMenuOption.toLowerCase().equals("e")) {
                String enteredID = InputClass.askStringInput("Please enter your ID: ");
                Employee currentEmployeeUser = (Employee) searchUserInList(employeeList, enteredID);
                if(currentEmployeeUser != null){
                    //user exists, now we can check ask and check the password
                    String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                    if (currentEmployeeUser.checkPassword(enteredPassword)) {
                        employeeMenu(currentEmployeeUser);
                    } else {
                        System.out.println("Invalid Password!");
                    }
                } else{
                    System.out.println("Employee with ID: "+enteredID+ " cannot found!");
                }


            } else if (mainMenuOption.toLowerCase().equals("c")) {
                String enteredID = InputClass.askStringInput("Please enter your ID: ");
                Customer currentCustomerUser = (Customer) searchUserInList(registeredCustomerList, enteredID);
                if(currentCustomerUser != null){
                    //user exists, now we can check ask and check the password
                    String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                    if (currentCustomerUser.checkPassword(enteredPassword)) {
                        customerMenu(currentCustomerUser);
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
    private void managerMenu (Manager currentManager) {

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

                //itemLibrary.registerGame();
            } else if (managerMenuOption.equals("2")) {
                //currentManager.viewEmployees();
            } else if(managerMenuOption.equals("3")){
                System.out.println("Feature coming soon...");
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
    private void employeeMenu (Employee currentEmployee)    {

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
                gameLibrary.registerGame("test game 1", 25, "genre");
            } else if (employeeMenuOption.equals("2")) {
                //currentEmployee.removeItem("game");
            } else if (employeeMenuOption.equals("3")) {
                //currentEmployee.registerCustomer();
            } else if (employeeMenuOption.equals("4")) {
                //currentEmployee.removeCustomer();
            }else if (employeeMenuOption.equals("5")) {
                //currentEmployee.registerItem("album");
            }else if (employeeMenuOption.equals("6")) {
                //currentEmployee.removeItem("album");
            }else if (employeeMenuOption.equals("7")) {
                System.out.println("Feature coming soon...");
            } else if (employeeMenuOption.equals("8")) {
                //currentEmployee.showTotalRentProfit();
            } else if (employeeMenuOption.equals("9")) {
                System.out.println(gameLibrary.listAll());
            } else if (employeeMenuOption.equals("10")) {

                //currentEmployee.listAllAlbums();
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
    private void customerMenu(Customer currentCustomer) {

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
                //currentCustomer.rentItem("game");
            } else if (customerMenuOption.equals("3")) {
                //currentCustomer.returnItem("game");
            } else if (customerMenuOption.equals("4")) {
                //currentCustomer.rentItem("album");
            } else if (customerMenuOption.equals("5")) {
                //currentCustomer.returnItem("album");
            } else if (customerMenuOption.equals("6")) {
                //currentCustomer.sendAMessage();
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
        Manager testManager1 = new Manager("testManager1", "man1");
        Manager testManager2 = new Manager("testManager2", "man2");
        managerList.add(testManager1);
        managerList.add(testManager2);
        Employee testEmployee1 = new Employee("testEmployee1", "emp1", 1995, "adress1", 10000);
        Employee testEmployee2 = new Employee("testEmployee2", "emp2", 1994, "adress2", 20000);
        employeeList.add(testEmployee1);
        employeeList.add(testEmployee2);
        Customer testCustomer1 = new Customer("testCustomer1", "cust1");
        Customer testCustomer2 = new Customer("testCustomer2", "cust2");
        registeredCustomerList.add(testCustomer1);
        registeredCustomerList.add(testCustomer2);

        System.out.println(testManager1.toString());
        System.out.println(testManager2.toString());
        System.out.println(testEmployee1.toString());
        System.out.println(testEmployee2.toString());
        System.out.println(testCustomer1.toString());
        System.out.println(testCustomer2.toString());
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
