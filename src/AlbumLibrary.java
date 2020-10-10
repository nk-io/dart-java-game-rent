import java.util.ArrayList;

public class AlbumLibrary extends ItemLibrary {

    public Album registerAlbum(String title, String artist, int year, double dailyRentFee) {
        Album newAlbum = new Album(title, dailyRentFee, artist, year);
        addItemToList(newAlbum);
        return newAlbum;

    }

    public String searchByYear(int year) {
        ArrayList<Item> subList = new ArrayList<>();
        for (int i = 0; i < getItems().size(); i++) {
            Album currentAlbum = (Album) getItems().get(i);
            if (year == currentAlbum.getYear()) {
                subList.add(currentAlbum);
            }
        }
        if (subList.size() == 0) {
            return "There are no registered albums released in the given year.";
        } else {
            subList = sortedItems(subList);
            StringBuilder builder = new StringBuilder();
            builder.append("Albums are sorted by average ratings\n");
            for(int i=0; i<subList.size(); i++){
                builder.append(subList.get(i).toString());

            }
            return builder.toString();
        }
    }

}
