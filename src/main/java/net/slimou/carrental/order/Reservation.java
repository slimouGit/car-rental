package net.slimou.carrental.order;

import net.slimou.carrental.customer.Account;
import net.slimou.carrental.drive.Drive;
import net.slimou.carrental.employee.OrderBook;
import net.slimou.carrental.fleet.Car;
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
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "orderbook_id")
    private OrderBook orderBook;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car")
    private Car car;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drive")
    private Drive drive;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice")
    private Invoice invoice;

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

    public OrderBook getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
