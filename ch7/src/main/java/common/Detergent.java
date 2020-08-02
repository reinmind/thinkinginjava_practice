package common;

public class Detergent extends Cleanser{

    @Override
    public String toString() {
        return super.toString();
    }

    public void detergent(){append(" detergent()");}

    public Detergent(){
        //父类的构造器必须在第一行声明，这保证了有且只有一个构造器，而且执行初始化操作
        super();

    }
}
