package hr.kbratko.domain.fuel;

import hr.kbratko.domain.BaseModel;

public abstract class Fuel extends BaseModel<Long> implements Refillable {
  protected static final Double MAX_PERCENTAGE = 100.0;

  protected final Double minPercentage;
  protected Double percentage;

  public Fuel(Double minPercentage, Double percentage) {
    this(null, minPercentage, percentage);
  }

  public Fuel(Long id, Double minPercentage, Double percentage) {
    super(id);
    this.minPercentage = minPercentage;
    this.percentage = percentage;
  }

  public Double getMinPercentage() {
    return minPercentage;
  }

  public Double getPercentage() {
    return percentage;
  }

  public void setPercentage(Double percentage) {
    this.percentage = percentage;
  }
}
