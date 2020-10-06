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
    //this is gonna be relocated
    public void showTotalRentProfit(){
        System.out.println("The total rent profit is "+ DartController.totalRentProfit + " SEK");
    }

}
