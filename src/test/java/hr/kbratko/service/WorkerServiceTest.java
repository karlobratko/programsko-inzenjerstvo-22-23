package hr.kbratko.service;

import hr.kbratko.domain.fuel.Battery;
import hr.kbratko.domain.fuel.Gas;
import hr.kbratko.domain.salary.PercentageSalaryStrategy;
import hr.kbratko.domain.vehicle.Bus;
import hr.kbratko.domain.vehicle.Car;
import hr.kbratko.domain.vehicle.Chargeable;
import hr.kbratko.domain.vehicle.Truck;
import hr.kbratko.domain.vehicle.Van;
import hr.kbratko.domain.worker.Worker;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkerServiceTest {
  private WorkerService service;
  private List<Chargeable> chargeables;

  @BeforeEach
  void setUp() {
    service = new WorkerService();
    chargeables = Stream
      .of(
        Bus.builder().fuel(new Gas(30.0)).capacity(80).build(),
        Car.builder().fuel(new Battery(25.0)).sittingPlaces(4).build(),
        Truck.builder().fuel(new Gas(45.0)).horsePower(280.0).build(),
        Van.builder().fuel(new Battery(80.0)).sittingPlaces(8).build()
      )
      .collect(Collectors.toList());
  }

  @Test
  @DisplayName("Can calculate salary?")
  void calculateSalary() {
    // given
    double salaryPerc = 10.0;
    Worker worker = new Worker();
    chargeables.forEach(worker::parkChargeable);

    service.setSalaryStrategy(new PercentageSalaryStrategy(salaryPerc));

    // when
    Double salary = service.calculateSalary(worker);

    // then
    assertEquals(
      salary,
      worker.getParkedVehicles().stream()
        .mapToDouble(transferable -> transferable.calculateCharge() * (salaryPerc / 100))
        .sum()
    );
  }
}