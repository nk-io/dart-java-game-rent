import java.util.Scanner;

class InputClass {
    static Scanner input = new Scanner(System.in);

    public static String askStringInput (String message){
        System.out.println(message);
        return input.nextLine();
    }

    public static double askDoubleInput (String message){
        System.out.println(message);
        String dataInput  = input.nextLine();
        //We take a string as input and later try to convert it to a double, If the conversion fails, the user will be asked to try again
        try {
            return Double.parseDouble(dataInput);
        } catch (Exception e) {
            return askDoubleInput("Invalid input. Please enter a number.");
        }
    }

    public static int askIntInput(String message) {
        System.out.println(message);
        String dataInput  = input.nextLine();
        try {
            return Integer.parseInt(dataInput);
        } catch (Exception e) {
            return askIntInput("Invalid input. Please enter an integer.");
        }
    }

    //we need to call after reading "X" at main menu
    public static void closeScanner(){
        input.close();
    }

}
