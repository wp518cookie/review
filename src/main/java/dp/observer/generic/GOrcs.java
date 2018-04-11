package dp.observer.generic;

import dp.observer.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/4/11.
 */
public class GOrcs implements Race {
    private static final Logger log = LoggerFactory.getLogger(GOrcs.class);

    public void update(GWeather weather, WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                log.info("The orcs are freezing cold.");
                break;
            case RAINY:
                log.info("Thre orcs are dripping wet.");
                break;
            case SUNNY:
                log.info("The sun hurts the orcs' eyes.");
                break;
            case WINDY:
                log.info("The orc smell almost vanishes in the wind.");
                break;
            default:
                break;
        }
    }
}
