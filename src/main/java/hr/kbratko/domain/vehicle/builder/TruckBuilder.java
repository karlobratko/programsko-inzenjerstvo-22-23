package hr.kbratko.domain.vehicle.builder;

public interface TruckBuilder<B, T> extends VehicleBuilder<B, T> {
  B horsePower(Double horsePower);
}
