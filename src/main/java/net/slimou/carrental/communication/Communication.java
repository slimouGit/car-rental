package net.slimou.carrental.communication;

import net.slimou.carrental.office.Office_Data;
import net.slimou.carrental.person.Person_Data;

import javax.persistence.*;

@Entity
@Table(name="communication")
public class Communication {

    public Communication() {
    }

    public Communication(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public enum Communication_Type{
        EMAIL, PHONE
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @OneToOne(mappedBy = "communication", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Office_Data office_data;

    @OneToOne(mappedBy = "communication", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Person_Data person_data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Communication that = (Communication) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (office_data != null ? !office_data.equals(that.office_data) : that.office_data != null) return false;
        return person_data != null ? person_data.equals(that.person_data) : that.person_data == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (office_data != null ? office_data.hashCode() : 0);
        result = 31 * result + (person_data != null ? person_data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Communication{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", office_data=" + office_data +
                ", person_data=" + person_data +
                '}';
    }
}
