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
        Map<String, Double> itemProfits = new HashMap<String, Double>();
        if(rentHistoryList.size() == 0){
            return "No items have ever been rented so there is no most profitable item.";
        } else{
            double currentMax = 0;
            String currentID = "";
            for(int i = 0; i < rentHistoryList.size(); i++){
                itemProfits.put(rentHistoryList.get(i).getItemID(), rentHistoryList.get(i).getRentExpense());
            }
            for(String id: itemProfits.keySet()){
               System.out.println("Total profit for id: " + id + " " + getSameItemIDProfit(id) + " SEK");
               if(getSameItemIDProfit(id) > currentMax){
                currentMax = getSameItemIDProfit(id);
                currentID = id;
               }
            }
            return currentID;
        }
    }

    public String getBestCustomer() {
        Map<String, Double> customerProfits = new HashMap<String, Double>();
        if(rentHistoryList.size() == 0){
            return "No items have ever been rented so there is no best customer.";
        } else{
            double currentMax = 0;
            String currentID = "";
            for(int i = 0; i < rentHistoryList.size(); i++){
                customerProfits.put(rentHistoryList.get(i).getCustomerID(), rentHistoryList.get(i).getRentExpense());
            }
            for(String id: customerProfits.keySet()){
                System.out.println("Total profit for customer id: " + id + " " + getSameCustomerIDProfit(id) + " SEK");
                if(getSameCustomerIDProfit(id) > currentMax){
                    currentMax = getSameCustomerIDProfit(id);
                    currentID = id;
                }
            }
            return currentID;
        }
    }



    public double getSameItemIDProfit(String itemID){
        double totalProfit = 0;
        for(int i= 0; i < rentHistoryList.size();i++ ){
            if(rentHistoryList.get(i).getItemID().equals(itemID)){
                totalProfit = totalProfit + rentHistoryList.get(i).getRentExpense();
            }
        }
        return totalProfit;
    }

    public double getSameCustomerIDProfit(String customerID){
        double totalProfit = 0;
        for(int i= 0; i < rentHistoryList.size();i++ ){
            if(rentHistoryList.get(i).getCustomerID().equals(customerID)){
                totalProfit = totalProfit + rentHistoryList.get(i).getRentExpense();
            }
        }
        return totalProfit;
    }

}
