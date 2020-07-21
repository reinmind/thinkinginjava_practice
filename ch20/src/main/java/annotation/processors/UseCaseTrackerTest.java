package annotation.processors;

import annotation.UseCase;
import utils.PasswordUtil;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * loc 20.1
 * @author zx
 *
 */

public class UseCaseTrackerTest {


    public void trackUseCases(List<Integer> useCases, Class<?> cl){
        Class<?> cls = UseCase.class;
        System.out.println("isAnnotation:"+cls.isAnnotation());
        System.out.println("UseCase,isAnnotationPresent:"+cls.isAnnotationPresent(UseCase.class));
        for(Method m: cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found use case:" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }

        }
        for(int i: useCases){
            System.out.println("Warning: Missing use case - " + i);
        }
    }

    @Test
    public void test(){
        List<Integer> useCases = new ArrayList<>();
        for(int i = 0;i < 100; ++i) {
            useCases.add(i);
        }
        trackUseCases(useCases, PasswordUtil.class);
    }
}
