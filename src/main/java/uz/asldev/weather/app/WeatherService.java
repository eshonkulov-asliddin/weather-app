    package uz.asldev.weather.app;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.HttpClientErrorException;
    import org.springframework.web.client.RestTemplate;
    import uz.asldev.weather.app.entities.WeatherResponse;

    @Service
    public class WeatherService {

        @Value("${weather.api.key}")
        private String apiKey;

        @Value("${weather.api.url}")
        private String apiUrl;

        @Autowired
        private RestTemplate restTemplate;

        public WeatherResponse getWeatherData(String cityOrZipCode) {
            String url = String.format("%s?q=%s&key=%s", apiUrl, cityOrZipCode, apiKey);

            WeatherResponse result = null;

            try {
                result = restTemplate.getForObject(url, WeatherResponse.class);
            } catch(HttpClientErrorException ex) {
                // handle exceptions related to HTTP. For example, 404 not found
                System.out.println("City not found: " + cityOrZipCode);
            } catch(Exception ex) {
                // generic exception handler
                System.out.println("An error occurred while fetching weather data.");
            }

            return result;
        }
    }
