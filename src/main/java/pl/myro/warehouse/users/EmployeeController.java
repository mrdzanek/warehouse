package pl.myro.warehouse.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public void addEmployee(@RequestBody Worker employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
    public void updateEmployee(@RequestBody Worker employee, @PathVariable long id) {
        employeeService.updateEmployee(employee, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/promote/{id}")
    public void promoteWorkerToSupervisor(@PathVariable long id) {
        employeeService.promoteWorkerToSupervisor(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/degrade/{id}")
    public void degradeSupervisorToWorker(long id) {
        employeeService.degradeSupervisorToWorker(id);
    }
}
