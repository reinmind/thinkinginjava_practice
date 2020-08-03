package common;

/**
 * @author zx
 * 将该类适配Apply.process(Process p,Object s)
 */
public class SwapString {
    public String swap(String str){
        char[] s = str.toCharArray();
        for(int i = 0;i < str.length() -1; ++i){
            char x = s[i];
            s[i] = s[i+1];
            s[i+1] = x;
        }
        return  new String(s);
    }

}
