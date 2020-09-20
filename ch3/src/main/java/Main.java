import org.junit.Test;

import java.util.Random;

import static utils.Print.*;
/**
 *
 * @author zx
 */

public class Main {

    class Value{
        int i;
        Value(){

        }
    }
    /**
     * loc 3.3
     */
    @Test
    public void precedence(){
        int x = 1,y = 2, z = 3;
        int a = x + y - 2/2 + z;
        int b = x + (y - 2)/(2 + z);
        System.out.println("a = " + a + ",b = " + b);
    }

    /**
     * loc 3.7
     */
    @Test
    public void equivalence(){
        Integer i1 = new Integer(47);
        Integer i2 = new Integer(47);

        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(v1.equals(v2));
    }
    /**
     * practice 1
     * des: 使用简短和正常的打印语句
     */
    @Test
    public void shortAndLong(){
        String arg = "short and long";
        System.out.println(arg);
        print(arg);
    }

    /**
     * common class A
     */
    class A{
        public Float x;
    }
    /**
     * practice 2
     * des: 创建包含float域的类，展示别名机制
     */
    @Test
    public void p2(){

        A a1 = new A();
        A a2 = new A();
        a1.x = 1.0f;
        a2 = a1;
        print(a2.x);
    }

    /**
     * practice 3
     * des: 创建包含float的类，展示方法别名机制
     */
    void f3(A o){
        o.x = 2.0f;
    }
    @Test
    public void p3(){
        A a = new A();
        a.x = 1.0f;
        f3(a);
        print(a.x);
    }

    /**
     * practice 4
     * des: 编写一个计算速度的程序，使用的时间和距离都是常量
     */
    @Test
    public void p4(){
        final Double point1 = 0.0;
        final Double point2 = 11.1;
        final Double time = 3.1;
        Double velocity = (point2 - point1) / 3.1;
        print(velocity);
    }

    /**
     * practice 5,6
     * des5: 创建一个Dog类，两个域name,says
     * des6: 增加一个Dog索引,用 == 和 equals()比较对象
     */
    class Dog{
        String name;
        String says;
    }
    @Test
    public void f5(){
        //f5
        Dog spot = new Dog();
        Dog scruffy = new Dog();
        spot.says = "Ruff!";
        scruffy.says = "Wurf!";
        print(spot.says + scruffy.says);
        //f6
        Dog index = spot;
        print(index == spot);
        print(index.equals(spot));
    }

    /**
     * practice 7
     * des: 编写一个程序，模拟扔硬币的结果
     */
    @Test
    public void f7(){
        Random rand = new Random(48);
        for(int i = 0;i < 10; ++i) {
            boolean x = rand.nextBoolean();
            if (x) {
                print("front");
            } else {
                print("back");
            }
        }
    }
    /**
     * practice 8
     * des: 展示用16进制与8进制计数法操作Long，用Long.toBinaryString()显示结果
     */
    @Test
    public void f8(){
        Long l1 = 077L;
        Long l2 = 0x77L;
        print(Long.toBinaryString(l1)
                + " " + Long.toBinaryString(l2));
    }

    /**
     * practice 9
     * des: 分别用float与double指数计数法所能表示的最大与最小值
     */
    @Test
    public void f9(){
        System.out.println(Float.MAX_VALUE + "\n" + Float.MIN_VALUE + "\n" + Double.MAX_VALUE + "\n" + Double.MIN_VALUE);
    }

    /**
     * practice 10
     * des: 交替二进制的位运算操作结果
     */
    @Test
    public void f10(){
        Integer i1 = 0b010101;
        Integer i2 = 0b101010;
        print(Integer.toBinaryString(i1 | i2));
        print(Integer.toBinaryString(i1 & i2));
        print(Integer.toBinaryString(i1 ^ i2));
    }

    /**
     * practice 11,12,13
     * des1: 对一个最高位为1的二进制数右移，直到为0
     * des2: 对一个所有二进制位都为1的数左移，再无符号右移,直到为0
     * des3: 显示char的二进制
     */
    @Test
    public void f11(){
        Integer i1 = 0b1000;
        while(i1 !=0){
            i1 >>= 1;
            print(Integer.toBinaryString(i1));
        }
    }

    @Test
    public void f12(){
        Integer i = 0b111111;
        i <<= 1;
        while(i != 0){
            i >>>= 1;
            print(Integer.toBinaryString(i));
        }
    }

    @Test
    public void f13(){
        char c = 'a';
        while(c < 'z'){
            print(Integer.toBinaryString(c));
            c += 1;
        }
    }

    /**
     * practice: 14
     * des: 编写一个接受两个字符串参数的方法，用各种布尔值比较关系比较两个字符串
     */
    public boolean cmp1(String s1,String s2){
        return s1.equals(s2);
    }
    public boolean cmp2(String s1,String s2){
        return s1 == s2;
    }
    @Test
    public void f14(){
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = s1;

        print(cmp1(s1,s2));
        print(cmp2(s1,s2));
        print(cmp1(s1,s3));
        print(cmp2(s1,s3));
    }
}
