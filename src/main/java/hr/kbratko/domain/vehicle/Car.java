package hr.kbratko.domain.vehicle;

import hr.kbratko.domain.fuel.Fuel;
import hr.kbratko.domain.vehicle.builder.CarBuilder;

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

  public static Builder builder() {
    return new Builder();
  }

  public Integer getSittingPlaces() {
    return sittingPlaces;
  }

  public void setSittingPlaces(Integer sittingPlaces) {
    this.sittingPlaces = sittingPlaces;
  }

  public static final class Builder implements CarBuilder<Builder, Car> {
    private Long id;
    private Integer sittingPlaces;
    private Fuel fuel;

    public Builder() {
    }

    @Override
    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    @Override
    public Builder sittingPlaces(Integer sittingPlaces) {
      this.sittingPlaces = sittingPlaces;
      return this;
    }

    @Override
    public Builder fuel(Fuel fuel) {
      this.fuel = fuel;
      return this;
    }

    @Override
    public Car build() {
      return new Car(id, fuel, sittingPlaces);
    }
  }
}
