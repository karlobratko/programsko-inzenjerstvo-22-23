package hr.kbratko.domain.vehicle;

import hr.kbratko.domain.fuel.Fuel;

public class Truck extends Vehicle {
  private static final Double CHARGE = 90.0;
  private static final SizeCategory SIZE_CATEGORY = SizeCategory.LARGE;

  private Double horsePower;

  public Truck(Fuel fuel) {
    this(null, fuel);
  }

  public Truck(Long id, Fuel fuel) {
    super(id, CHARGE, SIZE_CATEGORY, fuel);
  }

  public Truck(Long id, Fuel fuel, Double horsePower) {
    super(id, CHARGE, SIZE_CATEGORY, fuel);
    this.horsePower = horsePower;
  }

  public Double getHorsePower() {
    return horsePower;
  }

  public void setHorsePower(Double horsePower) {
    this.horsePower = horsePower;
  }
}
