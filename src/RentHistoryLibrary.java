import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class RentHistoryLibrary {
    public ArrayList<RentHistory> rentHistoryList = new ArrayList<>();

    public void addRentHistory(RentHistory newRentHistory) {
        rentHistoryList.add(newRentHistory);
    }

    public String showAllRentHistory() {

        if (rentHistoryList.size() == 0) {
            return "There are no transactions available.";
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < rentHistoryList.size(); i++) {
                builder.append("Transaction "+ (i+1) + ": ");
                builder.append("\n");
                builder.append(rentHistoryList.get(i).toString());

            }
            return builder.toString();
        }
    }

    public String exportRentHistory() {
        if (rentHistoryList.size() == 0) {
            return "There are no transactions available.";
        } else {
            StringBuilder builder = new StringBuilder();
            for (RentHistory rentHistory : rentHistoryList) {
                String custID = rentHistory.getCustomerID();
                String itemID = rentHistory.getItemID();
                String itemTitle = rentHistory.getItemTitle();
                double rentPaid = rentHistory.getRentExpense();
                builder.append(custID + ";" + itemID + ";" + itemTitle + ";" + rentPaid + ";");
                builder.append("\n");
            }
            return builder.toString();
        }
    }

    // had to change epic feature 6.3 to now calculate here so code isn't repeated
    public double calculateTotalProfit(){
        double totalRentProfit = 0.0;
        for(int i = 0; i < rentHistoryList.size(); i++){
            totalRentProfit = totalRentProfit + rentHistoryList.get(i).getRentExpense();
        }
        return totalRentProfit;
    }

    public String showRentFrequency(){
        if(rentHistoryList.size() == 0){
            return "No items have ever been rented.";
        } else{
            ArrayList<String> IDS = new ArrayList<String>();
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < rentHistoryList.size();i++){
                IDS.add(rentHistoryList.get(i).getItemID());
            }
            Set<String> IDSet = new HashSet<String>(IDS);
            for (String id : IDSet) {
                builder.append( "Item ID: " + id + ": " + "has been rented " + Collections.frequency(IDS, id) + " times.");
                builder.append("\n");
            }
            return builder.toString();
        }
    }

    public String getMostProfitableItem() {
        if(rentHistoryList.size() == 0){
            return null;
        } else{
            double currentMaxProfit = 0;
            String currentMaxID = "";
            for(int i = 0; i < rentHistoryList.size(); i++){
                String id = rentHistoryList.get(i).getItemID();
                if(getSameItemIDProfit(id) > currentMaxProfit){
                    currentMaxProfit = getSameItemIDProfit(id);
                    currentMaxID = id;
                }
            }
            return currentMaxID;
        }
    }

    public String getBestCustomer() {
        if(rentHistoryList.size() == 0){
            return null;
        } else{
            double currentMaxProfit = 0;
            String currentMaxID = "";
            for (RentHistory rentHistory : rentHistoryList) {
                String id = rentHistory.getCustomerID();
                if (getSameCustomerIDProfit(rentHistory.getCustomerID()) > currentMaxProfit) {
                    currentMaxProfit = getSameCustomerIDProfit(id);
                    currentMaxID = id;
                }
            }
            return currentMaxID;
        }
    }

    public double getSameItemIDProfit(String itemID){
        double totalProfit = 0;
        for (RentHistory rentHistory : rentHistoryList) {
            if (rentHistory.getItemID().equals(itemID)) {
                totalProfit = totalProfit + rentHistory.getRentExpense();
            }
        }
        return totalProfit;
    }

    public double getSameCustomerIDProfit(String customerID){
        double totalProfit = 0;
        for (RentHistory rentHistory : rentHistoryList) {
            if (rentHistory.getCustomerID().equals(customerID)) {
                totalProfit = totalProfit + rentHistory.getRentExpense();
            }
        }
        return totalProfit;
    }

}
