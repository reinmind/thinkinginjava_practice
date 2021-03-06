package lambda;

import lambda.entity.Apple;
import lambda.inter.AppleInter;
import org.junit.Test;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppleTest {
    static int count = 0;
    static Comparator<Apple> byWeight1 = new Comparator<Apple>() {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight() - o2.getWeight();
        }
    };

    static Comparator<Apple> byWeight2 = (Apple o1,Apple o2) -> o1.getWeight() - o2.getWeight();

    @Test
    public void t1(){
        AppleInter<Apple> ai = () -> 31;
        System.out.println(ai.f());
    }


    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(1));
        appleList.add(new Apple(3));
        appleList.add(new Apple(2));
        for(Apple a:appleList){
            System.out.println(a.getWeight());
        }
        System.out.println();
        appleList.sort(byWeight2);
        for(Apple a:appleList){
            System.out.println(a.getWeight());
        }
    }
    private void f0(){
        System.out.println("helloworld");
    }
    private int fx(){
        return ++count;
    }

    private void info(AppleInter appleInter){
        System.out.println(appleInter.f());
    }

    @Test
    public void f2(){
        //new Thread(this::f0).run();
        //new Thread(this::f0).run();
        this.info(this::fx);
        this.info(this::fx);
        this.info(this::fx);
        this.info(this::fx);
    }
}
