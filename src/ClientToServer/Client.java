package ClientToServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class Client {
    private Socket socket=null;
    private DataInputStream inputStream=null;
    private DataOutputStream output=null;
    public Client(String address, int port){
        try{
            socket=new Socket(address,port);
            System.out.println("connected...");
            inputStream=new DataInputStream(System.in);
            output=new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException ex){
            System.out.println("Exception: "+ex.getMessage());
        }
        String line="";
        while(!line.equals("Over")){
            try{
                line=inputStream.readLine();//I believe this will keep asking me for inputs and will keep sending it to the server
                output.writeUTF(line);
            }catch(Exception ex){
                System.out.println("Exception: "+ex.getClass().getSimpleName());
            }
        }
        try{
            socket.close();
            inputStream.close();
            output.close();
        }catch(Exception ex){
            System.out.println("Exception: "+ex.getClass().getSimpleName());
        }
    }
    /*public static void ClientToServer.main(String...args){
        ClientToServer.Client net=new ClientToServer.Client("192.168.1.2",5000);
    }*/
}
