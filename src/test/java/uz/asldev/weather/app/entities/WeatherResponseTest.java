package uz.asldev.weather.app.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherResponseTest {

    private static final Location LOCATION = new Location("New York", "USA", "New York", 40.7128, -74.0060, "America/New_York", 16767688, "2024-03-23 18:34");
    private static final Current CURRENT = new Current();

    @Test
    public void testGettersAndSetters() {
        WeatherResponse weatherResponse = new WeatherResponse();

        weatherResponse.setLocation(LOCATION);
        weatherResponse.setCurrent(CURRENT);

        assertEquals(LOCATION, weatherResponse.getLocation());
        assertEquals(CURRENT, weatherResponse.getCurrent());

        WeatherResponse weatherResponseParams = new WeatherResponse(LOCATION, CURRENT);

        assertEquals(LOCATION, weatherResponseParams.getLocation());
        assertEquals(CURRENT, weatherResponseParams.getCurrent());
    }
}