package dp.observer;

/**
 * Created by Administrator on 2018/4/11.
 */
public enum WeatherType {
    SUNNY, RAINY, WINDY, COLD;

    public String toString() {
        return this.name().toLowerCase();
    }
}
