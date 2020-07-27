package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() +
                ".\nmethod: " + method + ".\nargs: " + args);
        Class<? extends ProxyInterface> cls = (Class<? extends ProxyInterface>) proxy.getClass();
        System.out.println("proxy name:" + cls.getSimpleName());
        System.out.println("proxy methods:" + cls.getDeclaredMethods());
        if(null != args){
            for (Object o: args){
                System.out.println("agent method:" + o);
            }
        }
        return method.invoke(proxied, args);
    }
}
/**
 * @author zx
 */
public class SimpleDynamicProxy {
    public static void consumer(ProxyInterface client){
        client.doSomething();
        client.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        //consumer(realObject);
        ProxyInterface agent = (ProxyInterface) Proxy.newProxyInstance(
                //classLoader
                ProxyInterface.class.getClassLoader(),
                //interfaces
                new Class[]{ ProxyInterface.class},
                //invocationHandler
                new DynamicProxyHandler(realObject));
        consumer(agent);
    }
}
