package network;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zx
 */
public class ObjectServer {


    public static void main(String[] args) throws IOException {
        try(ServerSocket socket = new ServerSocket(8189)){
            System.out.println("Waiting connection...");
            try(Socket incoming = socket.accept()){

                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                //InetAddress clientAddr = incoming.getInetAddress();
                //Welcome banner to client
                PrintWriter printWriter = new PrintWriter(outputStream,true);
                printWriter.println("Welcome to server");
                printWriter.println("please input the object you want to get");
                printWriter.println("100");
                //read request
                Scanner scanner = new Scanner(inputStream);
                String command = scanner.nextLine();
                System.out.println(command);
                while(command != "quit" | command != "exit" | command != "bye"){
                    printWriter.println("200");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);;
                    try {
                        Object o = ObjectServer.getObject(command);
                        objectOutputStream.writeObject(o);
                    } catch (ClassNotFoundException e) {
                        printWriter.write(command + " NotFound!");
                    }finally {
                        Object o = command + " NotFound！";
                        objectOutputStream.writeObject(o);
                    }
                    command = scanner.nextLine();
                };
            }
        }
    }
    public static Object getObject(String objName) throws IOException, ClassNotFoundException {
        //read Object from local
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("common/src/main/resources/"+ objName +".out"));
        // common/src/main/resources/RaspberryPi.out
        Object o = objectInputStream.readObject();
        return o;
    }
}
