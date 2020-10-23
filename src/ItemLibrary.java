import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract class ItemLibrary {

    private ArrayList<Item> itemList = new ArrayList<>();

    public ArrayList<Item> getItems(){
        return itemList;
    }

    public void addItemToList(Item newItem){
        itemList.add(newItem);
    }

    public Item doesItemExist(String idToSearch){
        for (Item item : itemList) {
            if (item.getID().equals(idToSearch)) {
                return item;
            }
        }
        return null;
    }

    public boolean isItAvailable(String idToSearch){
        for (Item item : itemList) {
            if (item.getID().equals(idToSearch)) {
                if (item.isItemAvailableToRent()) {
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


    public boolean rentItem(String idToRent, Customer customer){
        if(itemList.size() > 0){
            for (Item item : itemList) {
                if (item.getID().equals(idToRent) && !item.isItemAvailableToRent()) {
                    return false;
                } else if (item.getID().equals(idToRent)) {
                    item.setNotAvailableToRent();
                    customer.addToCurrentRentedItemsByCustomer(item);
                    return true;
                }
            }
        }
        return false;
    }

    public double returnItem(String itemToReturn, int daysRented, Customer customer) throws Exception {
        if (daysRented < 1){
            throw new Exception("Invalid operation. Upon returning an item, the number of days rented must be positive.");
        }
        double rentExpense=0;
        for (Item item : itemList) {
            if (!item.isItemAvailableToRent()) {
                if (item.getID().equals(itemToReturn)) {
                    if (customer.checkIfTheItemRentedByCustomer(itemToReturn)) {
                        if (customer.getStoreCredits() > 4) {
                            customer.decrementStoreCredits();
                        } else {
                            customer.incrementStoreCredits();
                            rentExpense = item.getDailyRentFee() * daysRented * (1 - customer.getDiscount());
                        }
                        item.setAvailableToRent();
                        customer.subFromCurrentRentedItemsByCustomer(item);
                        return rentExpense;
                    }
                }
            }
        }
        return -1;
    }

    public String listAll(){
        if(itemList.size() < 1){
            return null;
        } else {
            StringBuilder listOfAll = new StringBuilder();
            for(int i=0; i<itemList.size(); i++){
                listOfAll.append(itemList.get(i).toString());
            }
            return listOfAll.toString();
        }
    }

    public String sortByRating(ArrayList <Item> item){
        ArrayList<Item> tempList;
        tempList = (ArrayList) item.clone();
        tempList.sort(Collections.reverseOrder(new Comparator<Item>() {

            @Override
            public int compare(Item i1, Item i2) {
                if (i1.getAverageRating() > i2.getAverageRating())
                    return 1;
                if (i1.getAverageRating() < i2.getAverageRating())
                    return -1;
                return 0;
            }
        }));

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < tempList.size(); i++){
            builder.append(tempList.get(i).toString());
        }
        return builder.toString();
    }

}