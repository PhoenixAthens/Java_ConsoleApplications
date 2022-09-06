package SongsApp;

public class Main {
    private static MusicsApp musicApp=new MusicsApp();
    public static void main(String...args){
        Album album1=new Album("Little Men","John wayne");
        album1.addSongs("Song1",4.32);
        album1.addSongs("Song2",5.23);
        album1.addSongs("Song3",2.5);
        album1.addSongs("Song4",4.5);
        Album album2=new Album("Dance to Hell","frank long");
        album2.addSongs("SongA",3.45);
        album2.addSongs("SongB",1.33);
        album2.addSongs("SongC",5.00);
        album2.addSongs("SongD",3.67);
        musicApp.addAlbumToMemory(album1);
        musicApp.addAlbumToMemory(album2);
        Playlist playlist=new Playlist("Loving souls");
        musicApp.SearchForAlbum("Little Men").AddSongsToPlaylist(1,playlist.getPlaylist());
        musicApp.SearchForAlbum("Little Men").AddSongsToPlaylist(2,playlist.getPlaylist());
        musicApp.SearchForAlbum("Dance to Hell").AddSongsToPlaylist(3,playlist.getPlaylist());
        musicApp.playSongs(playlist.getPlaylist());

        //First point use arrayList to get a playlist for adding songs to playlist
        //Add methods in playlist.
        //In albums collection add a search method
        //In Playlist add more methods and those method for playing song reverse, forward and rewind, try them
        //out in playlist.


    }
}
