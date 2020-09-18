import java.util.ArrayList;

public class DartController {
    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    public static ArrayList<Game> gameList = new ArrayList<Game>();
    public static ArrayList<Customer> registeredCustomerList = new ArrayList<Customer>();
    public static double totalRentProfit;

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
    public static int managerMenu () {

        int managerMenuOption = 0;

        String managerMenuMessage =
                        "Manager Screen - Type one of the options below:\n" +
                        "1. Add an employee\n" +
                        "2. View all employees\n" +
                        "3. Return to Main Menu\n";

        managerMenuOption = InputClass.askIntInput(managerMenuMessage);

        // Checks the input and connects to other sub-menus depending on the input
        do {
            if (managerMenuOption == 1) {
                ManagerMenu.addEmployee();
                return managerMenu();
            } else if (managerMenuOption == 2) {
                ManagerMenu.viewEmployees();
                return managerMenu();
            } else {
                System.out.println("Invalid Input! Please try again!");
            }
        } while(managerMenuOption != 3);

        return managerMenuOption;
    }
    // Prints the employee menu and asks for integer input (1, 2, 3...7)
    // !!! CALL THIS AFTER CONFIRMING THE PASSWORD !!!
    public static int employeeMenu ()    {

        int employeeMenuOption = 0;

        String employeeMenuMessage =
                        "Employee Screen - Type one of the options below:\n" +
                        "1. Register a game\n" +
                        "2. Remove a game\n" +
                        "3. Register a customer\n" +
                        "4. Remove a customer\n" +
                        "5. Show total rent profit\n" +
                        "6. View all games\n" +
                        "7. Return to Main Menu\n";

        employeeMenuOption = InputClass.askIntInput(employeeMenuMessage);

        // Checks the input and connects to other sub-menus depending on the input
        do {
            if (employeeMenuOption == 1) {
                EmployeeMenu.registerGame();
                return employeeMenu();
            } else if (employeeMenuOption == 2) {
                EmployeeMenu.removeGame();
                return employeeMenu();
            } else if (employeeMenuOption == 3) {
                EmployeeMenu.registerCustomer();
                return employeeMenu();
            } else if (employeeMenuOption == 4) {
                EmployeeMenu.removeCustomer();
                return employeeMenu();
            } else if (employeeMenuOption == 5) {
                EmployeeMenu.showTotalRentProfit();
                return employeeMenu();
            } else if (employeeMenuOption == 6) {
                for(int i = 0; i < DartController.gameList.size(); i++ ){           // TEMPORARY CODE!!! I suggest we create listAllGames() method
                    System.out.println(DartController.gameList.get(i));            // Since it will be more readable and this piece of code right here looks mediocre
                    return employeeMenu();
                }
            } else {
                System.out.println("Invalid Input! Please try again!");
            }
        } while(employeeMenuOption != 7);

        return employeeMenuOption;
    }
    // Prints the customer menu and no password is required here
    public static int customerMenu() {

        int customerMenuOption = 0;

        String customerMenuMessage =
                "Customer Screen - Type one of the options below:\n" +
                "1. Rent a game\n" +
                "2. Return a game\n" +
                "3. Return to Main Menu\n";


        customerMenuOption = InputClass.askIntInput(customerMenuMessage);

        // Checks the input and connects to other sub-menus depending on the input
        do {
            if (customerMenuOption == 1){
                User.rentGame();
                return customerMenu();
            } else if (customerMenuOption == 2) {
                EmployeeMenu.returnGame(); // NOTE: We should move this to User class?!
                return customerMenu();
            } else {
                System.out.println("Invalid Input! Please try again!");
            }


        } while(customerMenuOption != 3);

        return customerMenuOption;
    }
}
