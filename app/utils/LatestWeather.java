
package utils;

import models.Reading;
import models.Station;

public class LatestWeather {

    public static Station getLatestReadings(Station station) {
        Reading reading;
        if (station.readings.size() > 0) {
            reading = station.readings.get(station.readings.size() - 1);
        }
        else {
            reading = new Reading(0, 0.0, 0.0, 0, 0);
        }
        station.weatherDescription = StationAnalytics.weatherCodeToString(reading.code);
        station.tempCelsius = reading.temperature;
        station.tempFahrenheit = StationAnalytics.tempToFahrenheit(reading.temperature);
        station.maxTempCelsius = StationAnalytics.getMaxTempCelsius(station);
        station.minTempCelsius = StationAnalytics.getMinTempCelsius(station);
        station.windBeaufort = StationAnalytics.windToBeaufort(reading.windSpeed);
        station.windDirection = reading.windDirection;
        station.windDirectionOutput = StationAnalytics.windDirectionToString(reading.windDirection);
        station.windChill = StationAnalytics.windChillCalculator(reading.windSpeed, reading.temperature);
        station.maxWindSpeed = StationAnalytics.getMaxWindSpeed(station);
        station.minWindSpeed = StationAnalytics.getMinWindSpeed(station);
        station.pressureHPA = reading.pressure;
        station.maxPressure = StationAnalytics.getMaxPressure(station);
        station.minPressure = StationAnalytics.getMinPressure(station);
        return station;
    }
}