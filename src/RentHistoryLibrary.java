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
        ArrayList<String> IDS = new ArrayList<String>();
        if(rentHistoryList.size() == 0){
            return "No items have ever been rented.";
        } else{
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
        HashMap<String, Double> itemProfits = new HashMap<String, Double>();

        for(int i = 0; i < rentHistoryList.size();i++){
                if (!itemProfits.containsKey(rentHistoryList.get(i).getItemID())) {
                    itemProfits.put(rentHistoryList.get(i).getItemID(), rentHistoryList.get(i).getRentExpense());
                } else {
                    double newTotalExpense = itemProfits.get(rentHistoryList.get(i).getItemID()) + rentHistoryList.get(i).getRentExpense();
                    itemProfits.put(rentHistoryList.get(i).getItemID(), newTotalExpense);
                }
            }

        String idToReturn = "";
        double currentMax = 0;
        Set entrySet = itemProfits.entrySet();

        Iterator it = entrySet.iterator();
        while(it.hasNext()){
                Map.Entry me = (Map.Entry)it.next();
                if(me.getValue().equals(currentMax)){
                    currentMax = (double)me.getValue();
                    idToReturn = (String)me.getKey();
                }
            }

        return idToReturn;

    }
}
