package pl.myro.warehouse.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee, long id) {
        if (employee.getId() == 0) employee.setId(id);
        employeeRepository.save(employee);
    }

    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public void promoteWorkerToSupervisor(long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        Supervisor supervisor = new Supervisor(employee);
        employeeRepository.save(supervisor);
        employeeRepository.delete(employee);
    }

    public void degradeSupervisorToWorker(long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        Worker worker = new Worker(employee);
        employeeRepository.save(worker);
        employeeRepository.delete(employee);
    }
}
