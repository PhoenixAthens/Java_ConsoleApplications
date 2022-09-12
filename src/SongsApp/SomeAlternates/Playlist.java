package SongsApp.SomeAlternates;

import java.util.LinkedList;
public class Playlist {
    private LinkedList<Songs> playlist;
    private String playlistName;
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
    public String toString(){
        return "[Playlist Name: "+playlistName+", Number of Songs: "+playlist.size()+"]";
    }
}
