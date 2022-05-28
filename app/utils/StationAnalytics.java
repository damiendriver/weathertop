package utils;
import models.Reading;
import models.Station;

import java.util.HashMap;
import java.util.List;

public class StationAnalytics {
    public static String weatherCodeToString(int code) {
        switch(code) {
            case 100:
                return "Clear";
            case 200:
                return "Partial Clouds";
            case 300:
                return "Cloudy";
            case 400:
                return "Light Showers";
            case 500:
                return "Heavy Showers";
            case 600:
                return "Rain";
            case 700:
                return "Snow";
            case 800:
                return "Thunder";
            default:
                return "Check Code Entered for Latest Reading as Invalid Code Input";
        }
    }

    public static String weatherSuitableIcon(int code) {
        switch(code) {
            case 100:
                return "ui inverted yellow sun outline icon";
            case 200:
                return "ui yellow cloud sun icon";
            case 300:
                return "ui grey cloud icon";
            case 400:
                return "ui inverted primary cloud sun rain icon";
            case 500:
                return "blue cloud showers heavy icon";
            case 600:
                return "blue cloud rain icon";
            case 700:
                return "ui inverted white snowflake outline icon";
            case 800:
                return "ui red bolt icon";
            default:
                return "Check weather Code, Invalid Entry";
        }
    }

    public static double tempToFahrenheit(double temperature) {
        double tempFahrenheit = (((temperature * 9) / 5) +32);
        tempFahrenheit = (Math.round(tempFahrenheit * 10.0) / 10.0);
        return tempFahrenheit;
    }

    public static double windChillCalculator(double windSpeed, double temperature) {
        double windChill = (13.12 + (0.6215 * temperature)) - (11.37 * (Math.pow(windSpeed, 0.16)))
                + ((0.3965 * temperature) * (Math.pow(windSpeed, 0.16)));
        windChill = (Math.round(windChill * 100.0) / 100.0);
        return windChill;
    }

    public static int windToBeaufort(double windSpeed) {
        int windBeaufort;
        if (windSpeed <= 1) {
            windBeaufort = 0;
        }
        else if ((windSpeed > 1) && (windSpeed < 6)) {
            windBeaufort = 1;
        }
        else if ((windSpeed >= 6) && (windSpeed < 12)) {
            windBeaufort = 2;
        }
        else if ((windSpeed >= 12) && (windSpeed < 20)) {
            windBeaufort = 3;
        }
        else if ((windSpeed >= 20) && (windSpeed < 29)) {
            windBeaufort = 4;
        }
        else if ((windSpeed >= 29) && (windSpeed < 39)) {
            windBeaufort = 5;
        }
        else if ((windSpeed >= 39) && (windSpeed < 50)) {
            windBeaufort = 6;
        }
        else if ((windSpeed >= 50) && (windSpeed < 62)) {
            windBeaufort = 7;
        }
        else if ((windSpeed >= 62) && (windSpeed < 75)) {
            windBeaufort = 8;
        }
        else if ((windSpeed >= 75) && (windSpeed < 89)) {
            windBeaufort = 9;
        }
        else if ((windSpeed >= 89) && (windSpeed < 103)) {
            windBeaufort = 10;
        }
        else {
            windBeaufort = 11;
        }

        return windBeaufort;
    }

    public static String windDirectionToString(int windDirection) {
        if (((windDirection >= 348.75) && (windDirection <= 360))
                || ((windDirection >= 0) && (windDirection < 11.25))) {
            return "North";
        }
        else if ((windDirection >= 11.25) && (windDirection < 33.75)) {
            return "North North East";
        }
        else if ((windDirection >= 33.75) && (windDirection < 56.25)) {
            return "North East";
        }
        else if ((windDirection >= 56.25) && (windDirection < 78.75)) {
            return "East North East";
        }
        else if ((windDirection >= 78.75) && (windDirection < 101.25)) {
            return "East";
        }
        else if ((windDirection >= 101.25) && (windDirection < 123.75)) {
            return "East South East";
        }
        else if ((windDirection >= 123.75) && (windDirection < 146.25)) {
            return "South East";
        }
        else if ((windDirection >= 146.25) && (windDirection < 168.75)) {
            return "South South East";
        }
        else if ((windDirection >= 168.75) && (windDirection < 191.25)) {
            return "South";
        }
        else if ((windDirection >= 191.25) && (windDirection < 213.75)) {
            return "South South West";
        }
        else if ((windDirection >= 213.75) && (windDirection < 236.25)) {
            return "South West";
        }
        else if ((windDirection >= 236.25) && (windDirection < 258.75)) {
            return "West South West";
        }
        else if ((windDirection >= 258.75) && (windDirection < 281.25)) {
            return "West";
        }
        else if ((windDirection >= 281.25) && (windDirection < 303.75)) {
            return "West North West";
        }
        else if ((windDirection >= 303.75) && (windDirection < 326.25)) {
            return "North West";
        }
        else if ((windDirection >= 326.25) && (windDirection < 348.75)) {
            return "North North West";
        }
        else {
            return "No Wind Today";
        }
    }
    public static double getMaxTempCelsius(Station stations) {
        double max = Double.MIN_VALUE;
        for (Reading reading : stations.readings) {
            if (reading.temperature > max) {
                max = reading.temperature;
            }
        }
        return max;
    }
    public static double getMinTempCelsius(Station stations) {
        double min = Double.MAX_VALUE;
        for (Reading reading : stations.readings) {
            if (reading.temperature < min) {
                min = reading.temperature;
            }
        }
        return min;
    }
    public static double getMaxWindSpeed(Station stations) {
        double max = Double.MIN_VALUE;
        for (Reading reading : stations.readings) {
            if (reading.windSpeed > max) {
                max = reading.windSpeed;
            }
        }
        return max;
    }

    public static double getMinWindSpeed(Station stations) {
        double min = Double.MAX_VALUE;
        for (Reading reading : stations.readings) {
            if (reading.windSpeed < min) {
                min = reading.windSpeed;
            }
        }
        return min;
    }

    public static int getMaxPressure(Station stations) {
        int max = Integer.MIN_VALUE;
        for (Reading reading : stations.readings) {
            if (reading.pressure > max) {
                max = reading.pressure;
            }
        }
        return max;
    }

    public static int getMinPressure(Station stations) {
        int min = Integer.MAX_VALUE;
        for (Reading reading : stations.readings) {
            if (reading.pressure < min) {
                min = reading.pressure;
            }
        }
        return min;
    }
}