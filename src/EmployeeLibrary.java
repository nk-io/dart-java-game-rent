public class EmployeeLibrary extends UserLibrary {
    public Employee addEmployee(String name, String password, int birthYear, String employeeAddress, double grossSalary){
        Employee newEmployee = new Employee(name, password, birthYear, employeeAddress, grossSalary);
        addUserToList(newEmployee);
        return newEmployee;
    }
}
