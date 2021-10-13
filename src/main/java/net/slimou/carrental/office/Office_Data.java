package net.slimou.carrental.office;

import net.slimou.carrental.adress.Adress;
import net.slimou.carrental.communication.Communication;
import net.slimou.carrental.employee.Employee;

import javax.persistence.*;

@Entity
@Table(name = "office_data")
public class Office_Data {

    public Office_Data() {
    }

    public Office_Data(Communication communication, Adress adress, Office office) {
        this.communication = communication;
        this.adress = adress;
        this.office = office;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office")
    private Office office;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adress")
    private Adress adress;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "communication")
    private Communication communication;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Communication getCommunication() {
        return communication;
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }


}
