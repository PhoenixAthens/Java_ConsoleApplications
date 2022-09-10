package SongsApp;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static MusicsApp musicApp=new MusicsApp();
    private static Scanner scan=new Scanner(System.in);
//    public static void main(String...args){
//        Album album1=new Album("Little Men","John wayne");
//        album1.addSongs("Song1",4.32);
//        album1.addSongs("Song2",5.23);
//        album1.addSongs("Song3",2.5);
//        album1.addSongs("Song4",4.5);
//        Album album2=new Album("Dance to Hell","frank long");
//        album2.addSongs("SongA",3.45);
//        album2.addSongs("SongB",1.33);
//        album2.addSongs("SongC",5.00);
//        album2.addSongs("SongD",3.67);
//        musicApp.addAlbumToMemory(album1);
//        musicApp.addAlbumToMemory(album2);
//        Playlist playlist=new Playlist("Loving souls");
//        musicApp.SearchForAlbum("Little Men").AddSongsToPlaylist(1,playlist.getPlaylist());
//        musicApp.SearchForAlbum("Little Men").AddSongsToPlaylist(2,playlist.getPlaylist());
//        musicApp.SearchForAlbum("Dance to Hell").AddSongsToPlaylist(3,playlist.getPlaylist());
//        musicApp.playSongs(playlist.getPlaylist());
//
//        //First point use arrayList to get a playlist for adding songs to playlist
//        //Add methods in playlist.
//        //In albums collection add a search method
//        //In Playlist add more methods and those method for playing song reverse, forward and rewind, try them
//        //out in playlist.
//
//
//    }
    private static List<Album> returnListOfAvailableAlbums(){
        return musicApp.returnAlbumCollection();
    }
    private static void PrintAvailableAlbums(){
        musicApp.PrintAvailableAlbums();
    }
    private static void PrintOptions(){
        var options="(1)->Create Album \n" +
                "(2)->Remove Album\n"+
                "(3)->Add Song To album \n" +
                "(4)->Create playlist \n" +
                "(5)->Print available playlists\n"+
                "(6)->Remove existing Playlist\n"+
                "(7)->Add Songs to playlist \n" +
                "(8)->Enter the player\n"+
                "(9)->Print Available Albums\n"+
                "(10)->Remove Album From Memory\n"+
                "(11)->Search for Album\n"+
                "(12)->Exit Songs App\n"+
                "(13)->Print Available Options\n";
        System.out.println(options);
    }
    //if user on adding songs to albums enter a number use the add to album method which adds using index number
    //if user on adding songs to albums enter a string use the other add method.
    private static boolean CreateAlbum(){
        System.out.print("Enter Album Name: ");
        String albumName=scan.nextLine();
        System.out.print("Enter Artist Name: ");
        String artistName=scan.nextLine();
        Album album=new Album(albumName,artistName);
        for(Album a: musicApp.returnAlbumCollection()){
            if(album.equals(a)){
                System.out.println("Album already exists!");
                return false;
            }
        }
        boolean step=musicApp.addAlbumToMemory(album);
        musicApp.PrintAvailableAlbums();

        return step;
    }
    private static void RemoveAlbum(){
        List<Album> albums=musicApp.returnAlbumCollection();
        if(albums.isEmpty()){
            System.out.println("\n===================================");
            System.out.println("No albums available!!");
            System.out.println("=====================================\n");
        }
        else{
            musicApp.PrintAvailableAlbums();
            System.out.print("Enter album name: ");
            String albumName=scan.nextLine();
            //Album album=musicApp.SearchForAlbum(albumName);
            var result=musicApp.RemoveAlbumFromMemory(albumName);
            if(result){
                System.out.println("\n===================================");
                System.out.println("Album Successfully removed!");
                System.out.println("=====================================\n");
            }
            else{
                System.out.println("\n===================================");
                System.out.println("Album not found!");
                System.out.println("=====================================\n");
            }
        }
    }
    public static boolean AddSongToAlbum(){
        List<Album> listOfAvailableAlbums=returnListOfAvailableAlbums();
        if(!listOfAvailableAlbums.isEmpty()){
            PrintAvailableAlbums();
            System.out.print("Enter Album Name: ");
            String albumName=scan.nextLine();
            Album album=musicApp.SearchForAlbum(albumName);
            if(album!=null){
                boolean innerFlag=true;
                while(innerFlag){
                    System.out.print("Enter Song name: ");
                    String songName=scan.nextLine();
                    try{
                        System.out.print("Enter Song Duration: ");
                        double songDuration = scan.nextDouble();
                        scan.nextLine();
                        album.addSongs(songName,songDuration);
                        System.out.println("Add more Songs? (1=>Yes/2=>No)");
                        if(scan.hasNextInt()){
                            int input=scan.nextInt();
                            scan.nextLine();
                            if(input!=1){
                                System.out.println("\n==================");
                                album.PrintAlbum();
                                innerFlag=false;
                                System.out.println("==================\n");
                            }
                        }else{
                            System.out.println("\n==================");
                            album.PrintAlbum();
                            System.out.println("==================\n");
                            System.out.println("Invalid input!!, Breaking out!");
                            innerFlag=false;

                        }
                    }catch(InputMismatchException ex){
                        System.out.println("\n==========================");
                        System.out.println("Exception: "+ex.getClass().getSimpleName());
                        System.out.println("============================\n");
                        scan.nextLine();
                    }

                }
                return true;

            }else{
                System.out.println("\n==================");
                System.out.println("Album not found!");
                System.out.println("==================\n");
                return false;
            }
        }else{
            System.out.println("\n==================");
            System.out.println("No Albums Available!!");
            System.out.println("==================\n");
            return false;
        }
    }
    public static boolean createPlaylist(){
        System.out.print("Enter playlist name: ");
        String playlistName=scan.nextLine();
        var result=musicApp.searchForPlaylist(playlistName);
        if(result==null){
            Playlist playlist=new Playlist(playlistName);
            var submit=musicApp.CreatePlaylist(playlist);
            if(submit) return true;
            return false;
        }
        System.out.println("\n===================");
        System.out.println("Album already exist!");
        System.out.println("=====================\n");
        System.out.print("Do you want to overwrite existing playlist (1=>Yes/2=>No):: ");
        if(scan.hasNextInt()){
            int input=scan.nextInt();
            if(input!=1){
                System.out.println("\n===================");
                System.out.println("Aborting procedure!!");
                System.out.println("=====================\n");
                return false;
            }else{
                musicApp.overWriteExistingAlbum(result,new Playlist(playlistName));
                System.out.println("\n=====================");
                musicApp.PrintAvailablePlaylists();
                System.out.println("=======================\n");
                return true;
            }
        }else{
            System.out.println("\n=====================");
            System.out.println("Invalid input, Aborting Procedure!!");
            System.out.println("=======================\n");
            return false;
        }

    }
    public static boolean removePlaylist(){
        List<Playlist> available=musicApp.getListOfPlaylists();
        if(available.isEmpty()){
            return false;
        }else{
            musicApp.PrintAvailablePlaylists();
            System.out.println("Enter playlist name: ");
            String name=scan.nextLine();
            int process=musicApp.removePlaylist(name);
            return process != -1;
        }
    }
    public static void AddSongsToPlaylist(){
        List<Playlist> playlistList=musicApp.getListOfPlaylists();
        if(playlistList.isEmpty()){
            System.out.println("\n========================");
            System.out.println("No Playlist found!!");
            System.out.println("==========================\n");
        }else{
            musicApp.PrintAvailablePlaylists();
            System.out.print("Enter playlist name: ");
            String nameOfPlaylist=scan.nextLine();
            Playlist play=musicApp.searchForPlaylist(nameOfPlaylist);
            if(play!=null){
                System.out.print("Enter name of Song: ");
                String nameOfSong=scan.nextLine();
                Album album2=musicApp.SearchForAlbum(nameOfSong);
                if(album2!=null){
                    if(album2.getArrayListOfSongs().isEmpty()){
                        System.out.println("\n=========================================");
                        System.out.println("You have album name instead of song name!!");
                        System.out.println("==========================================\n");
                        System.out.println("\n=========================================");
                        System.out.println("          !!The album is empty!!           ");
                        System.out.println("==========================================\n");


                    }
                    else{
                        System.out.println("\n=========================================");
                        System.out.println("You have album name instead of song name!!");
                        System.out.println("==========================================\n");
                        System.out.println("\n=========================================");
                        System.out.println("Adding All Songs from album to playlist!!");
                        System.out.println("===========================================\n");
                        for(Songs s: album2.getArrayListOfSongs()){
                            album2.AddSongsToPlaylist(s.getTitle(),play.getPlaylist());
                        }
                        return;

                    }

                }
                Album album=musicApp.lookUpForSongThroughAllAlbums(nameOfSong);
                if(album!=null){
                    var result=album.AddSongsToPlaylist(nameOfSong,play.getPlaylist());
                    if(result){
                        System.out.println(nameOfSong+" added to playlist!!");
                    }
                    else{
                        System.out.println("\n=========================================");
                        System.out.println("Error Adding "+nameOfSong+" to playlist!!");
                        System.out.println("==========================================\n");
                    }
                }else{

                    System.out.println("\n========================");
                    System.out.println("Song not found!!");
                    System.out.println("=========================\n");
                }
            }else{
                System.out.println("\n========================");
                System.out.println("Playlist not found!!");
                System.out.println("=========================\n");
            }
        }
    }
    public static void main(String...args){
        boolean flag=true;
        System.out.println("\t\t\t\t+++++++++++++++++++++++++==WELCOME==+++++++++++++++++++++++++");
        while(flag){
            PrintOptions();
            System.out.print("Enter you choice: ");
            if(scan.hasNextInt()){
                int input=scan.nextInt();
                scan.nextLine();
                switch(input){
                    case 1->{
                        System.out.println("\t\t\t\t+++++++++++++++++++++++++==Creating Album==+++++++++++++++++++++++++");
                        boolean result=CreateAlbum();
                        if(result){
                            System.out.println("Album successfully saved!");
                        }else{
                            System.out.println("Error saving album!");
                        }
                    }
                    case 2->RemoveAlbum();

                    case 3->{
                        System.out.println("\t\t\t\t+++++++++++++++++++++++++==Adding Songs to Album==+++++++++++++++++++++++++");
                        boolean result=AddSongToAlbum();
                        if(result){
                            System.out.println("Songs SuccessfullyAdded to Album!");
                        }else{
                            System.out.println("Error Adding Songs to Album!!");
                        }
                    }
                    case 4->{

                        var result=createPlaylist();
                        if(result){
                            System.out.println("\n=======================");
                            System.out.println("Playlist successfully created!!");
                            System.out.println("=======================\n");
                        }
                    }case 5-> musicApp.PrintAvailablePlaylists();
                    case 6->{
                        var result=removePlaylist();
                        if(result){
                            System.out.println("\n=============================");
                            System.out.println("Playlist successfully removed!!");
                            System.out.println("===============================\n");
                        }else{
                            System.out.println("\n=============================");
                            System.out.println("Error removing playlist");
                            System.out.println("===============================\n");
                        }
                    }
                    case 7->AddSongsToPlaylist();

                    case 10->PrintOptions();

                }
            }else{
                System.out.println("==================");
                System.out.println("Invalid entry!!");
                System.out.println("==================");
                scan.nextLine();
            }

        }

    }
}
