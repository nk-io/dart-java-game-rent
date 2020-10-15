import java.util.*;

public class RentHistoryLibrary {
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
            String custID;
            String itemID;
            String itemTitle;
            double rentPaid;
            for (int i = 0; i < rentHistoryList.size(); i++) {
                custID = rentHistoryList.get(i).getCustomerID();
                itemID = rentHistoryList.get(i).getItemID();
                itemTitle = rentHistoryList.get(i).getItemTitle();
                rentPaid = rentHistoryList.get(i).getRentExpense();
                builder.append("customer id: " + custID + "; item id: " + itemID + "; item title: "  + itemTitle  + "; rent paid: " + rentPaid + ";");
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

    public int checkFrequencyOfItemID(String ItemID){
        int frequency = 0;
        ArrayList<String> IDS = new ArrayList<String>();
        for(int i = 0; i < rentHistoryList.size();i++){
            IDS.add(rentHistoryList.get(i).getItemID());
        }
        Set<String> IDSet = new HashSet<String>(IDS);
        for (String id : IDSet) {
            if(ItemID.equals(id)){
                frequency = Collections.frequency(IDS, id);
            }
        }
        return frequency;
    }


    public String getMostProfitableItem() {
        if(rentHistoryList.size() == 0){
            return null;
        } else{
            double currentMaxProfit = 0;
            String currentMaxID = "";
            String id = "";
            for(int i = 0; i < rentHistoryList.size(); i++){
                id = rentHistoryList.get(i).getItemID();
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
            String id = "";
            for(int i = 0; i < rentHistoryList.size(); i++){
                id = rentHistoryList.get(i).getCustomerID();
                if(getSameCustomerIDProfit(rentHistoryList.get(i).getCustomerID()) > currentMaxProfit){
                    currentMaxProfit = getSameCustomerIDProfit(id);
                    currentMaxID = id;
                }
            }
            return currentMaxID;
        }
    }



    public double getSameItemIDProfit(String itemID){
        double totalProfit = 0;
        String currentItemID = "";
        for(int i= 0; i < rentHistoryList.size();i++){
            currentItemID = rentHistoryList.get(i).getItemID();
            if(currentItemID.equals(itemID)){
                totalProfit = totalProfit + rentHistoryList.get(i).getRentExpense();
            }
        }
        return totalProfit;
    }

    public double getSameCustomerIDProfit(String customerID){
        double totalProfit = 0;
        String currentCustomerID = "";
        for(int i= 0; i < rentHistoryList.size();i++ ){
            currentCustomerID = rentHistoryList.get(i).getCustomerID();
            if(currentCustomerID.equals(customerID)){
                totalProfit = totalProfit + rentHistoryList.get(i).getRentExpense();
            }
        }
        return totalProfit;
    }

}
