import java.util.concurrent.Callable;

import static utils.Print.print;

/**
 * @author zx
 */
public class Fibonacci2 implements Callable<Integer> {

    int n;
    @Override
    public Integer call() throws Exception {
        int j1 = 1;
        int j2 = 1;
        print(j1);
        print(j2);
        int z;

        for(int i = 1;i < n; ++i){
            z = j1;
            j1 = j2;
            j2 += z;
            print(j2);
        }

        return j2 * 2;
    }

    public Fibonacci2(int n){
        this.n = n;
    }
}
