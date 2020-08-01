package network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author zx
 */
public class SocketTest {
    public static void telnet(String address,Integer port){
        try(Socket socket = new Socket(address,port)){
            InputStream inputStream = socket.getInputStream();
            Scanner in = new Scanner(inputStream);

            while(in.hasNext()){
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
