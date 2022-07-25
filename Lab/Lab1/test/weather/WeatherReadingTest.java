package weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * WeatherReadingTest class is a test class for WeatherReading Interface.
 */
public class WeatherReadingTest {
  private WeatherReading reading;

  @Before
  public void setUp() {
    reading = weatherReading(23, 11.9, 3.33, 12.27);
  }

  private WeatherReading weatherReading(double temp, double dewPoint,
                                        double windSpeed, double totalRain) {
    return new StevensonReading(temp, dewPoint, windSpeed, totalRain);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDewPoint() throws IllegalArgumentException {
    weatherReading(15, 16, 18, 18);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidWindSpeed() throws IllegalArgumentException {
    weatherReading(15, 12, -2.8, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidTotalRain() throws IllegalArgumentException {
    weatherReading(42, 14, 5, -0.01);
  }

  @Test
  public void getTemperature() {
    assertEquals("Temperature rounds up", 23, weatherReading(22.9, 12, 3, 10).getTemperature());
    assertEquals("Temperature rounds down", 18, weatherReading(17.5, 12, 3, 10).getTemperature());
    assertEquals("All the numbers of temperature", 23, reading.getTemperature());
  }

  @Test
  public void getDewPoint() {
    assertEquals("DewPoint rounds up", 12, reading.getDewPoint());
    assertEquals("DewPoint rounds down", 48, weatherReading(50, 47.99, 31, 20).getDewPoint());
    assertEquals("All the numbers of DewPoint", 35, weatherReading(88, 35, 14, 9).getDewPoint());
  }

  @Test
  public void getWindSpeed() {
    assertEquals("Wind speed rounds up", 34, weatherReading(54, 37, 34.3, 4).getWindSpeed());
    assertEquals("Wind speed rounds down", 3, reading.getWindSpeed());
    assertEquals("All the numbers of wind speed", 11,
            weatherReading(20, 18.3, 11, 10).getWindSpeed());
  }

  @Test
  public void getTotalRain() {
    assertEquals("Rain total rounds down", 12, reading.getTotalRain());
    assertEquals("Rain total rounds up", 49, weatherReading(76.9, 23.6, 15, 49.2).getTotalRain());
    assertEquals("All the numbers of rain total", 16,
            weatherReading(30, 10.7, 8, 15.7).getTotalRain());
  }

  @Test
  public void getRelativeHumidity() {
    assertEquals(45, reading.getRelativeHumidity());
  }

  @Test
  public void getHeatIndex() {
    assertEquals(25, reading.getHeatIndex());
  }

  @Test
  public void getWindChill() {
    assertEquals(76, reading.getWindChill());
  }

  @Test
  public void testToString() {
    assertEquals("Reading: T = 23, D = 12, v = 3, rain = 12", reading.toString());
  }

  @Test
  public void testEquals() {
    WeatherReading weatherObject1 = weatherReading(23, 11.7, 3.25, 12.2);
    WeatherReading weatherObject2 = weatherReading(23, 11.7, 3.25, 12.2);
    WeatherReading differentWeatherObject = weatherReading(43, 34, 23, 69);
    assertEquals(reading, reading);
    assertEquals(reading, weatherObject1);
    assertEquals(weatherObject1, weatherObject2);
    assertEquals(reading, weatherObject2);
    assertNotEquals(reading, differentWeatherObject);
    assertNotEquals(reading, new Object());
  }

  @Test
  public void testHashCode() {
    assertEquals(Double.hashCode(52.9 + 17.2 + 9.02 + 3.7),
            (weatherReading(52.9, 17.2, 9.02, 3.7).hashCode()));
    assertNotEquals(weatherReading(52.9, 17.2, 9.02, 3.7), weatherReading(53, 17, 9, 6));
  }

}