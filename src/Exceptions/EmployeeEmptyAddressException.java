package Exceptions;

public class EmployeeEmptyAddressException extends RuntimeException{
    public EmployeeEmptyAddressException(){
        super("Invalid data. Employee address cannot be empty.");
    }
}
