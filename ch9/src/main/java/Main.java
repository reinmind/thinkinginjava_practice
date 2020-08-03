import common.Apply;
import common.Instrument;
import common.SwapString;
import common.adapter.SwapStringAdapter;
import common.impl.Stringed;
import org.junit.After;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zx
 */
public class Main {
    /**
     * practice 5
     * 在某个包内创建一个接口，内含三个方法，然后在另一个包当中实现此接口
     */
    @Test
    public void f5(){
        Stringed stringed = new Stringed(){

            @Override
            public void play() {
                System.out.println("Stringed playing");
            }
        };
        stringed.adjust();
    }
    /**
     * practice 6
     * 证明接口当中所有的方法都是public
     *
     * 通过反射获取到类当中的类信息就可以知道方法的签名
     */
    @Test
    public void f6(){
        Class<? extends Instrument > insCls = Instrument.class;
        for(Method f: insCls.getDeclaredMethods()){
            System.out.println(f);
        }
    }

    /**
     * practice 7
     * 修改第八章的练习9，使Rodent成为一个接口
     */
    @Test
    public void f7() {

    }

    /**
     * practice 11
     * 创建一个类，他有一个方法接受一个String类型的参数，生成的结果是将每一对字符进行互换，对该类进行适配，使得它可以用于interfaceProcess。Apply.process()
     */
    @Test
    public void f11() {
        Apply apply = new Apply();
        SwapStringAdapter swapStringAdapter = new SwapStringAdapter(new SwapString());
        apply.process(swapStringAdapter,"HelloWorld");
    }

    /**
     * practice 18
     * 创建一个Cycle接口以及Unicycle，Bicycle和Tricycle的实现，对每种类型的Cycle都创建相应的工厂，然后编写代码使用这些工厂
     */

    /**
     * practice 19
     * 使用工厂方法创建一个框架，他可以实现抛硬币和掷骰子的功能
     */
}
