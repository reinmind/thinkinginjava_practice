package common;

import sun.awt.windows.WPrinterJob;

/**
 * @author zx
 */
public class Tank {
    String status;
    public Tank(String status){
        this.status = status;
    }

    @Override
    protected void finalize(){
        if("empty".equals(status)){
            System.out.println("execute clean");
        }
    }
}
