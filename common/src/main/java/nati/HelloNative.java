package nati;

import org.junit.Test;

/**
 * @author zx
 */
public class HelloNative {
    @Test
    public void printPath(){
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("user.dir"));
    }

    public static void main(String[] args) {
        new NativeTest().t1();

    }
    //you should copy nativ_NativTest.dll to C:\System32
    static {
        System.loadLibrary("nati_NativeTest");
    }
}
