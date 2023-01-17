package hr.kbratko.domain.salary;

import hr.kbratko.domain.worker.Worker;

public class PercentageSalaryStrategy implements SalaryStrategy {
  private final Double salaryPerc;

  public PercentageSalaryStrategy(Double salaryPerc) {
    this.salaryPerc = salaryPerc;
  }

  public Double getSalaryPerc() {
    return salaryPerc;
  }

  @Override
  public Double calculateSalary(Worker worker) {
    return worker.getParkedVehicles().stream()
      .mapToDouble(transferable -> transferable.calculateCharge() * salaryPerc)
      .sum();
  }
}
