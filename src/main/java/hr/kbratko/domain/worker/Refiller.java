package hr.kbratko.domain.worker;

import hr.kbratko.domain.vehicle.Fuelable;

public interface Refiller {
  void refillVehiclePercentage(Fuelable fuelable);
}
