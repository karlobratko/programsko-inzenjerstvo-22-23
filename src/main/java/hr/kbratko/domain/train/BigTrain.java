package hr.kbratko.domain.train;

import hr.kbratko.domain.vehicle.SizeCategory;
import hr.kbratko.domain.vehicle.Transferable;

public class BigTrain extends Train {
  public static final Integer NR_PLACES = 6;

  public BigTrain() {
    this(null);
  }

  public BigTrain(Long id) {
    super(id, NR_PLACES);
  }

  @Override
  public Boolean addTransferable(Transferable transferable) {
    if (transferable.getSizeCategory() != SizeCategory.LARGE)
      return false;

    return transferables.add(transferable);
  }
}
