package BigTask;

public class Orange extends Fruit {
    private float weight;

    public Orange() {
        this.weight = 1.5f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
