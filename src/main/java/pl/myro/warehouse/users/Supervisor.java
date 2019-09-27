package pl.myro.warehouse.users;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Supervisor extends Employee {

    @OneToMany
    private Set<Employee> subordinates;
    @ManyToOne
    private Supervisor supervisor;

    public Supervisor() {
    }

    public Supervisor(Employee employee) {
        super(employee);
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void addSubordinate(Employee employee) {
        this.subordinates.add(employee);
    }

    public void addSubordinates(List<Employee> employees) {
        this.subordinates.addAll(employees);
    }

    public void removeSubordinate(Employee employee) {
        this.subordinates.remove(employee);
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
