import common.MovieGenerator;
import org.junit.Test;

import java.util.*;

/**
 * @author zx
 */
public class Main {
    /**
     * practice 1
     * 创建一个新类Gerbil，包含int gerbilNumber，在构造器中初始化它。添加一个方法hop(),用于打印它的号码以及正在跳跃的信息
     */
    @Test
    public void f1(){

    }
    /**
     * practice 4
     * 创建一个生成器类，它可以在每次调用next（）方法时，产生你由你最喜欢的电影构成的名字。在字符列表中的电影名
     * 用完之后，循环到这个字符的开始处。使用这个生成器来填充数组，ArrayList,
     * LinkedList,HashSet,LinkedHashSet和TreeSet，然后打印每一个容器
     */
    @Test
    public void f4(){
       Collection<String> collection = null;
       //ArrayList
        collection = new ArrayList<>();
        addAndPrint(collection);
        //LinkedList
        collection = new LinkedList<>();
        addAndPrint(collection);
        //HashSet
        collection = new HashSet<>();
        addAndPrint(collection);
        //LinkedHashSet
        collection = new LinkedHashSet<>();
        addAndPrint(collection);
        //TreeSet
        collection = new TreeSet<>();
        addAndPrint(collection);
    }
    private void addAndPrint(Collection<String> collection){
        addToCollection(collection);
        printCollection(collection);
    }
    public void addToCollection(Collection<? super String> collection){
        for(int i = 0;i < 10; ++i){
            collection.add(MovieGenerator.next());
        }
    }

    public void printCollection(Collection<? extends Object> collection){
        System.out.println(collection.getClass().getSimpleName() + ":" + collection);
    }

    /**
     * practice 5
     *
     */

}
