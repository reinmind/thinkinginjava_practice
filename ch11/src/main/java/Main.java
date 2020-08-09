import common.Gerbil;
import common.MovieGenerator;
import container.collection.SimpleCollection;
import container.collection.list.ListFeature;
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
        List<Gerbil> gerbils = new ArrayList<>();
        for(int i = 0;i < 10; ++i){
            gerbils.add(new Gerbil());
        }
        for(int i = 9; i >= 0; --i){
            gerbils.get(i).hop();
        }
    }
    /**
     * practice 2
     * 修改SimpleCollection.java,使用Set来表示c
     */
    @Test
    public void f2(){
        SimpleCollection.main();
    }

    /**
     * practice 3
     * 修改innerclass/Sequence.java，使你可以向其中添加任意 数量的元素
     *
     * 内部类相关，暂时跳过
     */


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
     * 修改ListFeature.java,让它使用Integer，而不是Pet，并解释在结果上有何不同
     */
    @Test
    public void f5(){
        ListFeature<Integer> listFeature = new ListFeature<>();
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for(int i = 0;i < 10; ++i){
            arrayList.add(i);
            linkedList.add(i);
        }
        arrayList.remove(new Integer(7));
        linkedList.remove(new Integer(7));
        arrayList.add(11);
        linkedList.add(11);
        listFeature.setArrayList(arrayList);
        listFeature.setLinkedList(linkedList);
        System.out.println(listFeature.getArrayList());
        System.out.println(listFeature.getLinkedList());
    }
    /**
     * practice 6
     * 同上，改为String
     */
    @Test
    public void f6(){
        ListFeature<String> listFeature = new ListFeature<>();
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        for(String i = "0";i.length() < 10; i += "1"){
            arrayList.add(i);
            linkedList.add(i);
        }
        arrayList.remove("01");
        linkedList.remove("01");
        arrayList.add("11");
        linkedList.add("11");
        listFeature.setArrayList(arrayList);
        listFeature.setLinkedList(linkedList);
        System.out.println(listFeature.getArrayList());
        System.out.println(listFeature.getLinkedList());
    }

    /**
     * practice 7
     * 创建一个类，然后创建一个用你的类的对象进行初始化的数组，通过使用subList()的方法，创建你的List的子集，然后在你的List中移除这个子集
     */

}
