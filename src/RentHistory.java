public class RentHistory {
    private String ID;
    private Customer customer;
    private Item item;
    private int daysRented;
    private double rentExpense;


    RentHistory(Customer customer, Item item, int daysRented, double rentExpense){
        this.ID = RandomUID.generateRandomID();
        this.customer = customer;
        this.item = item;
        this.daysRented = daysRented;
        this.rentExpense = rentExpense;
    }

    public String getItemID(){
        return this.item.getID();
    }

    public String getCustomerID(){
        return this.customer.getID();
    }

    public double getRentExpense(){
        return this.rentExpense;
    }


    @Override
    public String toString() {
        return
                "'customer ID='" + customer.getID() + '\'' +
                        ", 'item ID='" + item.getID() + '\'' +
                        ", days rented=" + daysRented +
                        ", rent expense=" + rentExpense + "SEK" + "\n";
    }

}
