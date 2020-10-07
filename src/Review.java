public class Review {
    String ID;
    String itemID;
    Customer customer;
    String review;

    public Review(String itemID, Customer customer, String review){
        this.ID = RandomUID.generateRandomID();
        this.itemID = itemID;
        this.customer = customer;
        this.review = review;
    }

    public String getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "Customer:" + customer.getName() + '\n' +
                "Review:" + review + '\n';
    }
}
