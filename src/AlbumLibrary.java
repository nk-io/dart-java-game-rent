public class AlbumLibrary extends ItemLibrary {

    public Album registerAlbum(String title, String artist, int year, double dailyRentFee){
        Album newAlbum = new Album(title, dailyRentFee, artist, year );
        addItemToList(newAlbum);
        return newAlbum;

    }

    public String searchByYear(int year) {
        int counter = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getItems().size(); i++) {
            Album currentAlbum = (Album) getItems().get(i);
            if (year == currentAlbum.getYear()) {
                builder.append(currentAlbum.toString());
                builder.append("\n");
                counter++;
            }
        }
        if(counter == 0){
            return "There are no registered albums released in the given year.";
        } else { return builder.toString(); }
    }

}
