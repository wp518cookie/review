package dp.decorator;

/**
 * Created by Administrator on 2018/4/11.
 */
public class DoubleMilk implements Coffee {
    private Coffee coffee;

    public DoubleMilk(Coffee coffee) {
        this.coffee = coffee;
    }

    public float fee() {
        return coffee.fee() + 1f;
    }
}
