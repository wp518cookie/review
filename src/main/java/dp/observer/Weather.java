package dp.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
public class Weather {
    private static final Logger log = LoggerFactory.getLogger(Weather.class);
    private WeatherType currentWeather;
    private List<WeatherObserver> observers;

    public Weather() {
        observers = new ArrayList();
        currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(WeatherObserver obs) {
        observers.remove(obs);
    }

    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        log.info("The weather changed to {}.", currentWeather);
        notifyObservers();
    }

    public void notifyObservers() {
        for (WeatherObserver obs : observers) {
            obs.update(currentWeather);
        }
    }
}
