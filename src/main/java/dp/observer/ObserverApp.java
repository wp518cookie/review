package dp.observer;

/**
 * Created by Administrator on 2018/4/11.
 */
public class ObserverApp {
    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
    }
}
