package hr.kbratko.domain.vehicle;

import hr.kbratko.domain.fuel.Fuel;

public class Car extends Vehicle {
  private static final Double CHARGE = 50.0;
  private static final SizeCategory SIZE_CATEGORY = SizeCategory.SMALL;

  private Integer sittingPlaces;

  public Car(Fuel fuel) {
    this(null, fuel);
  }

  public Car(Long id, Fuel fuel) {
    super(id, CHARGE, SIZE_CATEGORY, fuel);
  }

  public Car(Long id, Fuel fuel, Integer sittingPlaces) {
    super(id, CHARGE, SIZE_CATEGORY, fuel);
    this.sittingPlaces = sittingPlaces;
  }

  public Integer getSittingPlaces() {
    return sittingPlaces;
  }

  public void setSittingPlaces(Integer sittingPlaces) {
    this.sittingPlaces = sittingPlaces;
  }
}
