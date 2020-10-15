import java.util.Scanner;

public class InputClass {
    static Scanner input = new Scanner(System.in);

    public static String askStringInput (String message, String errorMessage){
        System.out.println(message);
        String data = input.nextLine();
        if (!data.equals("")) {
            return data;
        } else {
            System.out.println(errorMessage);
            return askStringInput(message, errorMessage);
        }
    }

    public static double askDoubleInput (String message, String errorMessage){

        System.out.println(message);
        String dataInput  = input.nextLine();
        //Instead of taking input as a double and risking an error if the user enters a string
        //We take a string as input and later try to convert it to a double
        //If the conversion fails, the user will be asked to try again
        try {
            double data = Double.parseDouble(dataInput);
            return data;
        } catch (Exception e) {
            message = errorMessage;
            return askDoubleInput(message, errorMessage);
        }
    }

    public static int askIntInput(String message, String errorMessage) {
        System.out.println(message);
        String dataInput  = input.nextLine();
        try {
            int data = Integer.parseInt(dataInput);
            return data;
        } catch (Exception e) {
            message = errorMessage;
            return askIntInput(message, errorMessage);
        }
    }

    //we need to call after reading "X" at main menu
    public static void closeScanner(){
        input.close();
    }
}
