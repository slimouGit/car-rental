package net.slimou.carrental.customer;

import net.slimou.carrental.person.Person;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="customer")
public class Customer {

    public Customer() {
    }

    public Customer(LocalDate entrydate, Person person) {
        this.entrydate = entrydate;
        this.person = person;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="entrydate")
    private LocalDate entrydate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person")
    private Person person;

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Account account;

    @ManyToOne
    private Clientele clientele;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(LocalDate entrydate) {
        this.entrydate = entrydate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Clientele getClientele() {
        return clientele;
    }

    public void setClientele(Clientele clientele) {
        this.clientele = clientele;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
