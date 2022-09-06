package SongsApp;
import java.util.*;
public class Playlist {
    private LinkedList<Songs> playlist;
    private String playlistName;
    private int numberOfSongs=0;
    public Playlist(String nameOfPlaylist){
        this.playlist=new LinkedList<>();
        this.playlistName=nameOfPlaylist;
    }
    public LinkedList<Songs> getPlaylist(){
        return playlist;
    }
    public void setPlaylistName(String newName){
        this.playlistName=newName;
    }
    public String getPlaylistName(){
        return playlistName;
    }
    public void PrintPlaylist(){
        for(Songs s:playlist){
            System.out.println(s);
        }
    }
}
