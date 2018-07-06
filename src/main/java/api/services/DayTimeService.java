package api.services;


import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DayTimeService {

    public String dayTime(int timezone){

        long timeZoneChange = timezone;

        // Get total milliseconds since midnight, 1/1/1970
        long totalMilliseconds = System.currentTimeMillis();

        // Get total seconds since midnight, 1/1/1970
        long totalSeconds = totalMilliseconds/1000;

        // Get the current second within the minute within the hour
        long secondsPerMinute = 60;
        long currentSecond = (totalSeconds % secondsPerMinute);

        // Get total minutes
        long totalMinutes = totalSeconds/secondsPerMinute;

        // Get the current minute in the hour
        long minutesPerHour = 60;
        long currentMinute = totalMinutes % minutesPerHour;

        // Get the total hours
        long secondsInHours = 3600;
        long totalHours = totalSeconds /secondsInHours;

        // Get the current hour
        long hoursPerDay = 24;
        long currentHour = totalHours % hoursPerDay;

        // the flag bellow is created to say if Am or Pm
        boolean flag = true;
        currentHour+= timeZoneChange;

        if (currentHour > 12){
            currentHour-=12;
            flag = false;
        }

        // Display results using a 12 hour clock, include AM or PM
        String amOrPm = "";
        if (flag){
            amOrPm = "AM";
        }
        else {
            amOrPm = "PM";
        }

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(date);

        String result = "todays is " + strDate + " and it's  " + currentHour +":"+currentMinute+ ":"+currentSecond+ " "+ amOrPm ;

        return result;
    }

}
