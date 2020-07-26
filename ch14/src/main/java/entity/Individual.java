package entity;

/**
 * @author zx
 */
public class Individual {
    String name;
    public Individual(String name){
        this.name = name;
    }
    public Individual(){}

    @Override
    public String toString() {
        return "Individual{" +
                "name='" + name + '\'' +
                '}';
    }
}
