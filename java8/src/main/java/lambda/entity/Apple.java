package lambda.entity;

public class Apple {
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private int weight;

    public Apple(int weight) {
        this.weight = weight;
    }
}
