package hr.kbratko.domain.vehicle;

import hr.kbratko.domain.fuel.Fuel;
import hr.kbratko.domain.vehicle.builder.BusBuilder;

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

  public static Builder builder() {
    return new Builder();
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public static final class Builder implements BusBuilder<Builder, Bus> {
    private Long id;
    private Integer capacity;
    private Fuel fuel;

    public Builder() {
    }

    @Override
    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    @Override
    public Builder capacity(Integer capacity) {
      this.capacity = capacity;
      return null;
    }

    @Override
    public Builder fuel(Fuel fuel) {
      this.fuel = fuel;
      return this;
    }

    @Override
    public Bus build() {
      return new Bus(id, fuel, capacity);
    }
  }
}
