import common.InfiniteRecursion;
import org.junit.Test;

import java.util.Formatter;

/**
 * @author zx
 */
public class Main {
    /**
     * 众所周知，字符串很常用是废话
     */

    /**
     * practice 1
     * des: 明确地使用StringBuilder是否可以避免产生过多的对象
     */


    /**
     * practice 2
     * des: 修复InfiniteRecursion.java
     *
     * Error:stackoverflow 避免在toString里面使用this返回类名，造成递归调用toString而不会停止
     */
    @Test
    public void f2(){
        InfiniteRecursion infiniteRecursion = new InfiniteRecursion();
        System.out.println(infiniteRecursion);
    }

    /**
     * practice 3
     * des: 修改turtle.java，使之将结果输出到System.err中
     *
     * 只要将文件中的System.out流改为System.err即可
     */

    /**
     * 格式化输出
     * 1.printf
     * 2.System.out.format()
     * 3.Formatter(翻译器),含有一个format成员，按照构造器给的OutputStream进行输出
     */

    /**
     * practice 4
     * 修改Receipt.java，令所有的宽度都由一个常量来控制。目的是使宽度的改变更容易
     */
    public void f4(int ident,String s1,String s2){
        Formatter formatter = new Formatter(System.out);
        StringBuilder pattern = new StringBuilder();
        pattern.append("%-");
        pattern.append(ident);
        pattern.append("s " + "%-"+ ident * 2 +"s\n");
        //输出函数
        formatter.format(pattern.toString(),s1,s2);
    }

    @Test
    public void f44(){
        f4(15,"hello","world");
        f4(15,"Formatter","Detected");
    }

    /**
     * practice 5
     * 针对前边表格的各种基本类型转化，利用所有可能的修饰符，
     * 写成一个尽肯能复杂的表达式
     */

    /**
     * practice 6
     * 创建一个包含int，long，float与double元素的类，
     * 应用String.format()方法为这个类编写toString()，
     * 并证明它能正确工作
     *
     * String.format()能够按照给定格式对数据进行格式化
     */

    class F6{
        private int a;
        private long b;
        private float c;
        private double d;
        public F6(int a,long b,float c,double d){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        @Override
        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format(" %04x",a));
            stringBuilder.append(String.format(" %08d",b));
            stringBuilder.append(String.format(" %2.1f",c));
            stringBuilder.append(String.format(" %2.1e",d));
            return stringBuilder.toString();
        }
    }

    @Test
    public void f6(){
        F6 o = new F6(1,234567858575688L,3.1234f,3.141592653748d);
        System.out.println(o);
    }

    /**
     * 正则表达式
     * 可能有一个负号，后面跟着一个或者多个数字
     * "-1234"。matches("-?\\d+"); true
     * "5678".matches("-?\\d+"); true
     */
    /**
     * 正则表达式工具split(regex)
     * 与正则表达式相匹配的regex在最终的字符都不存在了
     * W+表示一个或多个非单词字符
     *
     * split()限制字符串的分割次数
     */

    /**
     * practice 7
     * 请参考java.util.regex.Pattern的文档，编写一个正则表达式，检查一个句子是否以大写字母开头，以句号结尾
     */
    @Test
    public void f7(){
        String sentence = "This is a tree.";
        String sentence2 = "This is a tree";
        String sentence3 = "this is a tree.";
        String regex = "[A-Z][^\\.]+\\.";
        System.out.println(sentence.matches(regex));
        System.out.println(sentence2.matches(regex));
        System.out.println(sentence3.matches(regex));
    }

    public static String knights = "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest..." +
            "with... a herring";

    /**
     * practice 8
     * 将字符串Splitting.knights在the和you处分割
     */
    @Test
    public void f8(){
        String regex = "(the)|(you)";
        String[] strings = knights.split(regex);
        for(String str:strings){
            System.out.println(str);
        }
    }

    /**
     * practice 9
     * 参考java.util.regex.Pattern的文档，用下划线替换Splitting.knights中的所有元音字母
     */
    @Test
    public void f9(){
        String regex = "[aeiouAEIOU]";
        String knights_new = knights.replaceAll(regex,"_");
        System.out.println(knights_new);
    }
    /**
     * 正则表达式的创建
     * 逻辑操作符，字符类
     * 量词：贪婪型，懒汉型，占有型
     * Pattern
     * Matcher
     */
    /**
     * practice 10
     * 对字符串验证下列正则表达式是否能够发现一个匹配
     * ^Java
     * \Breg.*
     * n.w\s+h(a|i)s
     * s?
     * s+
     * s{4}
     * s{1}
     * s{0,3}
     */

}
