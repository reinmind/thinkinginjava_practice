package debug;

public class PrintSub extends Print{

    PrintSub(){
        //即使是子类也不能使用父类的方法
        //System.out.println(super.pri());
    }
}
