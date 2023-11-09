package uz.asldev.weather.app.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {

    private static final String NAME = "New York";
    private static final String REGION = "America";
    private static final String COUNTRY = "USA";
    private static final double LATITUDE = 40.7128;
    private static final double LONGITUDE = -74.0060;
    private static final String TZ_ID = "America/New_York";
    private static final long LOCAL_TIME_EPOCH = 16767688;
    private static final String LOCAL_TIME = "2024-03-23 18:34";

    @Test
    public void testGettersAndSetters() {
        Location location = new Location();

        location.setName(NAME);
        location.setRegion(REGION);
        location.setCountry(COUNTRY);
        location.setLat(LATITUDE);
        location.setLon(LONGITUDE);
        location.setTzId(TZ_ID);
        location.setLocaltimeEpoch(LOCAL_TIME_EPOCH);
        location.setLocaltime(LOCAL_TIME);

        assertEquals(NAME, location.getName());
        assertEquals(REGION, location.getRegion());
        assertEquals(COUNTRY, location.getCountry());
        assertEquals(LATITUDE, location.getLat());
        assertEquals(LONGITUDE, location.getLon());
        assertEquals(TZ_ID, location.getTzId());
        assertEquals(LOCAL_TIME_EPOCH, location.getLocaltimeEpoch());
        assertEquals(LOCAL_TIME, location.getLocaltime());

        Location locationParams = new Location(NAME, REGION, COUNTRY, LATITUDE, LONGITUDE, TZ_ID, LOCAL_TIME_EPOCH, LOCAL_TIME);

        assertEquals(NAME, locationParams.getName());
        assertEquals(REGION, locationParams.getRegion());
        assertEquals(COUNTRY, locationParams.getCountry());
        assertEquals(LATITUDE, locationParams.getLat());
        assertEquals(LONGITUDE, locationParams.getLon());
        assertEquals(TZ_ID, locationParams.getTzId());
        assertEquals(LOCAL_TIME_EPOCH, locationParams.getLocaltimeEpoch());
        assertEquals(LOCAL_TIME, locationParams.getLocaltime());
    }
}