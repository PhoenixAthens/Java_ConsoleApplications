package SongsApp.SomeAlternates;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static MusicsApp musicApp=new MusicsApp();
    private static Scanner scan=new Scanner(System.in);
    private static List<Album> returnListOfAvailableAlbums(){
        return musicApp.returnAlbumCollection();
    }

    private static void PrintOptions(){
        var options="(1)->Create Album \n" +
                "(2)->Remove Album\n"+
                "(3)->Add Song To album \n" +
                "(4)->Create playlist \n" +
                "(5)->Print available playlists\n"+
                "(6)->Print Available Albums\n"+
                "(7)->Inspect Album\n"+
                "(8)->Remove existing Playlist\n"+
                "(9)->Add Songs to playlist \n" +
                "(10)->Enter the player\n"+
                "(11)->Inspect Playlist\n"+
                "(12)->Exit Songs App\n"+
                "(13)->Print Available Options\n";
        System.out.println(options);
    }
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
    private static void EnterThePlayer(){
        if(!musicApp.getListOfPlaylists().isEmpty()){
            musicApp.PrintAvailablePlaylists();
            System.out.print("Enter the playlist name: ");
            String nameOfPlaylist=scan.nextLine();
            Playlist play=musicApp.searchForPlaylist(nameOfPlaylist);
            if(play!=null)
                musicApp.playSongs(play.getPlaylist());
            else{
                System.out.println("\n========================");
                System.out.println("No Playlist found!!");
                System.out.println("==========================\n");
            }
        }else{
            System.out.println("No playlist available!!");
        }

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
    private static boolean AddSongToAlbum(){
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
                        album.getSongs().addSongs(songName,songDuration);
                        System.out.println("Add more Songs? (1=>Yes/2=>No)");
                        if(scan.hasNextInt()){
                            int input=scan.nextInt();
                            scan.nextLine();
                            if(input!=1){
                                System.out.println("\n==================");
                                album.getSongs().PrintAlbum();
                                innerFlag=false;
                                System.out.println("==================\n");
                            }
                        }else{
                            System.out.println("\n==================");
                            album.getSongs().PrintAlbum();
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
    private static boolean createPlaylist(){
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
    private static boolean removePlaylist(){
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
    private static void AddSongsToPlaylist(){
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
                    if(album2.getSongs().getArrayListOfSongs().isEmpty()){
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
                        for(Songs s: album2.getSongs().getArrayListOfSongs()){
                            album2.AddSongsToPlaylist(s.getTitle(),play.getPlaylist());
                        }
                        return;

                    }

                }
                Album album=musicApp.lookUpForSongThroughAllAlbums(nameOfSong);
                if(album!=null){
                    var result=album.AddSongsToPlaylist(nameOfSong,play.getPlaylist());
                    if(result){
                        System.out.println("\n=========================================");
                        System.out.println(nameOfSong+" added to playlist!!");
                        System.out.println("==========================================\n");
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
    private static void PrintAvailableAlbums(){
        musicApp.PrintAvailableAlbums();
    }
    private static void InspectAlbum(){
        if(!musicApp.returnAlbumCollection().isEmpty()){
            PrintAvailableAlbums();
            System.out.print("Enter Album Name: ");
            String albumName=scan.nextLine();
            Album album=musicApp.SearchForAlbum(albumName);
            if(album!=null)
                album.getSongs().PrintAlbum();
            else{
                System.out.println("\n=================================");
                System.out.println("        !!Album not found!!       ");
                System.out.println("=================================\n");
            }
        }else{
            System.out.println("\n================================");
            System.out.println("      !!No albums available!!     ");
            System.out.println("================================\n");
        }
    }
    private static void InspectPlaylist(){
        if(!musicApp.getListOfPlaylists().isEmpty()){
            PrintAvailableAlbums();
            System.out.print("Enter playlist Name: ");
            String playlistName=scan.nextLine();
            Playlist playlist=musicApp.searchForPlaylist(playlistName);
            System.out.println("\n================================");
            if(playlist!=null){
                for(Songs s:playlist.getPlaylist()){
                    System.out.println(s);
                }

            }else{
                System.out.println("      !!Playlist not found!!      ");
            }
            System.out.println("================================\n");

        }else{
            System.out.println("\n================================");
            System.out.println("    !!No playlists available!!    ");
            System.out.println("================================\n");
        }
    }


    public static void main(String...args){
        var flag=true;
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
                    case 6-> PrintAvailableAlbums();
                    case 7->InspectAlbum();
                    case 8->{
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
                    case 9->AddSongsToPlaylist();
                    case 10-> EnterThePlayer();
                    case 11->InspectPlaylist();
                    case 12->{
                        System.out.println("\n==================================");
                        System.out.println("          Exiting Song's App        ");
                        System.out.println("==================================\n");
                        flag=false;
                    }
                    case 13->PrintOptions();

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
