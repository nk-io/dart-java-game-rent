public class UserInterface {


//--------------------------------------------Items
    public void registerGame(){
        GameLibrary gameLibrary = new GameLibrary();
        String title = InputClass.askStringInput("Please enter the name of the game: ");
        String genre = InputClass.askStringInput("Please enter the genre of the game: ");
        double dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        while(dailyRentFee < 0 ){
            dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        }
        Object newGame = gameLibrary.registerGame(title, genre, dailyRentFee);
        System.out.println("The game with " + newGame.toString() + " has been created successfully.");
    }


    public void removeGame(){
        GameLibrary gameLibrary = new GameLibrary();
        gameLibrary.listAll();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the game you want to remove: ");
        boolean removed = gameLibrary.removeItem(idToRemove);
        if (removed){
            System.out.println("The game with id " + idToRemove + " has been removed!");
        } else {
            System.out.println("The  game with id: " + idToRemove + " not found.");
        }
    }


    public void listAllGames(){
        GameLibrary gameLibrary = new GameLibrary();
        System.out.println(gameLibrary.listAll());
    }


    public void registerAlbum(){
        AlbumLibrary albumLibrary = new AlbumLibrary();
        String title = InputClass.askStringInput("Please enter the name of the album: ");
        String artist = InputClass.askStringInput("Please enter the artist of the album: ");
        int year = InputClass.askIntInput("Please enter the release year for the album: ");
        double dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        while(dailyRentFee < 0 ){
            dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        }
        Object newAlbum = albumLibrary.registerAlbum(title, artist, year, dailyRentFee);
        System.out.println("The album with " + newAlbum.toString() + " has been created successfully.");
    }


    public void removeAlbum(){
        AlbumLibrary albumLibrary = new AlbumLibrary();
        albumLibrary.listAll();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the album you want to remove: ");
        boolean removed = albumLibrary.removeItem(idToRemove);
        if (removed){
            System.out.println("The album with id " + idToRemove + " has been removed!");
        } else {
            System.out.println("The  album with id: " + idToRemove + " not found.");
        }
    }


    public void listAllAlbums(){
        AlbumLibrary albumLibrary = new AlbumLibrary();
        System.out.println(albumLibrary.listAll());
    }


    public void rentGame(){
        GameLibrary gameLibrary = new GameLibrary();
        gameLibrary.listAll();
        String idToRent = InputClass.askStringInput("Enter item id of the game you want to rent: ");
        boolean rented = gameLibrary.rentItem(idToRent);
        if (rented){
            System.out.println("The game with id: " + idToRent + " has been rented successfully!");
        } else {
            System.out.println("The game with id: " + idToRent + " is already rented or not found.");
        }
    }


    public void rentAlbum(){
        AlbumLibrary albumLibrary = new AlbumLibrary();
        albumLibrary.listAll();
        String idToRent = InputClass.askStringInput("Enter item album of the game you want to rent: ");
        boolean rented = albumLibrary.rentItem(idToRent);
        if (rented){
            System.out.println("The album with id: " + idToRent + " has been rented successfully!");
        } else {
            System.out.println("The album with id: " + idToRent + " is already rented or not found.");
        }
    }


    public void returnGame(){
        GameLibrary gameLibrary = new GameLibrary();
        gameLibrary.listAll();
        String idToReturn = InputClass.askStringInput("Please enter the ID of the game you want to return: ");
        Item isIDRight = gameLibrary.doesItemExist(idToReturn);
        if (isIDRight != null){
            int daysRented = InputClass.askIntInput("Please enter the number of days you rented the game: ");
            while (daysRented < 0) {
                daysRented = InputClass.askIntInput("Please enter a valid number of days: ");
            }
            double totalRentFee = gameLibrary.returnItem(isIDRight.toString(), daysRented);
            System.out.println("The total fee is: " + totalRentFee + " SEK.");
            System.out.println("The game has been successfully returned. ");
        } else {
            System.out.println("Game with ID: " + idToReturn + " was not found or is not rented. ");
        }
    }


    public void returnAlbum(){
        AlbumLibrary albumLibrary = new AlbumLibrary();
        albumLibrary.listAll();
        String idToReturn = InputClass.askStringInput("Please enter the ID of the album you want to return: ");
        Item isIDRight = albumLibrary.doesItemExist(idToReturn);
        if (isIDRight != null){
            int daysRented = InputClass.askIntInput("Please enter the number of days you rented the album: ");
            while (daysRented < 0) {
                daysRented = InputClass.askIntInput("Please enter a valid number of days: ");
            }
            double totalRentFee = albumLibrary.returnItem(isIDRight.toString(), daysRented);
            System.out.println("The total fee is: " + totalRentFee + " SEK.");
            System.out.println("The album has been successfully returned. ");
        } else {
            System.out.println("Album with ID: " + idToReturn + " was not found or is not rented. ");
        }
    }

//--------------------------------------------People

    public void registerCustomer(){
        CustomerLibrary customerLibrary = new CustomerLibrary();
        String name = InputClass.askStringInput("Please enter the name of the customer: ");
        String password = InputClass.askStringInput("Please enter a new password: ");
        Object newCustomer = customerLibrary.registerCustomer(name, password);
        System.out.println("The customer " + newCustomer.toString() + " has been created successfully.");
    }


    public void removeCustomer(){
        CustomerLibrary customerLibrary = new CustomerLibrary();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the customer to remove: ");
        boolean removed = customerLibrary.removeUser(idToRemove);
        if (removed){
            System.out.println("Customer with ID" + idToRemove + " has been removed!");
        } else {
            System.out.println("Customer with id: " + idToRemove + " not found.");
        }
    }


    public void registerEmployee(){
        EmployeeLibrary employeeLibrary = new EmployeeLibrary();
        String employeeName = InputClass.askStringInput("Please enter the employee's name: ");
        String password = InputClass.askStringInput("Please enter a new password: ");
        int birthYear = InputClass.askIntInput("Please enter the employee's birth year: ");
        String employeeAddress = InputClass.askStringInput("Please enter the employee's address: ");
        double grossSalary = InputClass.askDoubleInput("Please enter the employee's gross salary (in SEK): ");
        while(grossSalary < 0){
            grossSalary = InputClass.askDoubleInput("Please enter a valid gross salary (in SEK): ");
        }
        Object newEmployee = employeeLibrary.registerEmployee(employeeName, password, birthYear, employeeAddress,grossSalary);
        System.out.println(newEmployee.toString()+ " has been created successfully!");
    }


    public void removeEmployee(){
        EmployeeLibrary employeeLibrary = new EmployeeLibrary();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the employee to remove: ");
        boolean removed = employeeLibrary.removeUser(idToRemove);
        if (removed){
            System.out.println("Employee with ID" + idToRemove + " has been removed!");
        } else {
            System.out.println("Employee with id: " + idToRemove + " not found.");
        }
    }


    public void registerManager(){
        ManagerLibrary managerLibrary = new ManagerLibrary();
        String name = InputClass.askStringInput("Please enter the name of the manager: ");
        String password = InputClass.askStringInput("Please enter a new password: ");
        Object newCustomer = managerLibrary.registerManager(name, password);
        System.out.println("The manager " + newCustomer.toString() + " has been created successfully.");
    }


    public void removeManager(){
        ManagerLibrary managerLibrary = new ManagerLibrary();
        String idToRemove = InputClass.askStringInput("Please enter the ID of the manager to remove: ");
        boolean removed = managerLibrary.removeUser(idToRemove);
        if (removed){
            System.out.println("Manager with ID" + idToRemove + " has been removed!");
        } else {
            System.out.println("Manager with id: " + idToRemove + " not found.");
        }
    }

//--------------------------------------------Messages
/*
    public void sendAMessage(){
        MessageLibrary messageLibrary = new MessageLibrary();
        String receiverID = InputClass.askStringInput("Please enter the ID of the user you want to sena a message to: ");
        String message = InputClass.askStringInput("Please enter your message: ");
        User user = new User();
        CustomerLibrary customerLibrary = new CustomerLibrary();
        Message sent = messageLibrary.sendAMessage(receiverID, getID(), getName, customerLibrary, message);
        if (sent != null){
            System.out.println("Your message has been sent successfully!");
        }else {
            System.out.println("Customer with ID: "+ receiverID + " cannot found!");
        }
    }


 */


}















