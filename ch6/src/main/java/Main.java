import org.junit.Test;
import test.PackageTest;

/**
 * 本类中创建的所有包访问控制特性都在debug包中得到体现
 */
public class Main {
    /**
     * 一个文件中只存在一个public类，且文件名与类名相同
     */
    /**
     * practice 1
     * 再某个包中创建一个类，在这个包的外部创建一个该类的实例
     */
    @Test
    public void f1(){
        PackageTest packageTest = new PackageTest();
    }
    /**
     * practice 2
     * 校验类名相同的情况下的导入冲突
     */

    /**
     * practice 3
     * 创建两个相同的类在两个不同的包中，演示debug开启和关闭的效果
     */
    @Test
    public void f2(){
        System.out.println(debug.Print.debug());
        System.out.println(debugoff.Print.debug());
    }
    /**
     * practice 4
     * 展示protected方法具有包访问权限，但不是public
     */
    @Test
    public void f3(){
        //这行会报错是因为包访问权限只在包内
        //System.out.println(debug.Print.pro);
    }
    /**
     * practice 5
     * 创建一个包，包含private,protected,public域，观察其区别
     */

    /**
     * practice 6
     * 创建一个带有protected数据的类，运用在第一个类中处理protected数据的方法在相同的文件中创建第二个类
     */

    /**
     * practice 9
     * 默认包访问权限，即使是子包也不可访问
     * 如果在同一个包下，即使类的修饰符不是public也可以访问
     */
}
