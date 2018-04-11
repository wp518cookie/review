package dp.decorator;

/**
 * Created by Administrator on 2018/4/11.
 */
public class DecoratorApp {
    public static void main(String[] args) {
        System.out.println(new Bubble(new DoubleMilk(new Moka(new BasicCoffee()))).fee());
    }
}
