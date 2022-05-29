package com.youcode.service;

import com.youcode.entity.Weather;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class WeatherService {
    private final WebClient.Builder webClientBuilder;

    public Weather getWeather(String latitude, String longitude){

        String url = "https://api.open-meteo.com/v1/forecast";
        HashMap weather1 = webClientBuilder.build().get()
                .uri(url + "?latitude=" + latitude + "&longitude=" + longitude + "&current_weather=true")
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
        HashMap currentWeather = (HashMap) weather1.get("current_weather");

        Weather weather = new Weather();
        weather.setLatitude(weather1.get("latitude").toString());
        weather.setLongitude(weather1.get("longitude").toString());
        weather.setTemperature(currentWeather.get("temperature").toString());
        weather.setTime(currentWeather.get("time").toString());

        return weather;
    }


}
