/**
 * @author zx
 */
import static utils.Print.*;
public class Fibonacci implements Runnable{
    int n;
    @Override
    public void run() {
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
    }
    public Fibonacci(int n){
        this.n = n;
    }
}
