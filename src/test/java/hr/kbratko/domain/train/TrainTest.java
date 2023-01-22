package hr.kbratko.domain.train;

import hr.kbratko.domain.fuel.Battery;
import hr.kbratko.domain.fuel.Gas;
import hr.kbratko.domain.vehicle.Car;
import hr.kbratko.domain.vehicle.Truck;
import hr.kbratko.domain.vehicle.Van;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrainTest {
  private SmallTrain smallTrain;
  private BigTrain bigTrain;

  @BeforeEach
  void setUp() {
    smallTrain = new SmallTrain();
    bigTrain = new BigTrain();
  }

  @Test
  @DisplayName("Can add transferable?")
  void addTransferable() {
    // given
    smallTrain.addTransferable(Car.builder().fuel(new Battery(25.0)).sittingPlaces(4).build());
    smallTrain.addTransferable(Van.builder().fuel(new Battery(80.0)).sittingPlaces(8).build());

    // when
    int size = smallTrain.getTransferables().size();

    // then
    assertEquals(2, size);
    assertTrue(size < smallTrain.getLimit());
  }

  @Test
  @DisplayName("Will stop adding transferables if max capacity?")
  void addTransferableCapacity() {
    // given
    smallTrain.addTransferable(Car.builder().fuel(new Battery(25.0)).sittingPlaces(4).build());
    smallTrain.addTransferable(Van.builder().fuel(new Battery(80.0)).sittingPlaces(8).build());
    smallTrain.addTransferable(Car.builder().fuel(new Battery(25.0)).sittingPlaces(4).build());
    smallTrain.addTransferable(Van.builder().fuel(new Battery(80.0)).sittingPlaces(8).build());
    smallTrain.addTransferable(Car.builder().fuel(new Battery(25.0)).sittingPlaces(4).build());
    smallTrain.addTransferable(Van.builder().fuel(new Battery(80.0)).sittingPlaces(8).build());
    smallTrain.addTransferable(Car.builder().fuel(new Battery(25.0)).sittingPlaces(4).build());
    smallTrain.addTransferable(Van.builder().fuel(new Battery(80.0)).sittingPlaces(8).build());
    smallTrain.addTransferable(Van.builder().fuel(new Battery(80.0)).sittingPlaces(8).build());

    // when
    int size = smallTrain.getTransferables().size();

    // then
    assertEquals(size, smallTrain.getLimit().intValue());
  }

  @Test
  @DisplayName("Will stop adding transferables if wrong size category?")
  void addTransferableCategory() {
    // given
    smallTrain.addTransferable(Car.builder().fuel(new Battery(25.0)).sittingPlaces(4).build());

    // when
    int size = smallTrain.getTransferables().size();
    Boolean status = smallTrain.addTransferable(Truck.builder().fuel(new Gas(80.0)).horsePower(356.0).build());

    // then
    assertEquals(1, size);
    assertFalse(status);
  }
}