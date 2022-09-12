package SongsApp.SomeAlternates;

import java.util.*;

public class MusicsApp {
    private Scanner scn=new Scanner(System.in);
    private final ArrayList<Album> albumsCollection;
    private final ArrayList<Playlist> listOFPlaylists;
    public MusicsApp(){
        this.albumsCollection=new ArrayList<>();
        this.listOFPlaylists=new ArrayList<>();
    }
    public boolean addAlbumToMemory(Album album){
        //if(album.getArrayListOfSongs().isEmpty()) return false;
        //else{
            var result=albumsCollection.add(album);
            return result;
        //}
    }
    public List<Album> returnAlbumCollection(){
        return albumsCollection;
    }
    public void PrintAvailableAlbums(){
        if(albumsCollection.isEmpty()){
            System.out.println("\n+++++++++++++++++++++++++++");
            System.out.println("No Albums available!!");
            System.out.println("+++++++++++++++++++++++++++\n");
        }else{
            System.out.println("\n+++++++++++++++++++++++++++");
            for(Album a:albumsCollection){
                System.out.println(a);
            }
            System.out.println("+++++++++++++++++++++++++++\n");
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
    public boolean CreatePlaylist(Playlist playlist){
        if(listOFPlaylists.add(playlist)){
            return true;
        }else{
            return false;
        }
    }
    public void PrintAvailablePlaylists(){
        if(listOFPlaylists.isEmpty()){
            System.out.println("\n+++++++++++++++++++++++++++");
            System.out.println("No playlist available!!");
            System.out.println("+++++++++++++++++++++++++++\n");
        }
        else {
            System.out.println("\n+++++++++++++++++++++++++++");
            for(Playlist playlist:listOFPlaylists){
                System.out.println(playlist);
            }
            System.out.println("+++++++++++++++++++++++++++\n");
        }
    }
    public int removePlaylist(String name){
        Playlist retrieved=searchForPlaylist(name);
        if(retrieved!=null){
            int index=listOFPlaylists.indexOf(retrieved);
            var result=listOFPlaylists.remove(retrieved);
            return index;
        }else{
            return -1;
        }
    }
    public void overWriteExistingAlbum(Playlist existing, Playlist newlyCreated){
        int target=removePlaylist(existing.getPlaylistName());

        listOFPlaylists.set(target,newlyCreated);
    }
    public Playlist searchForPlaylist(String name){
        for(Playlist play:listOFPlaylists){
            if(play.getPlaylistName().equals(name)){
                return play;
            }
        }
        return null;
    }
    public Album SearchForAlbum(String nameOfAlbum){
        for(Album album:albumsCollection){
            if(album.getAlbumName().equals(nameOfAlbum)){
                return album;
            }
        }return null;
    }
    public Album lookUpForSongThroughAllAlbums(String nameOfSong){
        if(albumsCollection.isEmpty()){
            return null;
        }else{
            for(Album album:albumsCollection){
                List<Songs> songList=album.getSongs().getArrayListOfSongs();
                if(!songList.isEmpty()){
                    Songs s=album.getSongs().findSongs(nameOfSong);
                    if(s!=null)return album;
                }
            }
        }
        return null;
    }
    public void playSongs(List<Songs> playlist){
        PrintOptions();
        ListIterator<Songs> it=playlist.listIterator();
        boolean flag=true;
        boolean forward=false;
        if(playlist.isEmpty()){
            System.out.println("The playlist is empty!");
        }else{
            while(flag){
                System.out.print("Enter you choice: ");
                if(scn.hasNextInt()){
                    int input=scn.nextInt();
                    scn.nextLine();
                    switch(input){
                        case 0-> PrintOptions();
                        case 1-> PrintSongsInPlaylist(playlist);
                        case 2->{
                            if(it.hasNext()){
                                System.out.println("Now playing: "+it.next());
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
                            if(playlist.size()>0){
                                it.remove();
                            }
                            if(it.hasNext()){
                                System.out.println("Now playing: "+it.next());
                                forward=true;
                            }else if(it.hasPrevious()){
                                System.out.println("Now playing: "+it.previous());
                                forward=false;
                            }
                            if(playlist.isEmpty()){
                                System.out.println("\n==========================================");
                                System.out.println("        !! The playlist is empty !!         ");
                                System.out.println("==========================================\n");
                            }
                        }
                        case 6->{
                            System.out.println("\n==========================================");
                            System.out.println("             !!Exiting Player!!             ");
                            System.out.println("==========================================\n");
                            flag=false;
                        }
                        default->{
                            System.out.println("\n==========================================");
                            System.out.println("             !!Invalid Choice!!             ");
                            System.out.println("==========================================\n");
                        }

                    }

                }else{
                    System.out.println("Invalid Choice, Try again!");
                    scn.nextLine();
                }

            }

        }
    }

    private void PrintSongsInPlaylist(List<Songs> playlist){
        System.out.println("===============================");
        for(Songs s:playlist){
            System.out.println(s);
        }
        System.out.println("===============================");
    }

    private void PrintOptions(){
        var buff = "(0)->Print Options\n" +
                "(1)->Print All Songs from Playlist!\n" +
                "(2)->PLay songs!\n" +
                "(3)->Play next song >>\n" +
                "(4)->Play previous song <<\n" +
                "(5)->Delete current Song from playlist\n"+
                "(6)->Quit\n";
        System.out.println(buff);

    }
    public List<Playlist> getListOfPlaylists(){
        return listOFPlaylists;
    }


}
