package dp.decorator;

/**
 * Created by Administrator on 2018/4/11.
 */
public class Bubble implements Coffee {
    private Coffee coffee;

    public Bubble(Coffee coffee) {
        this.coffee = coffee;
    }

    public float fee() {
        return coffee.fee() + 1;
    }
}
