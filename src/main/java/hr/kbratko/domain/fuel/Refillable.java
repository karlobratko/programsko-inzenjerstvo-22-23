package hr.kbratko.domain.fuel;

public interface Refillable {
  Boolean shouldRefill();

  void refill();
}
