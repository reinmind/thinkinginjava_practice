package io;

import java.io.*;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;


public class IOTest {
    /**
     * InputStream,OutputStream面向字节
     * Reader,Writer面向字符
     */
//    public InputStream inputStream;
//    public OutputStream outputStream;
//    public Reader reader;
//    public Writer writer;
//    public System system;

    public static void main(String[] args) throws IOException {
        List<String> list = new LinkedList<>();
//        File file = new File("comment.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("common/src/main/resources/comment.txt"));
        String tmp;
        while((tmp = bufferedReader.readLine()) != null){
            list.add(tmp);
        }

        for(int i = list.size() - 1; i >= 0; --i){
            System.out.println(list.get(i));
        }
    }

}
