import org.junit.Test;

import java.util.*;

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
    static boolean[] x = new boolean[100000];
    @Test
    public void f4(){
        find_prime();
        for(int i = 2;i < 100000; ++i){
            if(!x[i]) {
                print(i);
            }
        }
    }

    public void find_prime(){
        for(int i = 2;i <= Math.sqrt(100000) ; ++i){
            for(int j = i; j < 100000 ; ++j){
                int y = i * j;
                if(y < 100000) {
                    x[y] = true;
                }
            }
        }
    }

    /**
     * practice 5
     * des: 使用三元操作符,按位操作符完成3.10
     */
    @Test
    public void f5(){
        Integer i1 = 0b010101;
        Integer i2 = 0b101010;
        print(toBinString(i1 | i2));
        print(toBinString(i1 & i2));
        print(toBinString(i1 ^ i2));
    }

    public String toBinString(Integer i){
        StringBuilder sb = new StringBuilder();
        Integer j = 0b100000;
        while(j != 0){
            char x = (i & j) != 0?'1':'0';
            sb.append(x);
            j >>= 1;
        }
        return sb.toString();
    }

    /**
     * practice 6
     * des: 一个接收testval,begin,end的参数
     */
     @Test
     public void f6(){
        print(ftest(1,5,10));
        print(ftest(6,5,10));
     }
     public boolean ftest(int testval,int begin,int end){
         return testval >= begin && testval <= end;
     }
     /**
      * practice 7
      * des: 改写f1，在99的时候用break或者return退出
      */
      @Test
      public void f7(){
          int i = 0;
          while(i < 100){
              if(i == 99) {
                  return;
              }
              ++i;
              print(i);
          }
      }

      /**
       * practice 8
       * des:
       */
       @Test
       public void f8(){
           //case1();
           case2();
       }

       public void case1(){
           for(int i = 0;i < 10; ++i){
               switch(i){
                   case 0: print("case 0"); break;
                   case 1: print("case 1"); break;
                   case 2: print("case 2"); break;
                   case 3: print("case 3"); break;
                   case 4: print("case 4"); break;
                   case 5: print("case 5"); break;
                   case 6: print("case 6"); break;
                   case 7: print("case 7"); break;
                   case 8: print("case 8"); break;
                   case 9: print("case 9"); break;
               }
           }
       }

       public void case2(){
           for(int i = 0;i < 10; ++i){
               switch(i){
                   case 0: print("case 0");
                   case 1: print("case 1");
                   case 2: print("case 2");
                   case 3: print("case 3");
                   case 4: print("case 4");
                   case 5: print("case 5");
                   case 6: print("case 6");
                   case 7: print("case 7");
                   case 8: print("case 8");
                   case 9: print("case 9");
               }
           }
       }

       /**
        * practice 9
        * des: 斐波那契数列
        */
       @Test
       public void t9(){
           f9(5);
       }
       public void f9(int k){
            int j1 = 1;
            int j2 = 1;
            print(j1);
            print(j2);
            int z;
            for(int i = 1;i < k; ++i){
                z = j1;
                j1 = j2;
                j2 += z;
                print(j2);
            }
        }

        /**
         * practice 10
         * des: 找出4位数当中的吸血鬼数字（末尾不能为两个0）
         */
         @Test
         public void f10(){
            for(int a = 0;a < 10; ++a){
                for(int b = 0;b < 10; ++b){
                    for(int c = 0; c < 10; ++c){
                        for(int d = 0;d < 10; ++d){
                            int mul1 = a * 10 + b;
                            int mul2 = c * 10 + d;
                            if(isVampire(a,b,c,d,mul1,mul2)){
                                print(a + "" + b + "" + c + " " + d + " result:" + mul1 * mul2);
                            }
                        }
                    }
                }
            }
         }

         boolean isVampire(int a,int b,int c,int d,int mul1,int mul2){
            int res = mul1 * mul2;
            if(res <= 999 || res > 9999){
                return false;
            }
            if(res % 100 == 0){
                return false;
            }
             List<Integer> list = new ArrayList<>();
             list.add(a);
             list.add(b);
             list.add(c);
             list.add(d);
             Integer d1 = res % 10;
             res /= 10;
             Integer c1 = res % 10;
             res /= 10;
             Integer b1 = res % 10;
             res /= 10;
             Integer a1 = res;
             list.remove(a1);
             list.remove(b1);
             list.remove(c1);

             return list.isEmpty();
         }




}
