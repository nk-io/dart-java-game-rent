import java.util.ArrayList;

public class DartController {
    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    public static ArrayList<Game> gameList = new ArrayList<Game>();
    public static ArrayList<Customer> registeredCustomerList = new ArrayList<Customer>();
    public static double totalRentProfit;
    private static final String MANAGER_PASSWORD = "admin1234";
    private static final String EMPLOYEE_PASSWORD = "password123";

    public static void start(){
        boolean mainMenuActive = true;

        // Starts the program by printing the main menu from DartController
        do {
            String mainMenuOption = DartController.mainMenu();

            // Formats the received input to lower case so the program doesn't need to check whether it's upper or lower case
            if (mainMenuOption.toLowerCase().equals("m"))  {

                String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                // Checks whether the typed password matches the manager password
                if (enteredPassword.equals(MANAGER_PASSWORD)) {
                    DartController.managerMenu();

                } else {
                    System.out.println("Invalid Password!");
                }

            } else if (mainMenuOption.toLowerCase().equals("e")) {

                String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                // Checks whether the typed password matches the employee password
                if (enteredPassword.equals(EMPLOYEE_PASSWORD)) {
                    DartController.employeeMenu();
                } else {
                    System.out.println("Invalid Password!");
                }

            } else if (mainMenuOption.toLowerCase().equals("c")) {
                DartController.customerMenu();

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
    public static String mainMenu() {

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
    // Prints the manager menu and asks for integer input (1, 2, 3)
    // !!! CALL THIS AFTER CONFIRMING THE PASSWORD !!!
    public static void managerMenu () {

        String managerMenuOption;

        // Checks the input and connects to other sub-menus depending on the input
        do {
            String managerMenuMessage =
                    "Manager Screen - Type one of the options below:\n" +
                            "1. Add an employee\n" +
                            "2. View all employees\n" +
                            "3. Return to Main Menu\n";

            managerMenuOption = InputClass.askStringInput(managerMenuMessage);
            if (managerMenuOption.equals("1")) {
                ManagerMenu.addEmployee();
            } else if (managerMenuOption.equals("2")) {
                ManagerMenu.viewEmployees();
            } else if(managerMenuOption.equals("3")){
                System.out.println("Returning to Main Menu...");
            }
            else {
                System.out.println("Invalid Input! Please try again!");
            }
        } while(!managerMenuOption.equals("3"));

    }
    // Prints the employee menu and asks for integer input (1, 2, 3...7)
    // !!! CALL THIS AFTER CONFIRMING THE PASSWORD !!!
    public static void employeeMenu ()    {

        String employeeMenuOption;

        // Checks the input and connects to other sub-menus depending on the input
        do {
            String employeeMenuMessage =
                    "Employee Screen - Type one of the options below:\n" +
                            "1. Register a game\n" +
                            "2. Remove a game\n" +
                            "3. Register a customer\n" +
                            "4. Remove a customer\n" +
                            "5. Show total rent profit\n" +
                            "6. View all games\n" +
                            "7. Return to Main Menu\n";

            employeeMenuOption = InputClass.askStringInput(employeeMenuMessage);

            if (employeeMenuOption.equals("1")) {
                EmployeeMenu.registerGame();
            } else if (employeeMenuOption.equals("2")) {
                EmployeeMenu.removeGame();
            } else if (employeeMenuOption.equals("3")) {
                EmployeeMenu.registerCustomer();
            } else if (employeeMenuOption.equals("4")) {
                EmployeeMenu.removeCustomer();
            } else if (employeeMenuOption.equals("5")) {
                EmployeeMenu.showTotalRentProfit();
            } else if (employeeMenuOption.equals("6")) {
                User.listAllGames();
            } else if (employeeMenuOption.equals("7")) {
                System.out.println("Returning to Main Menu...");

            } else {
                System.out.println("Invalid Input! Please try again!");
            }
        } while(!employeeMenuOption.equals("7"));

    }
    // Prints the customer menu and no password is required here
    public static void customerMenu() {

        String customerMenuOption;

        // Checks the input and connects to other sub-menus depending on the input
        do {
            String customerMenuMessage =
                    "Customer Screen - Type one of the options below:\n" +
                            "1. Rent a game\n" +
                            "2. Return a game\n" +
                            "3. Return to Main Menu\n";


            customerMenuOption = InputClass.askStringInput(customerMenuMessage);
            if (customerMenuOption.equals("1")){
                User.rentGame();
            } else if (customerMenuOption.equals("2")) {
                EmployeeMenu.returnGame(); // NOTE: We should move this to User class?!
            }else if (customerMenuOption.equals("3")) {
                System.out.println("Returning to Main Menu...");
            } else {
                System.out.println("Invalid Input! Please try again!");
            }


        } while(!customerMenuOption.equals("3"));

    }
}
