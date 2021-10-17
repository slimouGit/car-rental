package net.slimou.carrental.employee;

import net.slimou.carrental.fleet.Car;
import net.slimou.carrental.office.Office;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="staff")
public class Staff {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office")
    private Office office;

    @OneToMany(mappedBy="staff")
    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
