package pl.myro.warehouse.users;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Worker extends Employee {

    @ManyToOne
    private Supervisor supervisor;

    public Worker() {
    }

    public Worker(Employee employee) {
        super(employee);
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
