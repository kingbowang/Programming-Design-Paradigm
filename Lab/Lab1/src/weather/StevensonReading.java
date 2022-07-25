package weather;

/**
 * The class used to store weather readings from Stevenson Station.
 *
 * @author Pengbo Wang
 * @date 2021-09-18
 */
public final class StevensonReading implements WeatherReading {
  private final double temperature;
  private final double dewPoint;
  private final double windSpeed;
  private final double totalRain;

  /**
   * Construct a Stevenson Reading object for calculating weather indicators.
   *
   * @param temperature The air temperature in Celsius.
   * @param dewPoint    The temperature at below which water droplets (or dew) begin to form.
   * @param windSpeed   The non-negative wind speed in miles per hour.
   * @param totalRain   The non-negative total rain received in the last 24 hours in millimeters.
   * @throws IllegalArgumentException if any argument is invalid
   */
  public StevensonReading(double temperature, double dewPoint, double windSpeed, double totalRain)
          throws IllegalArgumentException {
    if (dewPoint > temperature) {
      throw new IllegalArgumentException("Dew point can‘t be greater than air temperature.");
    }
    if (windSpeed < 0) {
      throw new IllegalArgumentException("Wind speed can’t be negative.");
    }
    if (totalRain < 0) {
      throw new IllegalArgumentException("Total rain can‘t be negative.");
    }
    this.temperature = temperature;
    this.dewPoint = dewPoint;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
  }

  @Override
  public int getTemperature() {
    return (int) Math.round(temperature);
  }

  @Override
  public int getDewPoint() {
    return (int) Math.round(dewPoint);
  }

  @Override
  public int getWindSpeed() {
    return (int) Math.round(windSpeed);
  }

  @Override
  public int getTotalRain() {
    return (int) Math.round(totalRain);
  }

  //Help method for calculate relative humidity.
  private double calculateHumidity() {
    return (100 + 5 * (dewPoint - temperature));
  }

  @Override
  public int getRelativeHumidity() {
    return (int) Math.round(this.calculateHumidity());
  }

  //Help method for calculate heat index.
  private double calculateHeatIndex() {
    final double c1 = -8.78469475556;
    final double c2 = 1.61139411;
    final double c3 = 2.33854883889;
    final double c4 = -0.14611605;
    final double c5 = -0.012308094;
    final double c6 = -0.0164248277778;
    final double c7 = 0.002211732;
    final double c8 = 0.00072546;
    final double c9 = -0.000003582;
    final double t = temperature;
    final double r = this.calculateHumidity();
    final double t0 = Math.pow(temperature, 2);
    final double r0 = Math.pow(this.calculateHumidity(), 2);
    return (c1 + (c2 * t) + (c3 * r)
            + (c4 * t * r) + (c5 * t0) + (c6 * r0)
            + (c7 * t0 * r) + (c8 * t * r0) + (c9 * t0 * r0));
  }

  @Override
  public int getHeatIndex() {
    return (int) Math.round(this.calculateHeatIndex());
  }

  //Help method for calculate Celsius to Fahrenheit.
  private double celsiusToFahrenheit() {
    return (temperature * 1.8 + 32);
  }

  //Help method for calculate windchill.
  private double calculateWindChill() {
    return (35.74 + 0.6215 * this.celsiusToFahrenheit()
            - 35.75 * Math.pow(windSpeed, 0.16)
            + 0.4275 * this.celsiusToFahrenheit() * Math.pow(windSpeed, 0.16));
  }

  @Override
  public int getWindChill() {
    return (int) Math.round(this.calculateWindChill());
  }

  @Override
  public String toString() {
    return String.format("Reading: T = %d, D = %d, v = %d, rain = %d", this.getTemperature(),
            this.getDewPoint(), this.getWindSpeed(), this.getTotalRain());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WeatherReading)) {
      return false;
    }
    WeatherReading that = (WeatherReading) o;
    return this.getTemperature() == that.getTemperature()
            && this.getTotalRain() == that.getTotalRain()
            && this.getWindSpeed() == that.getWindSpeed()
            && this.getDewPoint() == that.getDewPoint();
  }

  @Override
  public int hashCode() {
    return Double.hashCode(this.temperature + this.dewPoint + this.windSpeed + this.totalRain);
  }
}