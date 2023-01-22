package hr.kbratko.domain.train;

import hr.kbratko.domain.vehicle.SizeCategory;
import hr.kbratko.domain.vehicle.Transferable;

public class SmallTrain extends Train {
  public static final Integer NR_PLACES = 8;

  public SmallTrain() {
    this(null);
  }

  public SmallTrain(Long id) {
    super(id, NR_PLACES);
  }

  @Override
  public Boolean addTransferable(Transferable transferable) {
    if (transferable.getSizeCategory() != SizeCategory.SMALL)
      return false;

    return transferables.add(transferable);
  }
}
