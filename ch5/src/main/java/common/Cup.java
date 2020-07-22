package common;

import sun.awt.windows.WPrinterJob;

/**
 * @author zx
 */
public class Cup {
    public int maker;
    /**
     * 静态对象的非静态成员属性不一定相同
     */
    public static Cup cup1;
    public static Cup cup2;
    static{
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    public Cup(int maker){
        this.maker = maker;
        System.out.println("Cup(" + maker +")");
    }
}
