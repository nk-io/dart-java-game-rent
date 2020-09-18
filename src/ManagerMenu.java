public class ManagerMenu {

    public void managerScreen(){

    }
    // Manager's input section for employee information. Refer to Employee.java for the employee object
    public static void addEmployee(){
        // Manager input section
        String employeeName = InputClass.askStringInput("Please enter the employee's name: ");
        int birthYear = InputClass.askIntInput("Please enter the employee's birth year: ");
        String employeeAddress = InputClass.askStringInput("Please enter the employee's address: ");
        double grossSalary = InputClass.askDoubleInput("Please enter the employee's gross salary (in SEK): ");

        Employee employee = new Employee(employeeName, birthYear, employeeAddress, grossSalary);
        DartController.employeeList.add(employee);
        System.out.println(employee.getID() + " : " + employeeName + " - " + birthYear + "( " + employee.getAge() + " ): " + grossSalary + " SEK.");
    }

    // Prints the employeeList from Dart Controller
    public static void viewEmployees(){
        System.out.println("Here is the list of registered employees: ");
        for(int i = 0; i < DartController.employeeList.size(); i++ ){
            System.out.println(DartController.employeeList.get(i));
        }
    }

    // Employee removal is done via the ID (as shown in the printed list)
    public static boolean removeEmployee(){
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
