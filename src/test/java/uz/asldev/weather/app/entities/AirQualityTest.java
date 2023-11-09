package uz.asldev.weather.app.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirQualityTest {

    private static final double CO = 0.12;
    private static final double NO2 = 0.34;
    private static final double O3 = 0.56;
    private static final double SO2 = 0.78;
    private static final double PM25 = 1.23;
    private static final double PM10 = 4.56;
    private static final int USA_EPA_INDEX = 4;
    private static final int GB_DEFRA_INDEX = 8;
    private static final double CO_PARAMS = 0.21;
    private static final double NO2_PARAMS = 0.43;
    private static final double O3_PARAMS = 0.65;
    private static final double SO2_PARAMS = 0.87;
    private static final double PM25_PARAMS = 3.21;
    private static final double PM10_PARAMS = 6.54;
    private static final int USA_EPA_INDEX_PARAMS = 7;
    private static final int GB_DEFRA_INDEX_PARAMS = 3;

    @Test
    void testAirQuality() {
        AirQuality airQuality = new AirQuality();
        airQuality.setCo(CO);
        airQuality.setNo2(NO2);
        airQuality.setO3(O3);
        airQuality.setSo2(SO2);
        airQuality.setPm25(PM25);
        airQuality.setPm10(PM10);
        airQuality.setUsEpaIndex(USA_EPA_INDEX);
        airQuality.setGbDefraIndex(GB_DEFRA_INDEX);

        assertEquals(CO, airQuality.getCo());
        assertEquals(NO2, airQuality.getNo2());
        assertEquals(O3, airQuality.getO3());
        assertEquals(SO2, airQuality.getSo2());
        assertEquals(PM25, airQuality.getPm25());
        assertEquals(PM10, airQuality.getPm10());
        assertEquals(USA_EPA_INDEX, airQuality.getUsEpaIndex());
        assertEquals(GB_DEFRA_INDEX, airQuality.getGbDefraIndex());

        AirQuality airQualityParams = new AirQuality(CO_PARAMS, NO2_PARAMS, O3_PARAMS, SO2_PARAMS, PM25_PARAMS, PM10_PARAMS, USA_EPA_INDEX_PARAMS, GB_DEFRA_INDEX_PARAMS);

        assertEquals(CO_PARAMS, airQualityParams.getCo());
        assertEquals(NO2_PARAMS, airQualityParams.getNo2());
        assertEquals(O3_PARAMS, airQualityParams.getO3());
        assertEquals(SO2_PARAMS, airQualityParams.getSo2());
        assertEquals(PM25_PARAMS, airQualityParams.getPm25());
        assertEquals(PM10_PARAMS, airQualityParams.getPm10());
        assertEquals(USA_EPA_INDEX_PARAMS, airQualityParams.getUsEpaIndex());
        assertEquals(GB_DEFRA_INDEX_PARAMS, airQualityParams.getGbDefraIndex());
    }
}