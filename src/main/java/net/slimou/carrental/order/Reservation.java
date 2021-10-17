package net.slimou.carrental.order;

import net.slimou.carrental.customer.Account;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="rental_start")
    private LocalDate rental_start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="rental_end")
    private LocalDate rental_end;

    @ManyToOne
    private Account account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRental_start() {
        return rental_start;
    }

    public void setRental_start(LocalDate rental_start) {
        this.rental_start = rental_start;
    }

    public LocalDate getRental_end() {
        return rental_end;
    }

    public void setRental_end(LocalDate rental_end) {
        this.rental_end = rental_end;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
