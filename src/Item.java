import java.util.ArrayList;

public class Item {
    private static ArrayList<Item> itemList = new ArrayList<>();

    private String ID;
    private String title;
    private String artist;
    private String genre;
    private int year;
    private double dailyRentFee;
    private String rentStatus;

    Item(){
    }

    Item(String title, String artist, String genre, int year, double dailyRentFee){
        this.ID = RandomUID.generateRandomID();
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.dailyRentFee = dailyRentFee;
        this.rentStatus = "Available";
    }


    public void registerItem(String itemType){
        String title;
        String artist = null;
        String genre = null;
        int year;
        double dailyRentFee;
        String toString;

        title = InputClass.askStringInput("Please enter the name of the " + itemType + ":");
        if (itemType.equals("album")) {
            artist = InputClass.askStringInput("Please enter the name of the artist/producer: ");
        } else {
            genre = InputClass.askStringInput("Please enter the genre of the " + itemType + ": ");
        }
        year = InputClass.askIntInput("Please enter the year of the " + itemType + ":");
        dailyRentFee = InputClass.askDoubleInput("Please enter the daily rent fee: ");
        while(dailyRentFee < 0 ){
            dailyRentFee = InputClass.askDoubleInput("Please enter a valid daily rent fee: ");
        }
        Item newItem = new Item(title, artist, genre, year, dailyRentFee);
        itemList.add(newItem);
        if (itemType.equals("game")){
            toString = newItem.toStringGame();
        } else{
            toString = newItem.toStringAlbum();
        }
        System.out.println("The " + itemType + " with " + toString + " has been created successfully.");
    }


    public boolean removeItem(String itemType) {
        gameOrAlbum(itemType);
        String idToRemove = InputClass.askStringInput("Please enter the ID of the " + itemType + " you want to remove: ");
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(idToRemove)) {
                System.out.println("The " + itemType + " with " + itemList.get(i).toString() + " has been removed!");
                itemList.remove(i);
                return true;
            }
        }
        System.out.println("The "+ itemType + " with id:" + idToRemove + " not found");
        return false;
    }


    public boolean rentItem(String itemType){
        gameOrAlbum(itemType);
        if(itemList.size() > 0){
            String ItemToRent = InputClass.askStringInput("Enter item id of the " + itemType + " you want to rent: ");
            for(int i = 0; i < itemList.size(); i++){
                if(itemList.get(i).getID().equals(ItemToRent) && !itemList.get(i).isItemAvailableToRent()){
                    System.out.println("The " + itemType + " with id: " + ItemToRent + " is already rented.");
                    return false;
                } else if(itemList.get(i).getID().equals(ItemToRent)){
                    System.out.println("The " + itemType + " with id: " + ItemToRent + " has been rented!");
                    itemList.get(i).setNotAvailableToRent();
                    return true;
                }
            }
            System.out.println("The " + itemType + " with id: " + ItemToRent + " not found.");
        }
        return false;
    }


    public boolean returnItem(String itemType) {
        gameOrAlbum(itemType);
        String itemToReturn = InputClass.askStringInput("Please enter the ID of the " + itemType + " you want to return: ");
        double totalRent;
        for (int i = 0; i < itemList.size(); i++) {
            if (!itemList.get(i).isItemAvailableToRent()) {
                if (itemList.get(i).getID().equals(itemToReturn)) {
                    int daysRented = InputClass.askIntInput("Please enter the number of days you rented the " + itemType + ": ");
                    while (daysRented < 0) {
                        daysRented = InputClass.askIntInput("Please enter a valid number of days: ");
                    }
                    totalRent = itemList.get(i).getDailyRentFee() * daysRented;
                    System.out.println("The total fee is: " + totalRent + " SEK.");
                    itemList.get(i).setAvailableToRent();
                    DartController.totalRentProfit += totalRent;
                    System.out.println("The " + itemType + " has been successfully returned. ");
                    return true;
                }
            }
        }
        System.out.println("Item with ID: " + itemToReturn + " was not found or is not rented. ");
        return false;
    }


    public String getID() {
        return this.ID;
    }

    public String getArtist() {
        return this.artist;
    }

    public double getDailyRentFee() {
        return this.dailyRentFee;
    }

    public void setAvailableToRent(){
        this.rentStatus = "Available";
    }

    public void setNotAvailableToRent(){
        this.rentStatus = "Not available";
    }

    public boolean isItemAvailableToRent(){
        return this.rentStatus.equals("Available");
    }

    public ArrayList<Item> getItems(){
        return itemList;
    }

    public int getYear() {
        return this.year;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getRentStatus() {
        return this.rentStatus;
    }

    public void listAllItems(){
        if(itemList.size() < 1){
            System.out.println("There are no items registered in the system!");
        } else {
            System.out.println("List of all items: ");
            for(int i=0; i<itemList.size(); i++){
                System.out.println(itemList.get(i).toString());
            }
        }
    }

//-------------------------------------------------------------------------------------------------TO BE MOVED

    public void gameOrAlbum(String itemType){
        if (itemType.equals("game")){
            listAllGames();
        }else {
            listAllAlbums();
        }
    }


    public void listAllGames(){
        if(getItems().size() < 1){
            System.out.println("There are no games registered in the system!");
        } else {
            System.out.println("List of all games: ");
            for (int i = 0; i < getItems().size(); i++) {
                if ((getItems().get(i).getArtist() == null)) {
                    System.out.println(getItems().get(i).toStringGame());
                }
            }
        }
    }


    public void listAllAlbums(){
        if(getItems().size() < 1){
            System.out.println("There are no albums registered in the system!");
        } else {
            System.out.println("List of all albums: ");
            for (int i = 0; i < getItems().size(); i++) {
                if (!(getItems().get(i).getArtist() == null)) {
                    System.out.println(getItems().get(i).toStringAlbum());
                }
            }
        }
    }


    public String toStringGame() {
        return
                "ID: '" + ID + '\'' +
                ", title: '" + title + '\'' +
                ", genre: '" + genre + '\'' +
                ", released in: " + year +
                ", daily rent fee: " + dailyRentFee +
                ", rent status: " + rentStatus + ".";
    }

    public String toStringAlbum() {
        return
                "ID: " + ID + " : '" + title + '\'' +
                " - by '" + artist + "'." +
                " Released in " + year +
                ". Price: " + dailyRentFee +
                " SEK. Rent status: " + rentStatus + ".";
    }

//------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Item{" +
                "ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", dailyRentFee=" + dailyRentFee +
                ", rentStatus='" + rentStatus + '\'' +
                '}';
    }

}
