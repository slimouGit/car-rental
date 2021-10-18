package net.slimou.carrental.staff;

import net.slimou.carrental.reservation.Reservation;
import net.slimou.carrental.staff.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orderbook")
public class OrderBook {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee")
    private Employee employee;

    @OneToMany
    @JoinTable(
            name = "reservation",
            joinColumns = @JoinColumn(name = "orderbook_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
