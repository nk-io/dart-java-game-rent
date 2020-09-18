public class Main {

    public static void main (String[] args){

        /*EmployeeMenu.registerGame();
        User.rentGame();
        EmployeeMenu.returnGame();
        EmployeeMenu.showTotalRentProfit();*/

        boolean mainMenuActive = true;
        // Not ideal but for now we'll store our passwords in main
        // Might change this during the meeting?
        final String managerPassword = "admin1234";
        final String employeePassword = "password123";

        // Starts the program by printing the main menu from DartController
        do {
            String mainMenuOption = DartController.mainMenu();

            // Formats the received input to lower case so the program doesn't need to check whether it's upper or lower case
            if (mainMenuOption.toLowerCase().equals("m"))  {

                String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                // Checks whether the typed password matches the manager password
                if (enteredPassword.equals(managerPassword)) {
                    DartController.managerMenu();

                } else {
                    System.out.println("Invalid Password!");
                }

            } else if (mainMenuOption.toLowerCase().equals("e")) {

                String enteredPassword = InputClass.askStringInput("Please type the password to enter: ");
                // Checks whether the typed password matches the employee password
                if (enteredPassword.equals(employeePassword)) {
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
}
