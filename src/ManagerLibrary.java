public class ManagerLibrary extends UserLibrary{
    public Manager registerManager(String name, String password){
        Manager newManager = new Manager(name, password);
        DartController.registeredCustomerList.add(newManager);
        addUserToList(newManager);
        return newManager;
    }
}
