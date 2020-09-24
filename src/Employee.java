import java.time.LocalDateTime;

public class Employee {
    // Randomly generated ID
    private String ID;
    // Personal data
    private String name;
    private int birthYear;
    private String address;
    // $$ Related
    private double grossSalary;
    private double netSalary;
    private double ageBonus;

    Employee() {
    }

    Employee(String name, int birthYear, String address, double grossSalary) {
        this.name = name;
        this.ID = RandomUID.generateRandomID();
        this.birthYear = birthYear;
        this.address = address;
        setGrossSalary(grossSalary);
    }

    // Getters for the employee's information (encapsulated)
    public String getName(){
        return name;
    }
    public String getID() {
        return ID;
    }
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
    public void setName(String name) {
        this.name = name;
    }
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
        return  "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
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
}
