package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zx
 */
public class ObjectClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //系统输入流
        Scanner consoleScanner = new Scanner(System.in);
        String target = "localhost";
        try(Socket socket = new Socket(target,8189)){

            Scanner serverScanner = new Scanner(socket.getInputStream());
            PrintWriter serverPrintWriter = new PrintWriter(socket.getOutputStream(),true);
            // 对象输入流
            //ObjectInputStream serverInputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("connected to : " + target);
            while(serverScanner.hasNextLine()){
                String line = serverScanner.nextLine();
                if("100".equals(line)){
                    String command = consoleScanner.nextLine();
                    serverPrintWriter.println(command);
                    break;
                }
                System.out.println(line);
            }

            // 信息 <- 服务器

            while(serverScanner.hasNextLine()){
                String line = serverScanner.nextLine();
                System.out.println(line.trim());
                // 200, 获取对象成功
                if("200".equals(line.trim())){
                    System.out.println("transferring obj...");
                    ObjectInputStream serverInputStream = new ObjectInputStream(socket.getInputStream());
                    readObject(serverInputStream);
                }
            }

        }
    }

    public static Object readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object o = objectInputStream.readObject();
        System.out.println(o);
        return o;
    }
}
