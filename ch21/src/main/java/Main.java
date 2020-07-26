import entity.Flow1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zx
 */
public class Main {
    /**
     * 线程还没有被执行完就终止了
     * practice 1
     * des: 实现一个Runnable，并且在run中打印一条消息，然后调用yield，重复三次, 并且创建多个线程任务
     */

    public static void f1() {
        for (int i = 0; i < 5; ++i) {
            new Thread(new Flow1()).start();
        }
    }

    /**
     * practice 2
     * des: 产生由n个斐波那契数列组成的序列，其中n是通过任务的构造器提供的，使用线程创建大量这种任务并驱动他们
     */
    @Test
    public void f2() {
        for (int i = 0; i < 10; ++i) {
            new Thread(new Fibonacci(10)).start();
        }
    }

    /**
     * practice 3
     * des: 使用本节展示的各种不同类型的执行器重复练习1
     */
    @Test
    public void f3() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; ++i) {
            executorService.execute(new Flow1());
        }
        executorService.shutdown();
    }

    /**
     * practice 4
     * des: 使用本节展示的各种不同类型的执行器重复练习2
     */
    @Test
    public void f4() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; ++i) {
            executorService.execute(new Fibonacci(10));
        }
        executorService.shutdown();
    }

    /**
     * practice 5
     * des: 修改练习2，使得计算结果所有斐波那契数列的数值总和的任务成为callable。创建多个任务并显示结果
     */
    @Test
    public void f5() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> arrayList = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 10; ++i) {
            arrayList.add(executorService.submit(new Fibonacci2(3)));
        }
        for(Future<Integer> f: arrayList){
            try {
                System.out.println("sum:" + f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Main m = new Main();
        //f1();
        //m.f2();
        m.f5();
    }

}
