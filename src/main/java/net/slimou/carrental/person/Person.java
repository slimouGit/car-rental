package net.slimou.carrental.person;

import net.slimou.carrental.communication.Communication;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="person")
public class Person {

    public Person() {
    }

    public Person(String forname, String lastname) {
        this.forname = forname;
        this.lastname = lastname;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="forname")
    private String forname;

    @Column(name="lastname")
    private String lastname;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Person_Data person_data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Person_Data getPerson_data() {
        return person_data;
    }

    public void setPerson_data(Person_Data person_data) {
        this.person_data = person_data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (forname != null ? !forname.equals(person.forname) : person.forname != null) return false;
        return lastname != null ? lastname.equals(person.lastname) : person.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (forname != null ? forname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", forname='" + forname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
