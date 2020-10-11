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


    public boolean areThereAnyItems(){
        return itemList.size() != 0;
    }


    public boolean rentItem(String idToRent, Customer customer){
        if(itemList.size() > 0){
            for(int i = 0; i < itemList.size(); i++){
                if(itemList.get(i).getID().equals(idToRent) && !itemList.get(i).isItemAvailableToRent()){
                    return false;
                } else if(itemList.get(i).getID().equals(idToRent)){
                    itemList.get(i).setNotAvailableToRent();
                    customer.addToCurrentRentedItemsByCustomer(itemList.get(i));
                    return true;
                }
            }
        }
        return false;
    }

    public double returnItem(String itemToReturn, int daysRented, Customer customer) {
        double rentExpense=0;
        for (int i = 0; i < itemList.size(); i++) {
            if (!itemList.get(i).isItemAvailableToRent()) {
                if (itemList.get(i).getID().equals(itemToReturn)) {
                    if(customer.checkIfTheItemRentedByCustomer(itemToReturn)){
                        if(customer.getStoreCredits() > 4){
                            customer.decrementStoreCredits();
                        }
                        else{
                            customer.addCredits();
                            rentExpense = itemList.get(i).getDailyRentFee() * daysRented * (1-customer.getDiscount());
                        }
                        itemList.get(i).setAvailableToRent();
                        customer.subFromCurrentRentedItemsByCustomer(itemList.get(i));
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

    public ArrayList<Item> sortedItems(ArrayList <Item> item){
        ArrayList<Item> temp = new ArrayList<>();
        temp = (ArrayList) item.clone();
        temp.sort(Collections.reverseOrder(new Comparator<Item>() {

            @Override
            public int compare(Item i1, Item i2) {
                if (i1.getAverageRating() > i2.getAverageRating())
                    return 1;
                if (i1.getAverageRating() < i2.getAverageRating())
                    return -1;
                return 0;
            }
        }));
        return temp;
    }

}
