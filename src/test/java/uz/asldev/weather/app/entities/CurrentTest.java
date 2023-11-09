package uz.asldev.weather.app.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentTest {

    private static final long LAST_UPDATED_EPOCH = 1631575688L;
    private static final String LAST_UPDATED = "9/14/2021";
    private static final double TEMP_C = 22.6;
    private static final double TEMP_F = 72.6;
    private static final int IS_DAY = 1;
    private static final Condition CONDITION = new Condition("Sunny", "sun_icon", 1000);
    private static final double WIND_MPH = 10.0;
    private static final double WIND_KPH = 16.0;
    private static final int WIND_DEGREE = 320;
    private static final String WIND_DIR = "NW";
    private static final double PRESSURE_MB = 1010.0;
    private static final double PRESSURE_IN = 30.2;
    private static final double PRECIP_MM = 0.0;
    private static final double PRECIP_IN = 0.0;
    private static final int HUMIDITY = 56;
    private static final int CLOUD = 0;
    private static final double FEELS_LIKE_C = 20.6;
    private static final double FEELS_LIKE_F = 70.6;
    private static final int VIS_KM = 10;
    private static final int VIS_MILES = 6;
    private static final int UV = 7;
    private static final double GUST_MPH = 9.0;
    private static final double GUST_KPH = 14.0;
    private static final AirQuality AIR_QUALITY = new AirQuality();

    private Current current;

    @BeforeEach
    void setUp() {
        // Given
        current = new Current();
        current.setLastUpdatedEpoch(LAST_UPDATED_EPOCH);
        current.setLastUpdated(LAST_UPDATED);
        current.setTempC(TEMP_C);
        current.setTempF(TEMP_F);
        current.setIsDay(IS_DAY);
        current.setCondition(CONDITION);
        current.setWindMph(WIND_MPH);
        current.setWindKph(WIND_KPH);
        current.setWindDegree(WIND_DEGREE);
        current.setWindDir(WIND_DIR);
        current.setPressureMb(PRESSURE_MB);
        current.setPressureIn(PRESSURE_IN);
        current.setPrecipMm(PRECIP_MM);
        current.setPrecipIn(PRECIP_IN);
        current.setHumidity(HUMIDITY);
        current.setCloud(CLOUD);
        current.setFeelsLikeC(FEELS_LIKE_C);
        current.setFeelsLikeF(FEELS_LIKE_F);
        current.setVisKm(VIS_KM);
        current.setVisMiles(VIS_MILES);
        current.setUv(UV);
        current.setGustMph(GUST_MPH);
        current.setGustKph(GUST_KPH);
        current.setAirQuality(AIR_QUALITY);
    }

    @Test
    void testCurrentGettersSetters() {
        // Assert
        assertEquals(LAST_UPDATED_EPOCH, current.getLastUpdatedEpoch());
        assertEquals(LAST_UPDATED, current.getLastUpdated());
        assertEquals(TEMP_C, current.getTempC());
        assertEquals(TEMP_F, current.getTempF());
        assertEquals(IS_DAY, current.getIsDay());
        assertEquals(CONDITION.getText(), current.getCondition().getText());
        assertEquals(CONDITION.getIcon(), current.getCondition().getIcon());
        assertEquals(CONDITION.getCode(), current.getCondition().getCode());
        assertEquals(WIND_MPH, current.getWindMph());
        assertEquals(WIND_KPH, current.getWindKph());
        assertEquals(WIND_DEGREE, current.getWindDegree());
        assertEquals(WIND_DIR, current.getWindDir());
        assertEquals(PRESSURE_MB, current.getPressureMb());
        assertEquals(PRESSURE_IN, current.getPressureIn());
        assertEquals(PRECIP_MM, current.getPrecipMm());
        assertEquals(PRECIP_IN, current.getPrecipIn());
        assertEquals(HUMIDITY, current.getHumidity());
        assertEquals(CLOUD, current.getCloud());
        assertEquals(FEELS_LIKE_C, current.getFeelsLikeC());
        assertEquals(FEELS_LIKE_F, current.getFeelsLikeF());
        assertEquals(VIS_KM, current.getVisKm());
        assertEquals(VIS_MILES, current.getVisMiles());
        assertEquals(UV, current.getUv());
        assertEquals(GUST_MPH, current.getGustMph());
        assertEquals(GUST_KPH, current.getGustKph());
        assertEquals(AIR_QUALITY, current.getAirQuality());
    }
}
