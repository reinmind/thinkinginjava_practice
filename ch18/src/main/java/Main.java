import io.DirList;
import io.IOTest;
import org.junit.Test;

import java.io.IOException;

public class Main {

    /**
     * practice 1
     * des: 修改DirList.java（或其变体之一），以便FilenameFilter能够打开每个文件（使用net.mindview.util.TextFile工具）
     * 并检查命令行尾随的参数是否存在于那个文件中，以此检查结果来决定是否接受这个文件
     */
     @Test
     public void f1(){
         DirList dirList = new DirList();
         dirList.m("E:*");
     }

    /**
     * practice 7
     * des: 打开一个文本文件，每次读取一行内容，将每行作为一个String读入，并将那个String对象置入LinkedList当中，按相反的顺序
     * LinkedList中所有的行
     */
    @Test
    public void f7(){
        //实现
        //common.io.IOTest.main()
    }

    /**
     * 2020/7/29 今晚打开LeetCode，看了一下阿里的虚拟比赛，
     * 发现自己自从大一在北大参加过Java的比赛之后就没怎么用过Java了，流也不会用了，字符串也不会处理了
     * 罪过罪过
     * practice: 22
     * des: 修改OSExecutor.java，使其不打印标准输出流，而是以List或多个String的方法返回程序的执行结果
     */
    public void f22(){

    }



}
