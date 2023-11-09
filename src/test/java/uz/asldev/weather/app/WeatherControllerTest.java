package uz.asldev.weather.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uz.asldev.weather.app.entities.WeatherResponse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    private MockMvc mockMvc;

    @Test
    void weatherForm() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("weatherForm"));
    }

    @Test
    void getWeather_withResult() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
        WeatherResponse mockResponse = new WeatherResponse();

        when(weatherService.getWeatherData(anyString())).thenReturn(mockResponse);

        mockMvc.perform(post("/weather")
                        .param("query", "some_query"))
                .andExpect(status().isOk())
                .andExpect(view().name("weatherResult"))
                .andExpect(model().attributeExists("weather"));
    }

    @Test
    void getWeather_withoutResult() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();

        when(weatherService.getWeatherData(anyString())).thenReturn(null);

        mockMvc.perform(post("/weather")
                        .param("query", "some_query"))
                .andExpect(status().isOk())
                .andExpect(view().name("404"));
    }
}