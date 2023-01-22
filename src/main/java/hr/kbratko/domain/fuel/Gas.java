package hr.kbratko.domain.fuel;

public class Gas extends Fuel {
  public static final Double MIN_PERCENTAGE = 10.0;

  public Gas(Double percentage) {
    this(null, percentage);
  }

  public Gas(Long id, Double percentage) {
    super(id, MIN_PERCENTAGE, percentage);
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
