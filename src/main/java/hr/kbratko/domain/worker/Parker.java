package hr.kbratko.domain.worker;

import hr.kbratko.domain.vehicle.Chargeable;

public interface Parker {
  Boolean parkChargeable(Chargeable transferable);
}
