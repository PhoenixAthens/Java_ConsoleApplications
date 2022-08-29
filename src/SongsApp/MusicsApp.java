package SongsApp;

import java.util.ArrayList;
import java.util.Iterator;

public class MusicsApp {
    private final ArrayList<Album> albumsCollection;
    public MusicsApp(){
        this.albumsCollection=new ArrayList<>();
    }
    //In Playlist add method to add entire album to the playlist;
    public boolean addAlbumToMemory(Album album){
        if(album.getArrayListOfSongs().isEmpty()) return false;
        else{
            var result=albumsCollection.add(album);
            return result;
        }
    }
    public boolean RemoveAlbumFromMemory(String AlbumName){
        Iterator<Album> it=albumsCollection.iterator();
        while(it.hasNext()){
            Album al=it.next();
            if(al.getAlbumName().equals(AlbumName)){
                it.remove();
                return true;
            }
        }
        return false;
    }
    public Album SearchForAlbum(String nameOfAlbum){
        for(Album album:albumsCollection){
            if(album.getAlbumName().equals(nameOfAlbum)){
                return album;
            }
        }return null;
    }




}
