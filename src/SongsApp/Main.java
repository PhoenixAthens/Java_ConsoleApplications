package SongsApp;
import java.util.*;
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
    private static void PrintOptions(){
        var options="(1)->Create Album \n" +
                "(2)->Add Song To album \n" +
                "(3)->Create playlist \n" +
                "(4)->Add Songs to playlist \n" +
                "(5)->Enter the player\n"+
                "(6)->Print Available Albums\n"+
                "(7)->Remove Album From Memory\n"+
                "(8)->Search for Album\n"+
                "(9)->Exit Songs App\n"+
                "(10)->Print Available Options\n";
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
    public static boolean AddSongToAlbum(){
        System.out.print("Enter Album Name: ");
        String albumName=scan.nextLine();
        Album album=musicApp.SearchForAlbum(albumName);
        if(album!=null){
            boolean innerFlag=true;
            while(innerFlag){
                System.out.print("Enter Song name: ");
                String songName=scan.nextLine();
                System.out.print("Enter Song Duration: ");
                double songDuration=scan.nextDouble();
                album.addSongs(songName,songDuration);
                System.out.println("Add more Songs? (1=>Yes/2=>No)");
                if(scan.hasNextInt()){
                    int input=scan.nextInt();
                    if(input!=1){
                        album.PrintAlbum();
                        innerFlag=false;
                    }
                }else{
                    album.PrintAlbum();
                    System.out.println("Invalid input!!, Breaking out!");
                    innerFlag=false;

                }
            }
            return true;

        }else{
            System.out.println("Album not found!");
            return false;
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
                    case 2->{
                        System.out.println("\t\t\t\t+++++++++++++++++++++++++==Adding Songs to Album==+++++++++++++++++++++++++");
                        boolean result=AddSongToAlbum();
                        if(result){
                            System.out.println("Songs SuccessfullyAdded to Album!");
                        }else{
                            System.out.println("Error Adding Songs to Album!!");
                        }
                    }case 10->PrintOptions();

                }
            }else{
                System.out.println("Invalid entry!!");
                scan.nextLine();
            }

        }

    }
}
