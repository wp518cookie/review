package dp.observer.generic;

import dp.observer.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/4/11.
 */
public class GWeather extends Observable<GWeather, Race, WeatherType> {
    private static final Logger log = LoggerFactory.getLogger(GWeather.class);
    private WeatherType currentWeather;

    public GWeather() {
        currentWeather = WeatherType.SUNNY;
    }

    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        log.info("The weather changed to {}.", currentWeather);
        notifyObservers(currentWeather);
    }
}
