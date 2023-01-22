package hr.kbratko.domain.train;

import hr.kbratko.domain.BaseModel;
import hr.kbratko.domain.vehicle.Transferable;
import hr.kbratko.infrastructure.LimitedArrayList;
import java.util.List;

public abstract class Train extends BaseModel<Long> implements Transferer {
  protected final Integer limit;
  protected final List<Transferable> transferables;

  public Train(Integer limit) {
    this(null, limit);
  }

  public Train(Long id, Integer limit) {
    super(id);
    this.limit = limit;
    this.transferables = new LimitedArrayList<>(limit);
  }

  @Override
  public Integer getLimit() {
    return limit;
  }

  @Override
  public List<Transferable> getTransferables() {
    return transferables;
  }

  @Override
  public Double calculateRevenue() {
    return transferables.stream()
      .mapToDouble(Transferable::calculateCharge)
      .sum();
  }

  @Override
  public abstract Boolean addTransferable(Transferable transferable);

  @Override
  public Boolean removeTransferable(Transferable transferable) {
    return transferables.remove(transferable);
  }
}
