package common;

public interface Instrument {
    //默认域的属性是static final
    String id = "0";
    //默认方法的属性是public
    void play();
    String what();
    void adjust();
}
