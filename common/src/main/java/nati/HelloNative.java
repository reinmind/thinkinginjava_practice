package nati;

/**
 * @author zx
 */
public class HelloNative {
    public static void main(String[] args) {
        new NativeTest().t1();
    }
    static {
        System.load("E:\\src\\thinkinginjava_src\\common\\src\\main\\java\\nati_NativeTest.dll");
    }
}
