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

}
