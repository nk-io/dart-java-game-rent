package exception;

public class EmployeeNegativeBirthYearException extends RuntimeException{
    public EmployeeNegativeBirthYearException(){
        super("Invalid data. Employee birth year cannot be negative.");
    }
}
