package hr.kbratko.domain.fuel;

public class Battery extends Fuel {
  public static final Double MIN_PERCENTAGE = 10.0;

  public Battery(Double percentage) {
    this(null, percentage);
  }

  public Battery(Long id, Double percentage) {
    super(id, 10.0, percentage);
  }

  @Override
  public void refill() {
    percentage = MAX_PERCENTAGE;
  }

  @Override
  public Boolean shouldRefill() {
    return percentage <= minPercentage;
  }
}
