import java.util.Scanner;

public class InputClass {
    static Scanner input = new Scanner(System.in);

    public static String askStringInput (String message){
        System.out.println(message);
        String data = input.nextLine();
        return data;
    }

    public static double askDoubleInput (String message){
        System.out.println(message);
        String dataInput  = input.nextLine();
        try {
            double data = Double.parseDouble(dataInput);
            return data;
        } catch (Exception e) {
            return askDoubleInput("Invalid input, please enter a double");
        }
    }


    public static int askIntInput(String message) {
        System.out.println(message);
        String dataInput  = input.nextLine();
        try {
            int data = Integer.parseInt(dataInput.trim());
            return data;
        } catch (Exception e) {
            return askIntInput("Invalid input, please enter an integer");
        }
    }



    //we need to call after reading "X" at main menu
    public static void closeScanner(){
        input.close();
    }
}
