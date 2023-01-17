package hr.kbratko.service;

import hr.kbratko.domain.train.Transferer;
import java.util.ArrayList;
import java.util.List;

public class TrainService {

  private final List<Transferer> transferers = new ArrayList<>();

  public Double revenue() {
    return transferers.stream()
      .mapToDouble(Transferer::calculateRevenue)
      .sum();
  }

  public List<Transferer> getTransferers() {
    return transferers;
  }

  public Boolean addTransferer(Transferer transferer) {
    return transferers.add(transferer);
  }
}
