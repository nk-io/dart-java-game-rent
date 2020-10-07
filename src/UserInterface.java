public class UserInterface {

    private GameLibrary gameLibrary;
    private AlbumLibrary albumLibrary;
    private ManagerLibrary managerLibrary;
    private EmployeeLibrary employeeLibrary;
    private CustomerLibrary customerLibrary;
    private MessageLibrary messageLibrary;
    public UserInterface(GameLibrary gameLibrary, AlbumLibrary albumLibrary, ManagerLibrary managerLibrary, EmployeeLibrary employeeLibrary, CustomerLibrary customerLibrary, MessageLibrary messageLibrary){
        this.gameLibrary = gameLibrary;
        this.albumLibrary = albumLibrary;
        this.managerLibrary = managerLibrary;
        this.employeeLibrary = employeeLibrary;
        this.customerLibrary = customerLibrary;
        this.messageLibrary = messageLibrary;
    }

    //--------------------------------------------Items

    public void registerGame(){
        String title = InputClass.askStringInput("Please enter the name of the game: ");
        String genre = InputClass.askStringInput("Please enter the genre of the game: ");
        double dailyRentFee = InputClass.askDoubleInput("Please enter the daily rent fee: ");
        while(dailyRentFee < 0 ){
            dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        }
        Game newGame = gameLibrary.registerGame(title, genre, dailyRentFee);
        System.out.println("The game with " + newGame.toString() + " has been created successfully.");
    }


    public void removeGame(){
        listAllGames();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the game you want to remove: ");
        boolean removed = gameLibrary.removeItem(idToRemove);
        if (removed){
            System.out.println("The game with id " + idToRemove + " has been removed!");
        } else {
            System.out.println("The  game with id: " + idToRemove + " not found.");
        }
    }


    public void listAllGames(){
        if (gameLibrary.listAll() != null){
            System.out.println(gameLibrary.listAll());
        } else {
            System.out.println("There are no games registered in the system.");
        }
    }


    public void registerAlbum(){
        String title = InputClass.askStringInput("Please enter the name of the album: ");
        String artist = InputClass.askStringInput("Please enter the artist of the album: ");
        int year = InputClass.askIntInput("Please enter the release year for the album: ");
        double dailyRentFee = InputClass.askDoubleInput("Please enter the daily rent fee: ");
        while(dailyRentFee < 0 ){
            dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        }
        Album newAlbum = albumLibrary.registerAlbum(title, artist, year, dailyRentFee);
        System.out.println("The album with " + newAlbum.toString() + " has been created successfully.");
    }


    public void removeAlbum(){
        listAllAlbums();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the album you want to remove: ");
        boolean removed = albumLibrary.removeItem(idToRemove);
        if (removed){
            System.out.println("The album with id " + idToRemove + " has been removed!");
        } else {
            System.out.println("The  album with id: " + idToRemove + " not found.");
        }
    }


    public void listAllAlbums(){
        if (albumLibrary.listAll() != null){
            System.out.println(albumLibrary.listAll());
        } else {
            System.out.println("There are no albums registered in the system.");
        }
    }


    public void rentGame(){
        listAllGames();
        String idToRent = InputClass.askStringInput("Enter item id of the game you want to rent: ");
        boolean rented = gameLibrary.rentItem(idToRent);
        if (rented){
            System.out.println("The game with id: " + idToRent + " has been rented successfully!");
        } else {
            System.out.println("The game with id: " + idToRent + " is already rented or not found.");
        }
    }


    public void rentAlbum(){
        listAllAlbums();
        String idToRent = InputClass.askStringInput("Enter item album of the game you want to rent: ");
        boolean rented = albumLibrary.rentItem(idToRent);
        if (rented){
            System.out.println("The album with id: " + idToRent + " has been rented successfully!");
        } else {
            System.out.println("The album with id: " + idToRent + " is already rented or not found.");
        }
    }


    public void returnGame(){
        listAllGames();
        String idToReturn = InputClass.askStringInput("Please enter the ID of the game you want to return: ");
        Game isIDRight = (Game) gameLibrary.doesItemExist(idToReturn);
        if (isIDRight != null && !gameLibrary.IsItAvailable(idToReturn)){
            int daysRented = InputClass.askIntInput("Please enter the number of days you rented the game: ");
            while (daysRented < 0) {
                daysRented = InputClass.askIntInput("Please enter a valid number of days: ");
            }
            double totalRentFee = gameLibrary.returnItem(idToReturn, daysRented);
            System.out.println("The total fee is: " + totalRentFee + " SEK.");
            System.out.println("The game has been successfully returned. ");
        } else {
            System.out.println("Game with ID: " + idToReturn + " was not found or is not rented. ");
        }
    }


    public void returnAlbum(){
        listAllAlbums();
        String idToReturn = InputClass.askStringInput("Please enter the ID of the album you want to return: ");
        Album isIDRight = (Album) albumLibrary.doesItemExist(idToReturn);
        if (isIDRight != null && !albumLibrary.IsItAvailable(idToReturn)){
            int daysRented = InputClass.askIntInput("Please enter the number of days you rented the album: ");
            while (daysRented < 0) {
                daysRented = InputClass.askIntInput("Please enter a valid number of days: ");
            }
            double totalRentFee = albumLibrary.returnItem(idToReturn, daysRented);
            System.out.println("The total fee is: " + totalRentFee + " SEK.");
            System.out.println("The album has been successfully returned. ");
        } else {
            System.out.println("Album with ID: " + idToReturn + " was not found or is not rented. ");
        }
    }

//--------------------------------------------People

    public void registerCustomer(){
        String name = InputClass.askStringInput("Please enter the name of the customer: ");
        String password = InputClass.askStringInput("Please enter a new password: ");
        Customer newCustomer = customerLibrary.registerCustomer(name, password);
        System.out.println("The customer " + newCustomer.toString() + " has been created successfully.");
    }


    public void removeCustomer(){
        listAllCustomers();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the customer to remove: ");
        boolean removed = customerLibrary.removeUser(idToRemove);
        if (removed){
            System.out.println("Customer with ID" + idToRemove + " has been removed!");
        } else {
            System.out.println("Customer with id: " + idToRemove + " not found.");
        }
    }


    public void listAllCustomers(){
        if (customerLibrary.listAll() != null){
            System.out.println(customerLibrary.listAll());
        } else {
            System.out.println("There are no customers registered in the system.");
        }
    }


    public void registerEmployee(){
        String employeeName = InputClass.askStringInput("Please enter the employee's name: ");
        String password = InputClass.askStringInput("Please enter a new password: ");
        int birthYear = InputClass.askIntInput("Please enter the employee's birth year: ");
        String employeeAddress = InputClass.askStringInput("Please enter the employee's address: ");
        double grossSalary = InputClass.askDoubleInput("Please enter the employee's gross salary (in SEK): ");
        while(grossSalary < 0){
            grossSalary = InputClass.askDoubleInput("Please enter a valid gross salary (in SEK): ");
        }
        Employee newEmployee = employeeLibrary.registerEmployee(employeeName, password, birthYear, employeeAddress,grossSalary);
        System.out.println(newEmployee.toString()+ " has been created successfully!");
    }


    public void removeEmployee(){
        listAllEmployees();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the employee to remove: ");
        boolean removed = employeeLibrary.removeUser(idToRemove);
        if (removed){
            System.out.println("Employee with ID" + idToRemove + " has been removed!");
        } else {
            System.out.println("Employee with id: " + idToRemove + " not found.");
        }
    }


    public void listAllEmployees(){
        if (employeeLibrary.listAll() != null){
            System.out.println(employeeLibrary.listAll());
        } else {
            System.out.println("There are no employees registered in the system.");
        }
    }


    public void registerManager(){
        String name = InputClass.askStringInput("Please enter the name of the manager: ");
        String password = InputClass.askStringInput("Please enter a new password: ");
        Manager newManager = managerLibrary.registerManager(name, password);
        System.out.println("The manager " + newManager.toString() + " has been created successfully.");
    }


    public void removeManager(){
        listAllManagers();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the manager to remove: ");
        boolean removed = managerLibrary.removeUser(idToRemove);
        if (removed){
            System.out.println("Manager with ID" + idToRemove + " has been removed!");
        } else {
            System.out.println("Manager with id: " + idToRemove + " not found.");
        }
    }

    public void listAllManagers(){
        if (managerLibrary.listAll() != null){
            System.out.println(managerLibrary.listAll());
        } else {
            System.out.println("There are no managers registered in the system.");
        }
    }

//--------------------------------------------Messages

    public void sendAMessage(String enteredID){
        String receiverID = InputClass.askStringInput("Please enter the ID of the user you want to send a message to: ");
        String message = InputClass.askStringInput("Please enter your message: ");
        Message sent = messageLibrary.sendAMessage(receiverID, enteredID, customerLibrary.getName(enteredID), customerLibrary, message);
        System.out.println();
        if (sent != null){
            System.out.println("Your message has been sent successfully!");
        }else {
            System.out.println("Customer with ID: "+ receiverID + " cannot found!");
        }
    }


    public void showCustomerMessages(String enteredID){
        System.out.println(messageLibrary.showCustomersMessages(enteredID));
    }


    public void deleteAMessage(String enteredID){
        messageLibrary.deleteAMessage(enteredID);
    }

}
