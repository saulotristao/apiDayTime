package api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import api.services.DayTimeService;

@RestController
public class DayTimeControl {

    @Autowired
    DayTimeService dayTimeService;

    //Get
    // Receives the timezone and return day and time
    @GetMapping
    public String getDayTime(@RequestParam (value="timezone")int timezone){
        return dayTimeService.dayTime (timezone);
    };

}
