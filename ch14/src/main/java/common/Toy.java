package common;

/**
 * @author zx
 */
public class Toy {
    /**
     * practice 1
     * 注释掉默认构造函数会报错，new Instance()无法调用构造函数实例化对象
     * java.lang.InstantiationException: common.Toy
     * 	at java.lang.Class.newInstance(Class.java:427)
     * 	at util.ToyTest.testInfo(ToyTest.java:37)
     */
    public Toy(){};
    public Toy(int i){}
}
