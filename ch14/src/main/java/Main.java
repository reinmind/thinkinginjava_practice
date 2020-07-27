import entity.Circle;
import entity.Individual;
import entity.Rhomboid;
import entity.Shape;
import entity.pets.Gerbil;
import org.junit.Test;
import typeinfo.rf1.RegisteredFactory;
import typeinfo.rf2.RegisteredFactory2;
import util.TypeCounter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zx
 */
public class Main {
    /**
     * practice 3
     * des: Rhomboid向上转型为Shape，再向下转型为Circle
     */
    @Test
    public void f3() {
        Shape r = new Rhomboid();
        System.out.println("r:" + r);
        Shape s = r;
        System.out.println("s:" + s);
        System.out.println("object Name:" + s.getClass().getName());
        /**
         * practice 4
         * instanceof 类型检查
         */
        System.out.println("type check:" + (s instanceof Circle));

        /**
         * java.lang.ClassCastException: common.Rhomboid cannot be cast to common.Circle
         */
        //Circle c = (Circle)s;
        //System.out.println("c:" + c);
    }

    /**
     * practice 5
     * des: 旋转Shape，如果是Circle就不旋转
     */
    @Test
    public void f5() {
        Shape s1 = new Rhomboid();
        Shape s2 = new Circle();
        s1.rotate();
        s2.rotate();
    }

    /**
     * practice 6
     * des:修改Shape.java，使这个程序能将某个特定类型的所有形状都“标示”出来，每一个被导出的Shape类的toString（）
     * 应该能指示出Shape是否被标示
     */

    /**
     * practice 7
     * des: 通过命令行参数来生成指定类的对象
     */
    public static void main(String... args) {
        new Main().f17();
//        Class cls = null;
//        try {
//            cls = Class.forName(args[0]);
//            System.out.println(cls.getSimpleName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * practice 8
     * des: 写一个方法，接收任意对象作为参数，并能够递归打印出该对象所在的继承体系中的所有类
     */
    @Test
    public void f8() {
        try {
            Class cls = Class.forName("org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor");
            dfsPrint(cls, "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dfsPrint(Class cls, String ident) throws ClassNotFoundException {
        System.out.println(ident + "-" + cls);
        ident += "  ";
        Class up = cls.getSuperclass();
        if (up != null) {
            dfsPrint(up, ident);
        }
        for (Class c : cls.getInterfaces()) {
            dfsPrint(c, ident);
        }
    }

    /**
     * practice 9
     * des: 修改前一个练习，让这个方法使用Class.getDeclaredFields()来打印一个类中的域相关信息
     */
    @Test
    public void f9() {
        try {
            Class<? extends Number> cls = Integer.class;
            dfsPrint_fields(cls, "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void dfsPrint_fields(Class cls, String ident) throws ClassNotFoundException {
        System.out.println(ident + "-" + cls.getSimpleName());
        ident += "  ";
        for (Field f : cls.getDeclaredFields()) {
            System.out.println(ident + f.getName());
        }
        Class up = cls.getSuperclass();
        if (up != null) {
            dfsPrint(up, ident);
        }
        for (Class c : cls.getInterfaces()) {
            dfsPrint(c, ident);
        }
    }

    /**
     * practice 10
     * des:写一个程序，使它能判断char数组究竟是基本类型还是一个对象
     * <p>
     * -class [C
     * -class java.lang.Object
     * -interface java.lang.Cloneable
     * -interface java.io.Serializable
     * <p>
     * 继承于Object显然是一个对象
     */
    @Test
    public void f10() {
        char[] x = new char[10];
        Class cls = x.getClass();
        try {
            dfsPrint(cls, "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * practice 11
     * des: 在typeinfo.pets中添加新类Gerbil,并修改本章所有示例，使适应这个新类
     * <p>
     * a instance of b
     * a.isAssignableForm(Class<?> b)
     * a.isInstance(Class<?> b)
     */
    @Test
    public void f11() {
        TypeCounter typeCounter = new TypeCounter(Individual.class);
        typeCounter.count(new Gerbil());
        System.out.println(typeCounter);
    }

    /**
     * practice 12
     * des: 将下一章的CoffeeFactory用于TypeCounter
     */
    @Test
    public void f12() {

    }

    /**
     * practice 13
     * des: 将本章的RegisteredFactory示例用于TypeCounter
     */
    @Test
    public void f13() {
        TypeCounter typeCounter = new TypeCounter(Object.class);
        List<?> list = RegisteredFactory.getParts();
        for (Object o : list) {
            typeCounter.count(o);
        }
        System.out.println(typeCounter);
    }

    /**
     * 工厂类返回物件类对象来构造实例
     * practice 14
     * des: 构造器是一种工厂方法，修改RegisteredFactory，使其不要使用显式的工厂，而是将类存储到List当中，并使用newInstance来创建对象
     */
    @Test
    public void f14() {
        TypeCounter typeCounter = new TypeCounter(Object.class);
        List<?> list = RegisteredFactory2.getParts();
        for (Object o : list) {
            typeCounter.count(o);
        }
        System.out.println(typeCounter);
    }

    /**
     * practice 15
     * des: 使用注册工厂实现一个新的PetCreator,并修改Pet的外观,使其使用这个新的Creator而并非另外两个Creator。确保使用Pets.java的其他示例仍然可以正常工作
     */
    @Test
    public void f15() {

    }

    /**
     * practice 16
     * des: 修改第十五章的Coffee继承结构，以便可以使用注册工厂
     */
    @Test
    public void f16() {

    }

    /**
     * practice 17
     * des: 修改ShowMethods.java中的正则表达式，以去掉native和final关键字（提示：使用逻辑“或”）
     */
    @Test
    public void f17() {
        Class<?> c = null;
        try {
            c = Class.forName("Main");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = c.getMethods();
        Constructor[] constructors = c.getConstructors();
        for (Method m : methods) {
            System.out.println(m.getModifiers() + " " + m.getReturnType() + " " + m.getName());
            System.out.println();
            //System.out.println("" + m.getGenericReturnType() + " " + m.getModifiers() + " "+ m.getName() + "(" + m.getParameters() + ")");
        }

        for (Constructor cons : constructors) {
            System.out.println(cons.toString());
        }
    }

    /**
     * practice 18
     * des: 将showMethods变为一个非public类，并验证合成的默认构造器不会再在输出中出现
     */
    @Test
    public void f18() {

    }


    /**
     * practice 19
     * des: 在ToyTest.java中，使用反射机制，通过非默认构造器创建Toy对象
     */
     @Test
     public void f19(){
         try {
             Class cls = Class.forName("entity.Toy");
             Constructor[] constructors = cls.getDeclaredConstructors();
             for(Constructor cons: constructors){
                 Class<?>[] params = cons.getParameterTypes();
                 if(params.length > 0) {
                     System.out.println(cons.newInstance(1));
                 }
             }
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         } catch (InstantiationException e) {
             e.printStackTrace();
         } catch (InvocationTargetException e) {
             e.printStackTrace();
         }

     }

     /**
      * practice 20
      * des: 在java.sun.com的jdk文档中找出java.lang.Class接口，写一个程序，使他能够接收命令行参数所指定的类名，然后使用
      * Class的方法打印该类所有可以获得的信息。用标准程序库的类和你自己写的类，分别测试这个程序
      */
      @Test
      public void f20(){

      }

    /**
     * 代理模式
     * 代理是基本的设计模式之一，他是为了提供额外的或不同的操作，而插入的用来代替“实际”对象的对象。这些操作通常涉及
     * 与“实际“对象的通信，因此代理通常充当着中间人的角色
     */

    /**
     * practice 21
     * des:修改SimpleProxyDemo，使其可以度量方法的调用次数
     */
     @Test
     public void f21(){
        //所有实现ProxyInterface的类继承Counter类，Counter中存在静态成员，统计计数
     }

     /**
      * practice 22
      * des: 修改SimpleDynamicProxy.java 使其可以度量方法调用的次数
      */
      @Test
      public void f22(){
        //因为代理调用了ProxyHandler当中的invoke方法，所以只要统计invoke被调用的次数就可以了
          //所以解决方案就是DynamicProxyHandler继承Counter类，同RealObject类一样
      }

      /**
       * practice 23
       * des: 在SimpleDynamicProxy.java中的invoke()内部，尝试打印proxy参数并解析所产生的结果
       */
       @Test
       public void f23(){
           //只要获取了proxy的Class对象，就可以获取到类型信息
       }

       /**
        * practice 24
        * des: 在RegisteredFactories.java中添加空对象
        */
        @Test
        public void f24(){

        }

}
