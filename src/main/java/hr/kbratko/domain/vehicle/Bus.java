package hr.kbratko.domain.vehicle;

import hr.kbratko.domain.fuel.Fuel;

public class Bus extends Vehicle {
  private static final Double CHARGE = 70.0;
  private static final SizeCategory SIZE_CATEGORY = SizeCategory.LARGE;

  private Integer capacity;

  public Bus(Fuel fuel) {
    this(null, fuel);
  }

  public Bus(Long id, Fuel fuel) {
    super(id, CHARGE, SIZE_CATEGORY, fuel);
  }

  public Bus(Long id, Fuel fuel, Integer capacity) {
    super(id, CHARGE, SIZE_CATEGORY, fuel);
    this.capacity = capacity;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
}
