package hr.kbratko.domain.vehicle.builder;

public interface BusBuilder<B, T> extends VehicleBuilder<B, T> {
  B capacity(Integer capacity);
}
