package SongsApp;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String AlbumName;
    private String artistName;
    private ArrayList<Songs> songs;
    public Album(String AlbumName,String ArtistName){
        this.AlbumName=AlbumName;
        this.artistName=ArtistName;
        this.songs=new ArrayList<>();
    }
    private Songs findSong(String title,double duration){
        Songs song=new Songs(title,duration);
        for(Songs music:songs){
            if(music.equals(song)){
                return music;
            }
        }
        return null;

    }
    public ArrayList<Songs> getArrayListOfSongs(){
        return songs;
    }
    public void  PrintAlbum(){
        if(!songs.isEmpty()){
            System.out.println("\n================================");
            for(Songs s:songs){
                System.out.println(s);
            }
            System.out.println("================================\n");
        }else{
            System.out.println("\n================================");
            System.out.println("      !!The album is empty!!      ");
            System.out.println("================================\n");
        }
    }
    public String getAlbumName(){
        return AlbumName;

    }
    public Songs findSongs(String title){
        for(Songs s:songs) {
            if ((s.getTitle()).equals(title)) return s;
        }
        return null;

    }
    public boolean addSongs(String title,double duration){
        if(findSong(title,duration)==null){
            boolean result=songs.add(new Songs(title,duration));
            if(result){
                return true;
            }
        }
        return false;
    }
    public boolean AddSongsToPlaylist(int trackNumber,LinkedList<Songs> playlist){
        try{
            int find=trackNumber-1;

            boolean result=playlist.add(songs.get(find));
            if(result) return true;
        }catch(Exception ex){
            System.out.println("\nException: "+ex.getClass().getSimpleName()+", occured!, Check the track Number!\n");
            return false;
        }
        return false;
    }
    public  boolean AddSongsToPlaylist(String title,LinkedList<Songs> playlist){
        try{
            Songs s=findSongs(title);
            if(s!=null){
                playlist.add(s);
                return true;
            }
        }catch(Exception ex){
            System.out.println("Exception: "+ex.getClass().getSimpleName());
            return false;
        }
        return false;
    }
    public String toString(){
        return "[Album Name: "+AlbumName+", Artist Name: "+artistName+"]";
    }
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj instanceof Album){
            Album album=(Album) obj;
            return AlbumName.equals(album.AlbumName) && artistName.equals(album.artistName);
        }
        return super.equals(obj);
    }
}
