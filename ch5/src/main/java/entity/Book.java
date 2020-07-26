package entity;
import static utils.Print.*;

/**
 * @author zx
 */
public class Book {
    boolean tag;
    public Book(boolean tag){
        this.tag = tag;
    }

    @Override
    protected void finalize(){
        if(tag){
            print("Book finalized!");
        }
    }
}
