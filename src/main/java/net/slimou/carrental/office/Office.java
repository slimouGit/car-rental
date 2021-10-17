package net.slimou.carrental.office;

import net.slimou.carrental.customer.Clientele;
import net.slimou.carrental.customer.Customer;
import net.slimou.carrental.employee.Employee;
import net.slimou.carrental.employee.Staff;
import net.slimou.carrental.fleet.Car;
import net.slimou.carrental.fleet.Fleet;

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

    @OneToOne(mappedBy = "office", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Staff staff;

    @OneToOne(mappedBy = "office", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Clientele clientele;

    @OneToOne(mappedBy = "office", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Fleet fleet;

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

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Clientele getClientele() {
        return clientele;
    }

    public void setClientele(Clientele clientele) {
        this.clientele = clientele;
    }

    public Office_Data getOffice_data() {
        return office_data;
    }

    public void setOffice_data(Office_Data office_data) {
        this.office_data = office_data;
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
