package common;

/**
 * @author zx
 */
public class MovieGenerator {

    private static int i = 0;
    private static String[] movieNames;
    static{
        movieNames = new String[4];
        movieNames[0] = "Your Name";
        movieNames[1] = "Weather with you";
        movieNames[2] = "Godfather";
        movieNames[3] = "The Garden of Words";
    }

    public static String next(){
        return movieNames[i++ % 4];
    }
}
