package hr.kbratko.domain.salary;

import hr.kbratko.domain.worker.Worker;

public class GreedySalaryStrategy implements SalaryStrategy {
  @Override
  public Double calculateSalary(Worker worker) {
    return 0.0;
  }
}
