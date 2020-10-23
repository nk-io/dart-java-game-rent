package exception;

public class EmployeeNegativeSalaryException extends RuntimeException{
    public EmployeeNegativeSalaryException(){
        super("Invalid data. Employee salary cannot be negative.");
    }
}