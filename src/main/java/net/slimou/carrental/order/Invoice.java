package net.slimou.carrental.order;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="invoice")
public class Invoice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="amount")
    private Double amount;

    @Column(columnDefinition = "boolean default false", name = "marked_out")
    private Boolean marked_out;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="marked_date")
    private LocalDate marked_date;

    @Column(columnDefinition = "boolean default false", name = "settled_in")
    private Boolean settled_in;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="settled_date")
    private LocalDate settled_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getMarked_out() {
        return marked_out;
    }

    public void setMarked_out(Boolean marked_out) {
        this.marked_out = marked_out;
    }

    public LocalDate getMarked_date() {
        return marked_date;
    }

    public void setMarked_date(LocalDate marked_date) {
        this.marked_date = marked_date;
    }

    public Boolean getSettled_in() {
        return settled_in;
    }

    public void setSettled_in(Boolean settled_in) {
        this.settled_in = settled_in;
    }

    public LocalDate getSettled_date() {
        return settled_date;
    }

    public void setSettled_date(LocalDate settled_date) {
        this.settled_date = settled_date;
    }
}
