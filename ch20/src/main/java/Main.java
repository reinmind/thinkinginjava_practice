import annotation.database.processor.TableCreator;
import org.junit.Test;

/**
 * @author zx
 */
public class Main {
    /**
     * practice 1
     * des: 为本节的数据库例子实现更多的SQL类型
     */
     @Test
     public void f1(){
         TableCreator tableCreator = new TableCreator();
         System.out.println(tableCreator.createTable("annotation.database.Member"));
     }

}
