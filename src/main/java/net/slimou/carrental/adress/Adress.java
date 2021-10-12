package net.slimou.carrental.adress;

import net.slimou.carrental.office.Office_Data;
import net.slimou.carrental.person.Person_Data;

import javax.persistence.*;

@Entity
@Table(name="adress")
public class Adress {

    public Adress() {
    }

    public Adress(String street, String housenumber, Integer zipcode, String location) {
        this.street = street;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.location = location;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="street")
    private String street;

    @Column(name="housenumber")
    private String housenumber;

    @Column(name="zipcode")
    private Integer zipcode;

    @Column(name="location")
    private String location;

    @OneToOne(mappedBy = "adress", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Office_Data office_data;

    @OneToOne(mappedBy = "adress", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Person_Data person_data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Office_Data getOffice_data() {
        return office_data;
    }

    public void setOffice_data(Office_Data office_data) {
        this.office_data = office_data;
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

        Adress adress = (Adress) o;

        if (id != null ? !id.equals(adress.id) : adress.id != null) return false;
        if (street != null ? !street.equals(adress.street) : adress.street != null) return false;
        if (housenumber != null ? !housenumber.equals(adress.housenumber) : adress.housenumber != null) return false;
        if (zipcode != null ? !zipcode.equals(adress.zipcode) : adress.zipcode != null) return false;
        return location != null ? location.equals(adress.location) : adress.location == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (housenumber != null ? housenumber.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                ", zipcode=" + zipcode +
                ", location='" + location + '\'' +
                '}';
    }
}
