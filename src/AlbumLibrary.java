public class AlbumLibrary extends ItemLibrary {

    public Album registerAlbum(String title, double dailyRentFee, String artist, int year){
        Album newAlbum = new Album(title, dailyRentFee, artist, year );
        addItemToList(newAlbum);
        return newAlbum;

    }

}
