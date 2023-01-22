package hr.kbratko.domain.vehicle;

import hr.kbratko.domain.fuel.Fuel;

public class Van extends Vehicle {
  private static final Double CHARGE = 80.0;
  private static final SizeCategory SIZE_CATEGORY = SizeCategory.SMALL;

  private Integer sittingPlaces;

  public Van(Fuel fuel) {
    this(null, fuel);
  }

  public Van(Long id, Fuel fuel) {
    super(id, CHARGE, SIZE_CATEGORY, fuel);
  }

  public Van(Long id, Fuel fuel, Integer sittingPlaces) {
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