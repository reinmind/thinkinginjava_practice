import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @author zx
 */
public class EquationSolution {
    /**
     * 纯粹是为了解一个方程而写的类
     * x^3 - 12x + 8 = 0;
     * 已知x在区间[0,2]之间单调递减,求x的值，精确度为保留小数点后五位
     */

    public static double may = 1.0;
    public static void main(String[] args) {
        EquationSolution equationSolution = new EquationSolution();
        String solution = "";
        try {
            solution = equationSolution.encode("73.25%");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("solution:" + solution);
        //System.out.println(1e1);
    }

    public void f(double a,double b){
        Double mid = (a + b) / 2;
        Double mid_val = get_val(mid);
        Double mid_abs = Math.abs(mid_val + 8);
        if( mid_abs < 1.0E-6) {
            may = mid;
            return ;
        }
        if(mid_val < -8){
            f(a,mid);
        }
        else{
            f(mid,b);
        }
        return ;
    }

    public double get_val(double x){
        return Math.pow(x,3) - 12 * x;
    }

    public String encode(String ori) throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastlePQCProvider());
        MessageDigest messageDigest = MessageDigest.getInstance("MD2");
        for(int i = 0;i < 1e8; ++i){
            if(i % 1e6 == 0) System.out.println(ori);
            byte[] digest = messageDigest.digest(ori.getBytes());
            ori = new String(Hex.encode(digest));
        }
        return ori;
    }

}
