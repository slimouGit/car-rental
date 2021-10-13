package net.slimou.carrental.person;

import net.slimou.carrental.adress.Adress;
import net.slimou.carrental.communication.Communication;

import javax.persistence.*;

@Entity
@Table(name = "person_data")
public class Person_Data {

    public Person_Data() {
    }

    public Person_Data(Person person, Adress adress, Communication communication) {
        this.person = person;
        this.adress = adress;
        this.communication = communication;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person")
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Communication getCommunication() {
        return communication;
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }
}
