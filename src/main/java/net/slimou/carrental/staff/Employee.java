package net.slimou.carrental.staff;

import net.slimou.carrental.company.Staff;
import net.slimou.carrental.human.Person;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee")
public class Employee {

    public enum Role{
        MANAGER, CONSULTANT
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="salary")
    private Double salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date_of_employment")
    private LocalDate date_of_employment;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person")
    private Person person;

    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private OrderBook orderBook;

    @ManyToOne
    private Staff staff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDate_of_employment() {
        return date_of_employment;
    }

    public void setDate_of_employment(LocalDate date_of_employment) {
        this.date_of_employment = date_of_employment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public OrderBook getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(OrderBook orderBook) {
        this.orderBook = orderBook;
    }
}
