import java.util.ArrayList;

abstract class ItemLibrary {

    private ArrayList<Item> itemList = new ArrayList<>();

    public ArrayList<Item> getItems(){
        return itemList;
    }

    public void addItemToList(Item newItem){
        itemList.add(newItem);
    }

    public Item doesItemExist(String idToSearch){
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(idToSearch)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public boolean isItAvailable(String idToSearch){
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(idToSearch)) {
                if (itemList.get(i).isItemAvailableToRent()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeItem(String idToRemove) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(idToRemove)) {
                itemList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean rentItem(String idToRent){
        if(itemList.size() > 0){
            for(int i = 0; i < itemList.size(); i++){
                if(itemList.get(i).getID().equals(idToRent) && !itemList.get(i).isItemAvailableToRent()){
                    return false;
                } else if(itemList.get(i).getID().equals(idToRent)){
                    itemList.get(i).setNotAvailableToRent();
                    return true;
                }
            }
        }
        return false;
    }

    // need to change this according to membership

    public boolean returnItem(String itemToReturn, int daysRented) {
        double totalRent;
        for (int i = 0; i < itemList.size(); i++) {
            if (!itemList.get(i).isItemAvailableToRent()) {
                if (itemList.get(i).getID().equals(itemToReturn)) {
                    itemList.get(i).setAvailableToRent();
                    // get rent somewhere else
                   // DartController.totalRentProfit += totalRent;
                    return true;
                }
            }
        }
        return false;
    }

    public String listAll(){
        if(itemList.size() < 1){
            return null;
        } else {
            StringBuilder listOfAll = new StringBuilder();
            for(int i=0; i<itemList.size(); i++){
                listOfAll.append(itemList.get(i).toString() + "\n");
            }
            return listOfAll.toString();
        }
    }

}
