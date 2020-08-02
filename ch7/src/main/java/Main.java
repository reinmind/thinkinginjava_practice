/**
 * @author zx
 */
import common.*;
import org.junit.Test;

public class Main {
    /**
     * 组合语法
     * - 在类中放置域
     *
     * 初始化对象的四种方法：
     * 1. 定义对象的地方
     * 2. 类的构造器当中
     * 3. 在使用这些对象之前：delayed initialization
     * 4. 使用实例初始化
     */
    /**
     * practice 1
     * 创建一个类，在第二个类当中用第一个类的引用，用惰性初始化方法
     */
    @Test
    public void f1(){
        DelayedLoad delayedLoad = null;
        if(delayedLoad == null){
            delayedLoad = new DelayedLoad();
            System.out.println(delayedLoad);
        }
    }
    /**
     * 继承语法
     * - extends自动继承父类当中的域
     *
     * 父类的私有的属性虽然不能直接访问，但是可以通过公有方法定义修改
     */
    /**
     * practice 2
     * 继承Detergent，并且重写里面的方法
     */
    @Test
    public void f2(){
        Detergent detergent = new Detergent();
        detergent.detergent();
        System.out.println(detergent);
    }
    /**
     * practice 3,4
     * 证明类有一个默认的构造器，而且会默认调用父类的构造器
     * 即使在子类的构造器中不显式地调用父类构造器，他自己也会调用
     */
    @Test
    public void f3(){
        Detergent detergent = new Detergent();
        detergent = null;
    }
    /**
     * 代理语法
     * - 一种介于组合和继承的复用方式，适用于组件非组合与继承的场景
     * - 直接在client类中创建方法调用server当中的组件不合适的情况下
     * - 代理的实质就是让第三方的类接收一个client类以及server类，通过调用server的功能完成client所请求的功能
     */

    /**
     * practice 11
     * 修改Detergent.java 让其使用代理
     */

    /**
     * - 灵活使用组合和继承
     * knife and fork
     */

    /**
     * 手动清理对象，当对象在不使用的时候需要自己手动调用销毁对象
     */
    /**
     * 将一个适当的dispose()方法应用到练习9当中的类中。。。(清理)
     */



}
