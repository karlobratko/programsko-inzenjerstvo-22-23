package hr.kbratko.domain.salary;

import hr.kbratko.domain.worker.Worker;

public interface SalaryStrategy {
  Double calculateSalary(Worker worker);
}
