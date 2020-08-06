/**
 * @author zx
 */
public class Main17 {
    /**
    static {
        String str = "张a";
        System.out.println("value of char:" + (int)'张');
        System.out.println("getBytes:" + str.getBytes());
        System.out.println("getHashCode:" + str.hashCode());
        System.out.println("toString:" + str.toString());
    }
    **/

    public static void main(String[] args) {
        String str1 = "张三";
        String str2 = "aaa";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
