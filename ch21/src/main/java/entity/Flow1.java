package entity;

/**
 * @author zx
 */
public class Flow1 implements Runnable{

    public Flow1(){
        System.out.println("Flow1 started.");
    }
    @Override
    public void run() {

        System.out.println(this + " is running.");
        Thread.yield();

        System.out.println(this + " is running.");
        Thread.yield();

        System.out.println(this + " is running.");
        Thread.yield();

        System.out.println("Flow1 is ended.");

        return;
    }


}
