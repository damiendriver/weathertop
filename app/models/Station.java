package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
  public String name;
  public String weatherDescription;
  public String suitableIcon;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  public double latitude;
  public double longitude;
  public int windDirection;
  public double windSpeed;
  public double tempCelsius;
  public double maxTempCelsius;
  public double minTempCelsius;
  public double tempFahrenheit;
  public int windBeaufort;
  public String windDirectionOutput;
  public double windChill;
  public double maxWindSpeed;
  public double minWindSpeed;
  public int pressureHPA;
  public int maxPressure;
  public int minPressure;

  public Station(String name, double latitude, double longitude)
  {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}