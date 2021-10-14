package net.slimou.carrental.office;

import net.slimou.carrental.employee.Employee;
import net.slimou.carrental.person.Person_Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="office")
public class Office {

    public Office() {
    }

    public Office(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="office")
    private List<Employee> employees;

    @OneToOne(mappedBy = "office", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Office_Data office_data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office office = (Office) o;

        if (id != null ? !id.equals(office.id) : office.id != null) return false;
        return name != null ? name.equals(office.name) : office.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
