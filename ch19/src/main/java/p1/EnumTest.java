package p1;

/**
 * @author Jason
 * @date
 */
public class EnumTest {
    private enum Shruberry{GROUND,CRAWLING,HANGING};
    public static void main(String[] args) {
        for(Shruberry s: Shruberry.values()){
            System.out.println("ordinal:" + s.ordinal() + " name:" + s.name());
        }
        System.out.println(Shruberry.values());
    }
}
