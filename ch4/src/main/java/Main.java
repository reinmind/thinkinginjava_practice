import org.junit.Test;

import java.util.Random;

import static utils.Print.*;
public class Main {
    /**
     * practice 1
     * des: 写一个程序，打印从1-100的值
     */
    @Test
    public void f1(){
        int i = 0;
        while(i < 100){
            ++i;
            print(i);
        }
    }

    /**
     * practice 2
     * des: 产生25个随机int，用if-else结构表示其与后生成数的大小关系
     */
    @Test
    public void f2(){
        Random rand = new Random(45);
        int x = rand.nextInt();
        String op = "=";
        for(int i = 0;i < 25; ++i){
            int y = rand.nextInt();
            if(x < y){
                op = "<";
            }
            else if(x > y){
                op = ">";
            }
            print(i + ": " + x + op + y);
        }
    }

    /**
     * practice 3
     * des: 把practice 2改成用while
     */
    @Test
    public void f3(){
        Random rand = new Random(45);
        int x = rand.nextInt();
        String op = "=";
        int i = 0;
        while(i < 100){
            ++i;
            int y = rand.nextInt();
            if(x < y){
                op = "<";
            }
            else if(x > y){
                op = ">";
            }
            print(i + ": " + x + op + y);
        }
    }
    /**
     * practice 4
     * des: 用for循环和%探测素数
     *
     * 按照要求的时间复杂度只能为o(n^2)
     */
    static boolean x[] = new boolean[100000];
    @Test
    public void f4(){
        find_prime();
        for(int i = 2;i < 100000; ++i){
            if(!x[i])
            print(i);
        }
    }

    public void find_prime(){
        for(int i = 2;i <= Math.sqrt(100000) ; ++i){
            for(int j = i; j < 100000 ; ++j){
                int y = i * j;
                if(y < 100000)
                    x[y] = true;
            }
        }
    }

    /**
     * practice 5
     * des: 使用三元操作符,按位操作符完成3.10
     */
    @Test
    public void f5(){

    }
}
