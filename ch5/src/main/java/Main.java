import entity.Cup;
import entity.G;
import entity.Tank;
import org.junit.Test;

import static utils.Print.print;

import entity.Book;

/**
 * 初始化和清理正是涉及安全的两个问题
 *
 * @author zx
 */
public class Main {
    /**
     * practice 1
     * des1: 定义类，包含一个未初始化的String引用,验证null
     */
    class A {
        String str;
    }

    @Test
    public void f1() {
        A a = new A();
        print(a.str);
    }

    class B {
        String str = new String("hello,B");
    }

    class C {
        String str = "hello";

        C() {
            str = "hello,C";
        }
    }

    /**
     * practice 2
     * des: 定义类，String引用，一个在定义时就初始化，一个在构造器初始化
     * <p>
     * 定义时的初始化发生在构造器之前
     */
    @Test
    public void f2() {
        B b = new B();
        C c = new C();
        print(b.str);
        print(c.str);
    }

    /**
     * practice 3
     * des: 创建默认构造器，打印一条消息
     */
    class D {
        D() {
            print("hello,D");
        }

        D(String str) {
            this();
            print(str);
        }
    }

    @Test
    public void f3() {
        new D();
    }

    /**
     * practice 4
     * des: 重载构造器D
     */
    @Test
    public void f4() {
        new D("override");
    }

    /**
     * practice 5,6
     * des: 重载Dog类的bark方法,验证参数顺序不同会不会重载
     */
    class Dog {
        void bark(int i, Integer j) {
            print("barking");
        }

        void bark(Integer i, int j) {
            print("howling");
        }
    }

    @Test
    public void f5() {
        Dog dog = new Dog();
        Integer x = 2;
        dog.bark(1, x);
        dog.bark(x, 2);
    }

    /**
     * practice 7
     * des: 创建一个没有构造器的类，验证编译器是否加入了构造器
     */
    @Test
    public void f7() {
        // 只要编写一个无参构造器，就替换了默认的构造器，即可验证

    }

    /**
     * practice 8
     * des: 编写具有两个方法的类，第一个调用第二个两次，第一次用this，第二次不用this
     */
    class E {
        public void e1() {
            this.e2();
            e2();
        }

        void e2() {
            print("e2");
        }
    }

    @Test
    public void f8() {
        E e = new E();
        e.e1();
    }

    /**
     * practice 9
     * des: 两个构造器，第一个用this调用第二个，参见classD
     */

    /**
     * practice 10
     * des: 编写具有finalize()方法的类，并在方法中打印消息。在main()中为该类创建一个对象。解释这个程序的行为
     * <p>
     * finalize() 在对象变为野对象的时候自动销毁执行
     */
    @Test
    public void f10() {
        new Book(true);
    }

    /**
     * practice 11
     * des: 修改前一个练习的程序，让你的finalize()总会被调用
     */
    @Test
    public void f11() {
        new Book(true);
        System.gc();
    }

    /**
     * practice 12
     * des: 编写名为Tank的类，此类的状态可以是“满的”或“空的”。其终结条件是：对象被清理时必须处于空状态，编写finalize（）以检验
     * 终结条件是否成立。在main（）中测试tank可能发生的几种方式
     */
    @Test
    public void f12() {
        new Tank("clean");
        System.gc();
    }

    /**
     * practice 13
     * des: 静态代码块只会被执行一次，两种静态执行方法
     */
    @Test
    public void f13() {
        //Cup cup = new Cup(3);
        print(Cup.cup1.maker);
        print(Cup.cup2.maker);
    }

    /**
     * practice 14
     * des: 编写一个类，拥有两个静态字符串域，其中一个在定义处初始化，另一个在静态块中初始化。现在，加入一个静态方法用以打印出
     * 两个字段值。请证明它们都会在被使用之前完成初始化动作。
     */

    @Test
    public void f14() {
        print(G.str1);
        print(G.str2);
    }

    /**
     * practice 15
     * des: 编写一个含有字符串域的类，并采用实例初始化方式进行初始化
     */
    @Test
    public void f15() {
        G g = new G();
        print(g.str3);
    }

    /**
     * practice 16
     * des: String对象数组赋值并打印
     */
    @Test
    public void f16() {
        String[] strings = new String[10];
        strings[0] = "str1";
        strings[1] = "str2";
        strings[2] = "str3";
        for(String str: strings){
            print(str);
        }
    }
    /**
     * practice 17
     * des: 创建一个接受String参数的对象，一个引用改对象的数组，观察改对象是否被构造器初始化
     */
     @Test
     public void f17(){
        F[] fs = new F[10];
        boolean[] bs = new boolean[10];
        if(bs[0]){
            print("true");
        }
        else{
            print("false");
        }
     }
     class F{
         public F(String args){
             print("object with string created");
             print(args);
         }
         public F(){
             print("plain object created");
         }
     }
    /**
     * practice 18
     * des: 通过创建对象赋值给引用数组，从而完成前一个练习
     */
     @Test
     public void f18(){
        F[] fs = new F[3];
        fs[0] = new F();
     }

    /**
     * practice 19
     * des: 写一个类，它接受一个可变参数的String数组，验证你可以向改方法传递一个用逗号分隔的String列表
     * 或是一个String[]
     */
    @Test
    public void f19() {
        strList("one", "two", "three");
        String[] strList = {"four", "five", "six"};
        strList(strList);
    }

    /**
     * ... 可以接受数可变的参数列表
     *
     * @param strings
     */
    public void strList(String... strings) {
        for (String str : strings) {
            print(str);
        }
    }

    /**
     * practice 20
     * des: 创建一个使用可变参数列表而不是普通的main()语法的main()
     * 打印所产生的args数组的所有元素，并用各种不同的命令行参数来测试它
     *
     * 见Practice20
     */


    /**
     * practice 21
     * des: 创建一个enum,它包含纸币中最小面值的6种类型，通过values()循环并打印每个值及其ordinal
     */
    enum Type {ONE, FIVE, TEN, TWENTY, FIFTY, ONE_HUNDRED}

    @Test
    public void f21() {
        for (Type t : Type.values()) {
            print(t + " " + t.ordinal());
        }
    }

    /**
     * practice 22
     * des: 在前面的例子中，为enum写一个switch语句，对于每一个case，输出该特定货币的描述
     */
    public void describe(Type t) {
        switch (t) {
            case ONE:
                print("1yuan");
                break;
            case FIVE:
                print("5yuan");
                break;
            case TEN:
                print("10yuan");
                break;
            case TWENTY:
                print("20yuan");
                break;
            case FIFTY:
                print("50yuan");
                break;
            case ONE_HUNDRED:
                print("100yuan");
                break;
            default:
                print("外星币种");
        }
    }

    @Test
    public void f22() {
        for (Type t : Type.values()) {
            describe(t);
        }
    }


}
