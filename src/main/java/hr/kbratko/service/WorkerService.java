package hr.kbratko.service;

import hr.kbratko.domain.salary.SalaryStrategy;
import hr.kbratko.domain.worker.Worker;

public class WorkerService {
  private SalaryStrategy salaryStrategy;

  public Double calculateSalary(Worker worker) {
    return salaryStrategy.calculateSalary(worker);
  }

  public SalaryStrategy getSalaryStrategy() {
    return salaryStrategy;
  }

  public void setSalaryStrategy(SalaryStrategy salaryStrategy) {
    this.salaryStrategy = salaryStrategy;
  }
}
