package hr.kbratko.service;

import hr.kbratko.domain.fuel.Battery;
import hr.kbratko.domain.fuel.Gas;
import hr.kbratko.domain.train.BigTrain;
import hr.kbratko.domain.train.SmallTrain;
import hr.kbratko.domain.train.Transferer;
import hr.kbratko.domain.vehicle.Bus;
import hr.kbratko.domain.vehicle.Car;
import hr.kbratko.domain.vehicle.Truck;
import hr.kbratko.domain.vehicle.Van;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainServiceTest {
  private TrainService service;
  private List<Transferer> transferers;

  @BeforeEach
  void setUp() {
    service = new TrainService();

    BigTrain bigTrain = new BigTrain();
    bigTrain.addTransferable(Bus.builder().fuel(new Gas(30.0)).capacity(80).build());
    bigTrain.addTransferable(Truck.builder().fuel(new Gas(45.0)).horsePower(280.0).build());

    SmallTrain smallTrain = new SmallTrain();
    smallTrain.addTransferable(Car.builder().fuel(new Battery(25.0)).sittingPlaces(4).build());
    smallTrain.addTransferable(Van.builder().fuel(new Battery(80.0)).sittingPlaces(8).build());

    transferers = Stream
      .of(
        bigTrain,
        smallTrain
      )
      .collect(Collectors.toList());
  }

  @Test
  @DisplayName("Can calculate revenue?")
  void revenue() {
    // given
    transferers.forEach(service::addTransferer);

    // when
    Double revenue = service.revenue();

    // then
    assertEquals(
      revenue,
      transferers.stream()
        .mapToDouble(Transferer::calculateRevenue)
        .sum()
    );
  }
}