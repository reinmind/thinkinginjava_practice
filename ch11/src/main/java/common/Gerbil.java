package common;

/**
 * @author zx
 */
public class Gerbil {
    private int gerbilNumber = 0;
    private static int count = 0;
    public Gerbil(){
        ++count;
        gerbilNumber = count;
    }

    public void hop(){
        System.out.println("Gerbil " + gerbilNumber + " is jumping.");
    }
}
