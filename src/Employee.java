// Change Log for Milestone 2
//Employee Menu and Employee classes have been merged
//Methods are no longer statics
//Some properties have been inherited from parent User class
import java.time.LocalDateTime;
public class Employee extends User{
    private int birthYear;
    private String address;
    // $$ Related
    private double grossSalary;
    private double netSalary;
    private double ageBonus;


    Employee(String name, String password, int birthYear, String address, double grossSalary) {
        super(name, password);
        this.birthYear = birthYear;
        this.address = address;
        setGrossSalary(grossSalary);
    }

    // Getters for the employee's information (encapsulated)

    public int getBirthYear() {
        return birthYear;
    }
    public int getAge() {
        int currentYear = LocalDateTime.now().getYear();
        return currentYear - this.birthYear;
    }
    public String getAddress(){
        return address;
    }
    public double getGrossSalary() {
        return grossSalary;
    }
    public double getNetSalary() {
        return netSalary;
    }
    public double getAgeBonus() {
        return ageBonus;
    }

    // Setters to modify information for the employee
    public void setAddress(String address) {
        this.address = address;
    }
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
        calculateNetSalary(grossSalary);
        calculateAgeBonus(getAge());
    }

    @Override
    public String toString() {
        return  "ID='" + getID() + '\'' +
                ", name='" + getName() + '\'' +
                ", birth year=" + birthYear +
                ", address='" + address + '\'' +
                ", gross salary=" + grossSalary;
    }



    // Gross salary & age bonus to an employee's salary.
    // Kept private due to the way they are evaluated.
    private void calculateNetSalary(double grossSalary){
        if (grossSalary < 100000.00) {
            netSalary = grossSalary;
        }
        else {
            netSalary = (grossSalary-(grossSalary *.3));
        }
    }
    private void calculateAgeBonus(int age){
        if (age < 22) {
            ageBonus = netSalary + 4000;
        }
        else if (age <= 30) {
            ageBonus = netSalary + 6000;
        }
        else {
            ageBonus = netSalary + 7500;
        }
    }

    public void showTotalRentProfit(){
        System.out.println("The total rent profit is "+ DartController.totalRentProfit + " SEK");
    }

    //EPIC FEATURE 3
    public void registerGame(){
        //required fields for a game
        String title;
        String genre;
        double dailyRentFee;

        //Input and Output will be change after we got the input class

        title = InputClass.askStringInput("Please enter the name of the game: ");
        genre = InputClass.askStringInput("Please enter the genre of the game: ");
        dailyRentFee = InputClass.askDoubleInput("Please enter the daily rent fee: ");
        while(dailyRentFee < 0 ){
            dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        }

        //lets create the new game
        Game newGame = new Game(title,genre,dailyRentFee);
        DartController.gameList.add(newGame);
        System.out.println("Game with "+ newGame.toString() + " has been created successfully");

    }

    // search given ID in gameList array list
    // if ID exists remove game object from the array list. return true
    // if not print a message then return false
    public boolean removeGame(){
        //Input and Output will be change after we got the input class
        String idToRemove = InputClass.askStringInput("Please enter the ID of the game: ");

        //lets check if game exist
        for(int i=0; i<DartController.gameList.size(); i++){
            if (DartController.gameList.get(i).getID().equals(idToRemove)){
                //if ID's are equal remove the Game object from the array list
                System.out.println("Game with " + DartController.gameList.get(i).toString() + " has been removed!");
                DartController.gameList.remove(i);
                return true;
            }
        }
        System.out.println("Game with id:" + idToRemove + " not found");

        return false;

    }

    //EPIC FEATURE 4
    //add a new customer
    public void registerCustomer(){
        //Required fields for a new customer
        String name;

        //Creating the new customer
        name = InputClass.askStringInput("Please enter the name of the customer: ");
        //000000 password is temporary pls chage this by asking password when creating new user
        //oh pls delete this comment after u r done :D
        Customer newCustomer = new Customer(name, "000000");
        DartController.registeredCustomerList.add(newCustomer);

        System.out.println("The customer " + newCustomer.toString() + " has been created successfully.");
    }


    //remove an existing customer
    public boolean removeCustomer() {
        String customerToRemove = InputClass.askStringInput("Please enter the ID of the customer: ");

        //check if the customer exists
        for(int i = 0; i < DartController.registeredCustomerList.size(); i++){
            if(DartController.registeredCustomerList.get(i).getID().equals(customerToRemove)){
                System.out.println("Customer with " + DartController.registeredCustomerList.get(i).toString() + " has been removed!");
                DartController.registeredCustomerList.remove(i);
                return true;
            }
        }

        //informs if the customer doesn't exist
        System.out.println("Customer with id: " + customerToRemove + " not found.");
        return false;
    }
}
