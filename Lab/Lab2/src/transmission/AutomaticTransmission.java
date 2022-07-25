package transmission;

/**
 * AutomaticTransmission automatically determines the
 * current gear by the current speed of the car.
 *
 * @author Pengbo Wang
 * @date 2021-09-25
 */
public final class AutomaticTransmission implements Transmission {
  private final int thresholdOne;
  private final int thresholdTwo;
  private final int thresholdThree;
  private final int thresholdFour;
  private final int thresholdFive;
  private int speed;
  private int gear;

  /**
   * Constructs an automatic transmission.
   *
   * @param thresholdOne   threshold for switching from gear 1 to gear 2
   * @param thresholdTwo   threshold for switching from gear 2 to gear 3
   * @param thresholdThree threshold for switching from gear 3 to gear 4
   * @param thresholdFour  threshold for switching from gear 4 to gear 5
   * @param thresholdFive  threshold for switching from gear 5 to gear 6
   * @throws IllegalArgumentException if any threshold value is below zero
   */
  public AutomaticTransmission(int thresholdOne, int thresholdTwo,
                               int thresholdThree, int thresholdFour, int thresholdFive)
          throws IllegalArgumentException {
    if ((thresholdOne <= 0) || (thresholdTwo <= 0) || (thresholdThree <= 0)
            || (thresholdFour <= 0) || (thresholdFive <= 0)) {
      throw new IllegalArgumentException("Negative and zero speeds are not supported.");
    }
    if ((thresholdOne >= thresholdTwo) || (thresholdTwo >= thresholdThree)
            || (thresholdThree >= thresholdFour) || (thresholdFour >= thresholdFive)) {
      throw new IllegalArgumentException("Gear speeds are not correct.");
    }
    this.thresholdOne = thresholdOne;
    this.thresholdTwo = thresholdTwo;
    this.thresholdThree = thresholdThree;
    this.thresholdFour = thresholdFour;
    this.thresholdFive = thresholdFive;
    this.speed = 0;
    this.gear = 0;
  }

  //help method
  private void gear() {
    if (this.speed == 0) {
      this.gear = 0;
    } else if (this.speed > 0 && this.speed < thresholdOne) {
      this.gear = 1;
    } else if (this.speed >= thresholdOne && this.speed < thresholdTwo) {
      this.gear = 2;
    } else if (this.speed >= thresholdTwo && this.speed < thresholdThree) {
      this.gear = 3;
    } else if (this.speed >= thresholdThree && this.speed < thresholdFour) {
      this.gear = 4;
    } else if (this.speed >= thresholdFour && this.speed < thresholdFive) {
      this.gear = 5;
    } else if (this.speed >= thresholdFive) {
      this.gear = 6;
    }
  }

  @Override
  public void increaseSpeed() {
    speed++;
    gear();
  }

  @Override
  public void decreaseSpeed() throws IllegalStateException {
    speed--;
    gear();
    if (speed < 0) {
      throw new IllegalStateException("Speed can not be lower than 0.");
    }
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }

  @Override
  public int getGear() {
    return this.gear;
  }

  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", this.speed, this.gear);
  }
}