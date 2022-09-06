package SongsApp;

import java.util.*;

public class MusicsApp {
    private Scanner scn=new Scanner(System.in);
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
    public void playSongs(List<Songs> playlist){
        ListIterator<Songs> it=playlist.listIterator();
        boolean flag=true;
        boolean forward=false;
        while(flag){
            System.out.print("Enter you choice: ");
            if(scn.hasNextInt()){
                int input=scn.nextInt();
                scn.nextLine();
                switch(input){
                    case 0-> PrintOptions();
                    case 1-> PrintPlaylist(playlist);
                    case 2->{
                        if(it.hasNext()){
                            System.out.println("Now play: "+it.next());
                            forward=true;
                        }else{
                            System.out.println("The playlist is empty!");
                        }
                    }
                    case 3->{
                        if(!forward){
                            if(it.hasNext()){
                                it.next();
                            }
                            forward=true;
                        }
                        if(it.hasNext()){
                            System.out.println("Now Playing: "+it.next());
                        }
                        else{
                            System.out.println("We are at the end of the playlist!");
                            forward=false;
                        }
                    }
                    case 4->{
                        if(forward){
                            if(it.hasPrevious()){
                                it.previous();
                            }
                            forward=false;
                        }
                        if(it.hasPrevious()){
                            System.out.println("Now Playing: "+it.previous());
                        }else{
                            System.out.println("We are at the beginning of the playlist!");
                            forward=true;
                        }
                    }
                    case 5->{
                        flag=false;
                    }
                }

            }else{
                System.out.println("Invalid Choice, Try again!");
                scn.nextLine();
            }

        }
    }

    private void PrintPlaylist(List<Songs> playlist){
        for(Songs s:playlist){
            System.out.println(s);
        }
    }

    private void PrintOptions(){
        var buff = "(0)->Print Options" +
                "(1)->Print All Songs from Playlist!" +
                "(2)->PLay songs!" +
                "(3)->Play next song >>" +
                "(4)->Play previous song <<" +
                "(5)->Quit";
        System.out.println(buff);

    }


}
