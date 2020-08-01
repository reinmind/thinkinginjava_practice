package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
import java.util.*;
/**
 * @author zx
 */
public class EhcoServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket socket = new ServerSocket(8189)){
            try(Socket incoming = socket.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                try (Scanner scanner = new Scanner(inputStream)){
                    PrintWriter printWriter = new PrintWriter(outputStream,true);

                    printWriter.println("Hello!Enter Goodbye to exit!");

                    boolean done = false;
                    while(!done && scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        printWriter.println("Echo:" + line);
                        if(line.trim().equals("bye")) {
                            done = true;
                        }
                    }
                }

            }
        }
    }
}
