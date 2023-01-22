package hr.kbratko.domain.vehicle.builder;

import hr.kbratko.domain.fuel.Fuel;
import hr.kbratko.domain.vehicle.Car;

public interface CarBuilder<B, T> extends VehicleBuilder<B, T> {
  B sittingPlaces(Integer sittingPlaces);
}
