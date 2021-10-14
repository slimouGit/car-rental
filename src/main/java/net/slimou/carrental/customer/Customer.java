package net.slimou.carrental.customer;

import net.slimou.carrental.person.Person;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="customer")
public class Customer {

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


}
