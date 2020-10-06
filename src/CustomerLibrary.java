public class CustomerLibrary extends UserLibrary {
    public Customer registerCustomer(String name, String password){
        Customer newCustomer = new Customer(name, password);
        addUserToList(newCustomer);
        return newCustomer;
    }
}
