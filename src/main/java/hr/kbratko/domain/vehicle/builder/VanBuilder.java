package hr.kbratko.domain.vehicle.builder;

public interface VanBuilder<B, T> extends VehicleBuilder<B, T> {
  B sittingPlaces(Integer sittingPlaces);
}
