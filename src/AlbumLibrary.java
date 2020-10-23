import java.util.ArrayList;
import java.util.Comparator;

class AlbumLibrary extends ItemLibrary {

    public Album registerAlbum(String title, String artist, int year, double dailyRentFee) {
        Album newAlbum = new Album(title, dailyRentFee, artist, year);
        addItemToList(newAlbum);
        return newAlbum;

    }

    public String sortByYear(ArrayList<Item> item) {
        ArrayList<Album> tempList;
        tempList = (ArrayList) item.clone();
        tempList.sort(Comparator.comparing(Album::getYear).reversed());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tempList.size(); i++) {
            builder.append(tempList.get(i).toString());
        }
        return builder.toString();
    }

    public String searchByYear(int year) {
        ArrayList<Item> subList = new ArrayList<>();
        String subListByRating;
        for (int i = 0; i < getItems().size(); i++) {
            Album currentAlbum = (Album) getItems().get(i);
            if (year == currentAlbum.getYear()) {
                subList.add(currentAlbum);
            }
        }
        if (subList.size() == 0) {
            return "There are no registered albums released in the given year.";
        } else {
            subListByRating = sortByRating(subList);
            return subListByRating;
        }
    }

}
