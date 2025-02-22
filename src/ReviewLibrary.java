import java.util.ArrayList;

class ReviewLibrary {
    private ArrayList<Review> reviewList = new ArrayList<>();
    private void addReview(Review newReview){
        reviewList.add(newReview);
    }

    public Review submitReview(String itemID, Customer customer, String review){
        Review newReview = new Review(itemID,customer,review);
        addReview(newReview);
        return newReview;
    }

    private ArrayList<Review> findAllReviewsOfItem(String itemID){
        ArrayList<Review> reviewsOfCurrentItem = new ArrayList<>();
        for (Review review : reviewList) {
            if (review.getItemID().equals(itemID)) {
                reviewsOfCurrentItem.add(review);
            }
        }
        return reviewsOfCurrentItem;
    }

    public String showItemReviews(String itemID){
        ArrayList<Review> reviewsOfCurrentItem = findAllReviewsOfItem(itemID);
        if(reviewsOfCurrentItem.size() == 0){
            return "This item does not have any reviews! ";
        } else {
            StringBuilder builder = new StringBuilder();
            for(int i=0; i < reviewsOfCurrentItem.size(); i++){
                builder.append("Review "+ (i+1) + " ");
                builder.append("\n");
                builder.append(reviewsOfCurrentItem.get(i).toString());
            }
            return builder.toString();
        }
    }

}
