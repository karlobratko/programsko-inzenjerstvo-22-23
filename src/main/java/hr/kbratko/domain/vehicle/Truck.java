package hr.kbratko.domain.vehicle;

import hr.kbratko.domain.fuel.Fuel;
import hr.kbratko.domain.vehicle.builder.TruckBuilder;

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

  public static Builder builder() {
    return new Builder();
  }

  public Double getHorsePower() {
    return horsePower;
  }

  public void setHorsePower(Double horsePower) {
    this.horsePower = horsePower;
  }

  public static final class Builder implements TruckBuilder<Builder, Truck> {
    private Long id;
    private Double horsePower;
    private Fuel fuel;

    public Builder() {
    }

    @Override
    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    @Override
    public Builder fuel(Fuel fuel) {
      this.fuel = fuel;
      return this;
    }

    @Override
    public Builder horsePower(Double horsePower) {
      this.horsePower = horsePower;
      return this;
    }

    @Override
    public Truck build() {
      return new Truck(id, fuel, horsePower);
    }
  }
}
