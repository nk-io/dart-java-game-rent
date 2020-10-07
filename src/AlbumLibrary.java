public class AlbumLibrary extends ItemLibrary {

    public Album registerAlbum(String title, String artist, int year, double dailyRentFee){
        Album newAlbum = new Album(title, dailyRentFee, artist, year );
        addItemToList(newAlbum);
        return newAlbum;

    }

}
