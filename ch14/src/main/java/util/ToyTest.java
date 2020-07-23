package util;

import org.junit.Test;

import static utils.Print.print;


/**
 * @author zx
 */
public class ToyTest {


    public void printInfo(Class cc) {
        print("class name:" + cc.getName());
        print("is Interface:" + cc.isInterface());
        print("simple name:" + cc.getSimpleName());
        print("canonical name:" + cc.getCanonicalName());
    }


    @Test
    public void testInfo() {
        Class c = null;
        try {
            c = Class.forName("common.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfo(c);
        for (Class inter : c.getInterfaces()) {
            printInfo(inter);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        printInfo(obj.getClass());
    }

}
