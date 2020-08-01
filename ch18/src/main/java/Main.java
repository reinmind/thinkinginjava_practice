import io.DirList;
import io.RaspberryPi;
import network.InetAddrTest;
import network.socket.SocketTest;
import org.junit.Test;

import java.net.UnknownHostException;

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

    /**
     * practice 27
     * 创建一个Serializable类，它包含一个对第二个Serializable类的对象的引用。创建你的类的实例，
     * 将其序列化到硬盘上，然后恢复它，并验证这个过程
     * 可以正常地工作
     *
     * 本例制造了一个树莓派对象，包含两个field，Ip和Mac，toString()方法打印出相关信息
     * 即使成员没有实现序列化的接口同样可以获取对象
     */
    @Test
    public void f27(){
        RaspberryPi raspberryPi = new RaspberryPi("192.168.30.41","e8:61:64:51:f4:ca");
        System.out.println("save object raspberrypi:" + raspberryPi);

        raspberryPi.save();

        RaspberryPi restored = RaspberryPi.restore(raspberryPi.getClass().getSimpleName());

        System.out.println("restore object raspberrypi:" + restored);
        System.out.println("getPiIPAddress:" + restored.getIPAddress());
        System.out.println("getAuth:"+restored.getAuth());
    }

    /**
     * 下面是一个我为了测试网络序列化而编写的socket例子
     */
    @Test
    public void socketTest(){
        SocketTest.telnet("localhost",8189);
    }

    /**
     * 通过域名找IP
     */
    @Test
    public void getIP(){
        try {
            for(String str: InetAddrTest.getHostIPs("www.taobao.com")){
                System.out.println(str);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
