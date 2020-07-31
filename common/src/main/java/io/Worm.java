package io;

import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Random;

/**
 * @author zx
 */
class Data implements Serializable{
    private int n;
    public Data(int n){this.n = n;}
    @Override
    public String toString(){
        return Integer.toString(n);
    }

}
public class Worm implements Serializable{
    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;
    public Worm(int i,char x){
        System.out.println("Worm constructor: " + i);

    }
}
