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
        double data = input.nextDouble();
        input.nextLine();
        return data;
    }

    public static int askIntInput(String message){
        System.out.println(message);
        int data = input.nextInt();
        input.nextLine();
        return data;
    }

    //we need to call after reading "X" at main menu
    public static void closeScanner(){
        input.close();
    }
}
