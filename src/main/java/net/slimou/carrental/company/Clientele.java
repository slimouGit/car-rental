package net.slimou.carrental.company;


import net.slimou.carrental.clientele.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clientele")
public class Clientele {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office")
    private Office office;

    @OneToMany(mappedBy="clientele")
    private List<Customer> customers;

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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
