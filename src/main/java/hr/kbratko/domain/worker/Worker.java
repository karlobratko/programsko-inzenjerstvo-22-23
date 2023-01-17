package hr.kbratko.domain.worker;

import hr.kbratko.domain.BaseModel;
import hr.kbratko.domain.vehicle.Chargeable;
import hr.kbratko.domain.vehicle.Fuelable;
import java.util.ArrayList;
import java.util.List;

public class Worker extends BaseModel<Long> implements Parker, Refiller {
  private final List<Chargeable> parkedVehicles = new ArrayList<>();
  private final List<Fuelable> refilledVehicles = new ArrayList<>();

  public Worker() {
  }

  public Worker(Long id) {
    super(id);
  }

  public List<Chargeable> getParkedVehicles() {
    return parkedVehicles;
  }

  public List<Fuelable> getRefilledVehicles() {
    return refilledVehicles;
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
