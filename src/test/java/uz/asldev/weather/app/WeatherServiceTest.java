package uz.asldev.weather.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import uz.asldev.weather.app.entities.WeatherResponse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherService weatherService;

    private final String CITY_NAME = "Tashkent";

    @Test
    void getWeatherData_success() {
        WeatherResponse mockResponse = new WeatherResponse();

        when(restTemplate.getForObject(anyString(),eq(WeatherResponse.class))).thenReturn(mockResponse);

        WeatherResponse actualResponse = weatherService.getWeatherData(CITY_NAME);

        assertEquals(mockResponse, actualResponse);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(WeatherResponse.class));

    }

    @Test
    void getWeatherData_cityNotFound() {
        when(restTemplate.getForObject(anyString(),eq(WeatherResponse.class)))
                .thenThrow(HttpClientErrorException.create(HttpStatusCode.valueOf(404), "Not Found", null, null, null));

        WeatherResponse actualResponse = weatherService.getWeatherData(CITY_NAME);

        assertNull(actualResponse);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(WeatherResponse.class));

    }

    @Test
    void getWeatherData_generalError() {
        when(restTemplate.getForObject(anyString(),eq(WeatherResponse.class)))
                .thenThrow(new RuntimeException("something went wrong"));

        WeatherResponse actualResponse = weatherService.getWeatherData(CITY_NAME);

        assertNull(actualResponse);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(WeatherResponse.class));
    }
}