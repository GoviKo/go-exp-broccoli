package io.goviko.http2.http2demo;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.*;

@RestController
public class WeatherController {

    private static final RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

    @GetMapping("/weather")
    public String chat(@RequestParam String city) {
        return format("Requesting weather for city %s.  Temp = %.2f", city, getTemp());
    }

    private double getTemp() {
        double leftLimit = -20D;
        double rightLimit = 40D;
        return randomDataGenerator.nextUniform(leftLimit, rightLimit);
    }
}
