package dp.template_method;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/11.
 */
public abstract class Drink {
    public void drink() {
        blowingWater();
        prepareForDrink();
        pourInCup();
    }

    public void blowingWater() {
        System.out.println("blowing water");
    }

    public abstract void prepareForDrink();

    public void pourInCup() {
        System.out.println("pourInCup");
    }

    public static void main(String[] args) throws Exception {
        new Coffee().drink();
        new Tea().drink();
    }
}
