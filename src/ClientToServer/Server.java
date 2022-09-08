package ClientToServer;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    private Socket socket=null;
    private ServerSocket serverSocket=null;
    private DataInputStream inputStream=null;
    public Server(int port){
        try{
            serverSocket=new ServerSocket(port);
            System.out.println("ClientToServer.Server Started!");

            System.out.println("Waiting for client!!");

            socket=serverSocket.accept();
            inputStream=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line="";
            while(!line.equals("Over")){
                try{
                    line=inputStream.readUTF();
                    System.out.println(line);
                }catch(Exception ex){
                    System.out.println("Exception: "+ex.getMessage());
                }
            }
            System.out.println("Closing connection...");
            serverSocket.close();
            socket.close();
        }catch(Exception ex) {
            System.out.println("Exception: " + ex.getClass().getSimpleName());
        }
    }
}
