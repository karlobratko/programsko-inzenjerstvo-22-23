package hr.kbratko.domain.vehicle.builder;

import hr.kbratko.domain.fuel.Fuel;

public interface VehicleBuilder<B, T> {
  B id(Long id);

  B fuel(Fuel fuel);

  T build();
}
