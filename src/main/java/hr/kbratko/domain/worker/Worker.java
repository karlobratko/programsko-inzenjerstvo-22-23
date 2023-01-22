package hr.kbratko.domain.worker;

import hr.kbratko.domain.BaseModel;
import hr.kbratko.domain.vehicle.Chargeable;
import hr.kbratko.domain.vehicle.Fuelable;
import java.util.ArrayList;
import java.util.List;

public class Worker extends BaseModel<Long> implements Parker, Refiller {
  private final List<Chargeable> parkedVehicles = new ArrayList<>();
  private final List<Fuelable> refilledVehicles = new ArrayList<>();
  private Double salaryPerc;

  public Worker(Double salaryPerc) {
    this(null, salaryPerc);
  }

  public Worker(Long id, Double salaryPerc) {
    super(id);
    this.salaryPerc = salaryPerc;
  }

  public Double salary() {
    return parkedVehicles.stream()
      .mapToDouble(transferable -> transferable.calculateCharge() * salaryPerc)
      .sum();
  }

  public List<Chargeable> getParkedVehicles() {
    return parkedVehicles;
  }

  public List<Fuelable> getRefilledVehicles() {
    return refilledVehicles;
  }

  public Double getSalaryPerc() {
    return salaryPerc;
  }

  public void setSalaryPerc(Double salaryPerc) {
    this.salaryPerc = salaryPerc;
  }

  @Override
  public Boolean parkChargeable(Chargeable transferable) {
    return parkedVehicles.add(transferable);
  }

  @Override
  public void refilVehiclePercentage(Fuelable fuelable) {
    if (fuelable.getFuel().shouldRefill()) {
      fuelable.getFuel().refill();
      refilledVehicles.add(fuelable);
    }
  }
}
