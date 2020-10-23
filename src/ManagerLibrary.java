class ManagerLibrary extends UserLibrary{
    public Manager registerManager(String name, String password){
        Manager newManager = new Manager(name, password);
        addUserToList(newManager);
        return newManager;
    }
}
