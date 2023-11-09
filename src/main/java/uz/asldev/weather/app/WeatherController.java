package uz.asldev.weather.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uz.asldev.weather.app.entities.WeatherResponse;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public ModelAndView weatherForm() {
        return new ModelAndView("weatherForm");
    }

    @PostMapping("/weather")
    public ModelAndView getWeather(@RequestParam String query) {
        ModelAndView modelAndView;
        WeatherResponse weather = weatherService.getWeatherData(query);
        if (weather == null){
            modelAndView = new ModelAndView("404");
        }else{
            modelAndView = new ModelAndView("weatherResult");  //Redirect to weatherResult.html page
            modelAndView.addObject("weather", weather);  //Pass on the weather data
        }
        return modelAndView;
    }
}
