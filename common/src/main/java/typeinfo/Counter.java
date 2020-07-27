package typeinfo;

/**
 * @author zx
 */
public class Counter {
    private static int count = 0;
    public void increase(){
        ++count;
    }
    public static int getCount(){
        return count;
    }
}
