// Change Log for Milestone 2
//Manager Menu and Manager classes have been merged
//Methods are no longer statics
//Some properties and methods have been inherited from parent User class
public class Manager extends User{

    Manager(String name, String password){
        super(name, password);
    }

    public void addEmployee(){
        // Manager input section
        String employeeName = InputClass.askStringInput("Please enter the employee's name: ");
        int birthYear = InputClass.askIntInput("Please enter the employee's birth year: ");
        String employeeAddress = InputClass.askStringInput("Please enter the employee's address: ");
        double grossSalary = InputClass.askDoubleInput("Please enter the employee's gross salary (in SEK): ");
        while(grossSalary < 0){
            grossSalary = InputClass.askDoubleInput("Please enter a valid gross salary (in SEK): ");
        }
        //000000 password is temporary pls chage this by asking password when creating new user
        //oh pls delete this comment after u r done :D
        Employee employee = new Employee(employeeName,"000000", birthYear, employeeAddress, grossSalary);
        DartController.employeeList.add(employee);
        System.out.println(employee.toString() + " has been created successfully!");
    }

    // Prints the employeeList from Dart Controller
    public void viewEmployees(){
        System.out.println("Here is the list of registered employees: ");
        for(int i = 0; i < DartController.employeeList.size(); i++ ){
            System.out.println(DartController.employeeList.get(i).toString());
        }
    }

    // Employee removal is done via the ID (as shown in the printed list)
    public boolean removeEmployee(){
        String idToRemove = InputClass.askStringInput("Please enter the employee's ID: ");
        for(int i=0; i<DartController.employeeList.size(); i++){
            if (DartController.employeeList.get(i).getID().equals(idToRemove)){
                System.out.println("Employee with ID " + DartController.employeeList.get(i).toString() + " has been removed!");
                DartController.employeeList.remove(i);
                return true;
            }
        }
        System.out.println("Employee with ID " + idToRemove + " not found");
        return false;
    }
}
