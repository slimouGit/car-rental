package net.slimou.carrental.office;

import net.slimou.carrental.adress.Adress;
import net.slimou.carrental.communication.Communication;

import javax.persistence.*;

@Entity
@Table(name="office_data")
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
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="communication")
    private Communication communication;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adress")
    private Adress adress;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office")
    private Office office;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Communication getCommunication() {
        return communication;
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office_Data that = (Office_Data) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (communication != null ? !communication.equals(that.communication) : that.communication != null)
            return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        return office != null ? office.equals(that.office) : that.office == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (communication != null ? communication.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Office_Data{" +
                "id=" + id +
                ", communication=" + communication +
                ", adress=" + adress +
                ", office=" + office +
                '}';
    }
}
