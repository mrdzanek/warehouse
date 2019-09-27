package pl.myro.warehouse.users;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String pesel;
    private String name;
    private String surname;
    private Address address;
    private Date dateOfEmployment;
    private String position;
    private String department;
    private double salary;

    public Employee() {
    }

    public Employee(Employee employee) {
        this.setName(employee.getName());
        this.setId(employee.getId());
        this.setDateOfEmployment(employee.getDateOfEmployment());
        this.setSurname(employee.getSurname());
        this.setSalary(employee.getSalary());
        this.setDepartment(employee.getDepartment());
        this.setPesel(employee.getPesel());
        this.setPosition(employee.getPosition());
        this.setAddress(employee.getAddress());
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}
