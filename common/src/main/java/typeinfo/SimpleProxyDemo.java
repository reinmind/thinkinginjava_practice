package typeinfo;

/**
 * @author zx
 */
interface ProxyInterface{
    /**
     * doSomething
     */
    void doSomething();

    /**
     * doSomethingElse
     */
    void somethingElse(String arg);
}
class RealObject extends Counter implements ProxyInterface {

    @Override
    public void doSomething() {
        this.increase();
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        this.increase();
        System.out.println("do something else:" + arg);
    }
}

/**
 * 代理与客户端实现同样的服务端接口，代理可以帮助你去做要求的事以及需求变更后的操作
 */
class SimpleProxy extends Counter implements ProxyInterface{
    private ProxyInterface client;
    public SimpleProxy(ProxyInterface client){
        this.client = client;
    }
    @Override
    public void doSomething() {
        this.increase();
        System.out.println("Simple proxy do something.");
        client.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        this.increase();
        System.out.println("simple proxy something else:" + arg);
        client.somethingElse(arg);
    }
}

/**
 * @author zx
 */
public class SimpleProxyDemo {
    public static void consumer(ProxyInterface client){
        client.doSomething();
        client.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        SimpleProxy simpleProxy = new SimpleProxy(realObject);
        //consumer(realObject);
        consumer(simpleProxy);
        System.out.println(realObject.getClass() + ":" + RealObject.getCount());
        System.out.println(simpleProxy.getClass() + ":" + SimpleProxy.getCount());
    }
}
