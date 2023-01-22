package hr.kbratko.domain.vehicle;

import hr.kbratko.domain.BaseModel;
import hr.kbratko.domain.fuel.Fuel;

public abstract class Vehicle extends BaseModel<Long> implements Transferable {

  private final Double charge;

  private final SizeCategory sizeCategory;

  private final Fuel fuel;

  public Vehicle(Double charge, SizeCategory sizeCategory, Fuel fuel) {
    this(null, charge, sizeCategory, fuel);
  }

  public Vehicle(Long id, Double charge, SizeCategory sizeCategory, Fuel fuel) {
    super(id);
    this.charge = charge;
    this.sizeCategory = sizeCategory;
    this.fuel = fuel;
  }

  @Override
  public SizeCategory getSizeCategory() {
    return sizeCategory;
  }

  @Override
  public Fuel getFuel() {
    return fuel;
  }

  @Override
  public Double calculateCharge() {
    return charge;
  }
}
