import java.util.ArrayList;

public class UserInterface {

    private GameLibrary gameLibrary;
    private AlbumLibrary albumLibrary;
    private ManagerLibrary managerLibrary;
    private EmployeeLibrary employeeLibrary;
    private CustomerLibrary customerLibrary;
    private MessageLibrary messageLibrary;
    private ReviewLibrary reviewLibrary;
    private RentHistoryLibrary rentHistoryLibrary;

    public UserInterface(GameLibrary gameLibrary, AlbumLibrary albumLibrary, ManagerLibrary managerLibrary, EmployeeLibrary employeeLibrary, CustomerLibrary customerLibrary, MessageLibrary messageLibrary, ReviewLibrary reviewLibrary, RentHistoryLibrary rentHistoryLibrary){
        this.gameLibrary = gameLibrary;
        this.albumLibrary = albumLibrary;
        this.managerLibrary = managerLibrary;
        this.employeeLibrary = employeeLibrary;
        this.customerLibrary = customerLibrary;
        this.messageLibrary = messageLibrary;
        this.reviewLibrary = reviewLibrary;
        this.rentHistoryLibrary = rentHistoryLibrary;

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


    public void rentGame(Customer customer){
        if (customer.getNumOfCurrentRentedItems() < customer.getMembership().getRentalLimit()) {
            listAllGames();
            String idToRent = InputClass.askStringInput("Enter item id of the game you want to rent: ");
            if (gameLibrary.rentItem(idToRent, customer)) {
                System.out.println("The game with id: " + idToRent + " has been rented successfully!");
            } else {
                System.out.println("The game with id: " + idToRent + " is already rented or not found.");
            }
        } else {
            System.out.println("Rental limit exceeded! You're currently renting " +
                    customer.getNumOfCurrentRentedItems() + " items out of " +
                    customer.getMembership().getRentalLimit());
        }
    }


    public void rentAlbum(Customer customer){
        if (customer.getNumOfCurrentRentedItems() < customer.getMembership().getRentalLimit()) {
            listAllAlbums();
            String idToRent = InputClass.askStringInput("Enter item id of the album you want to rent: ");
            if (albumLibrary.rentItem(idToRent, customer)) {
                System.out.println("The album with id: " + idToRent + " has been rented successfully!");

            } else {
                System.out.println("The album with id: " + idToRent + " is already rented or not found.");
            }
        } else {
            System.out.println("Rental limit exceeded! You're currently renting " +
                    customer.getNumOfCurrentRentedItems() + " items out of " +
                    customer.getMembership().getRentalLimit());
        }
    }


    public void returnGame(Customer customer){
        String customerItems = customer.getCurrentRentedGamesByCustomer();
        if(customerItems.equals("")){
            System.out.println("You have no game to return!");
        } else {
            System.out.println(customerItems);
            String idToReturn = InputClass.askStringInput("Please enter the ID of the game you want to return: ");
            Game isIDRight = (Game) gameLibrary.doesItemExist(idToReturn);
            if (isIDRight != null && !gameLibrary.isItAvailable(idToReturn) && customer.checkIfTheItemRentedByCustomer(idToReturn)) {
                double rentExpense = 0;
                int daysRented = InputClass.askIntInput("Please enter the number of days you rented the game: ");
                while (daysRented < 0) {
                    daysRented = InputClass.askIntInput("Please enter a valid number of days: ");
                }
                if (customer.getStoreCredits() > 4) {
                    rentExpense = gameLibrary.returnItem(idToReturn, daysRented, customer);
                    System.out.println("You have used 5 credits and rented the game for free.");
                } else {
                    rentExpense = gameLibrary.returnItem(idToReturn, daysRented, customer);
                    System.out.println("The total fee is: " + rentExpense + " SEK.");
                    System.out.println("The game has been successfully returned. ");
                }

                giveRating(isIDRight, customer);
                RentHistory newTransaction = new RentHistory(customer, isIDRight, daysRented, rentExpense);
                rentHistoryLibrary.addRentHistory(newTransaction);
            } else {
                System.out.println("Game with ID: " + idToReturn + " was not found or is not rented by you. ");
            }
        }
    }


    public void returnAlbum(Customer customer){
        String customerItems = customer.getCurrentRentedAlbumsByCustomer();
        if(customerItems.equals("")){
            System.out.println("You have no album to return!");
        } else{
            System.out.println(customerItems);
            String idToReturn = InputClass.askStringInput("Please enter the ID of the album you want to return: ");
            Album isIDRight = (Album) albumLibrary.doesItemExist(idToReturn);
            if (isIDRight != null && !albumLibrary.isItAvailable(idToReturn) && customer.checkIfTheItemRentedByCustomer(idToReturn)){
                double rentExpense = 0;
                int daysRented = InputClass.askIntInput("Please enter the number of days you rented the album: ");
                while (daysRented < 0) {
                    daysRented = InputClass.askIntInput("Please enter a valid number of days: ");
                }
                if (customer.getStoreCredits() > 4){
                    System.out.println("You have used 5 credits and rented the album for free.");
                    rentExpense = albumLibrary.returnItem(idToReturn, daysRented, customer);

                } else {
                    rentExpense = albumLibrary.returnItem(idToReturn, daysRented, customer);
                    System.out.println("The total fee is: " + rentExpense + " SEK.");
                    System.out.println("The album has been successfully returned. ");
                };
                giveRating(isIDRight, customer);
                RentHistory newTransaction = new RentHistory(customer, isIDRight, daysRented, rentExpense);
                rentHistoryLibrary.addRentHistory(newTransaction);
            } else {
                System.out.println("Album with ID: " + idToReturn + " was not found or is not rented by you. ");
            }
        }

    }

    // needed to change this for 11.1 return behaviors
    // should work the same

    private void giveRating(Item returnedItem, Customer customer){
        String ratingCheck = InputClass.askStringInput("Would you like rate this item? Enter Yes or No ");
        while (!ratingCheck.equalsIgnoreCase("YES") && !ratingCheck.equalsIgnoreCase("NO")) {
            ratingCheck = InputClass.askStringInput("Invalid input. Please enter yes or no!");
        }
        if(ratingCheck.equalsIgnoreCase(("NO"))){
            System.out.println("No review given.");
        } else {
            giveRatingScore(returnedItem);
            String reviewCheck = InputClass.askStringInput("Would you leave written review? Enter Yes or No ");
            while(!reviewCheck.equalsIgnoreCase("YES") && !reviewCheck.equalsIgnoreCase("NO")){
                reviewCheck = InputClass.askStringInput("Invalid input. Please enter yes or no!");
            }
            if(reviewCheck.equalsIgnoreCase("YES")){
                giveWrittenReview(returnedItem, customer);
            } else {
                System.out.println("Thank you for leaving a rating.");
            }
        }
    }


    private void giveRatingScore(Item returnedItem) {
            int userRating = InputClass.askIntInput("Please enter your rating (a number between 0 and 5): ");
            while (userRating < 0 || userRating > 5) {
                userRating = InputClass.askIntInput("Please enter a number between 0 and 5: ");
            }
            returnedItem.giveRating(userRating);
    }


    private void giveWrittenReview(Item returnedItem, Customer customer){
            String review = InputClass.askStringInput("Please enter your written review: ");
            reviewLibrary.submitReview(returnedItem.getID(), customer, review);
            System.out.println("Thank you for leaving a review and rating!");
    }


    public void searchItem(){
        String itemCheck = InputClass.askStringInput("What is the item you are looking for? Type G for games, or A for albums.");
        while(!itemCheck.equalsIgnoreCase("G") && !itemCheck.equalsIgnoreCase("A")){
            itemCheck = InputClass.askStringInput("Invalid input! Please enter G for games, or A for albums!");
        }
        if(itemCheck.equalsIgnoreCase("G")){
            String genreToSearch = InputClass.askStringInput("Please enter the genre you are looking for: ");
            String gamesWithGenre = gameLibrary.searchByGenre(genreToSearch);
            System.out.println(gamesWithGenre);


        } else if(itemCheck.equalsIgnoreCase("A")){
            int yearToSearch = InputClass.askIntInput("Please enter the year you are looking for: ");
            String albumsByYear = albumLibrary.searchByYear(yearToSearch);
            System.out.println(albumsByYear);
        }
    }


    public void showTotalRentProfit(){
        System.out.println("Total rent profit for all items rented: " + rentHistoryLibrary.calculateTotalProfit() + "SEK");
    }

    public void listRentFrequency(){
        System.out.println("All items rent frequency: \n" + rentHistoryLibrary.showRentFrequency());
    }

    public void listRentTransactions(){
        System.out.println("List of rent history transactions: \n" + rentHistoryLibrary.showAllRentHistory());
    }

    public void showMostProfitableItem(){
        String itemID =rentHistoryLibrary.getMostProfitableItem();
        Item itemInfo;
        if(gameLibrary.doesItemExist(itemID) == null){
            itemInfo = albumLibrary.doesItemExist(itemID);
        } else{
            itemInfo = gameLibrary.doesItemExist(itemID);
        };
        System.out.println("Most profitable item: " + itemInfo.toString() );
    }

    public void showBestCustomer(){
        String bestCustomerID =rentHistoryLibrary.getBestCustomer();
       System.out.println("Best customer: id: " + bestCustomerID + " name: " + customerLibrary.getName(bestCustomerID));
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


    public void viewCredits(Customer customer){
        System.out.println("You have: " + customer.getStoreCredits() + " credits.");
    }

    public void upgradeCustomer(){
        System.out.println("Pending customer upgrade requests:");
        ArrayList<Customer> customersToUpgrade = new ArrayList<>();
        int optionsCounter = 0;
        for (User user: customerLibrary.getUsers()) {
            Customer customer = (Customer) user;
            if (customer.getUpgradeRequest() == true && customer.getMembership() != Membership.PLATINUM) {
                optionsCounter += 1;
                customersToUpgrade.add(customer);
                System.out.println(optionsCounter + ". Customer ID: " + customer.getID() + " | Membership: " + customer.getMembership().toString());
            }
        }

        if (customersToUpgrade.size() > 0) {
            optionsCounter += 1;
            System.out.println(optionsCounter + ". Return to Employee Menu.");

            int option = InputClass.askIntInput("Please select the customer you wish to interact with, or return to the previous menu: ");
            if (option == optionsCounter) { return;}
            else if (option > 0 && option <= customersToUpgrade.size()) {
                Customer customer = customersToUpgrade.get(option - 1);
                int approveOption = InputClass.askIntInput("Do you wish to approve or reject the membership request? \n1. Approve\n2. Reject");
                if (approveOption == 1) {

                    switch (customer.getMembership()) {
                        case NONE -> customer.setMembership(Membership.SILVER);
                        case SILVER -> customer.setMembership(Membership.GOLD);
                        case GOLD -> customer.setMembership(Membership.PLATINUM);
                    }
                    customer.setUpgradeRequest(false);
                    System.out.println("The customer " + customer.getID() + " has been upgraded to " + customer.getMembership().toString() + " membership!");
                }
                else if (approveOption == 2){
                    System.out.println("This membership request has been rejected.");
                    customer.setUpgradeRequest(false);
                } else { System.out.println("Invalid input.");
                }
            } else {
                System.out.println("Invalid input.");
            }
        } else {
            System.out.println("There are no currently pending customer upgrade requests.");
        }
    }

    public void requestMembershipUpgrade(Customer customer) {
        if (customer.getMembership() == Membership.PLATINUM) {
            System.out.println("You have reached the maximum membership level and cannot be upgraded further!");
        } else if (customer.getUpgradeRequest() == true) {
            System.out.println("You have already requested to be upgraded! Your request is still being reviewed!");
        } else {
            customer.setUpgradeRequest(true);
            System.out.println(("Your request to be upgraded has been submitted!"));
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
