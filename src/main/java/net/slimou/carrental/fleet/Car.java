package net.slimou.carrental.fleet;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="car")
public class Car {

    public enum Model{
        LIMOUSINE, SUV, ROADSTAR, COUPE
    }

    public enum Engine{
        AUTOMATIC, SHIFTER
    }

    public Car() {
    }

    public Car(Model model,
               Integer seat,
               String licence_number,
               Integer horsepower,
               Engine engine,
               Double mileage,
               LocalDate registration_data) {
        this.model = model;
        this.seat = seat;
        this.licence_number = licence_number;
        this.horsepower = horsepower;
        this.engine = engine;
        this.mileage = mileage;
        this.registration_date = registration_date;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="model")
    @Enumerated(EnumType.STRING)
    private Car.Model model ;

    @Column(name="seat")
    private Integer seat;

    @Column(name="licence_number")
    private String licence_number;

    @Column(name="horsepower")
    private Integer horsepower;

    @Column(name="engine")
    @Enumerated(EnumType.STRING)
    private Car.Engine engine ;

    @Column(name="mileage")
    private Double mileage;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="registration_date")
    private LocalDate registration_date;

    @ManyToOne
    private Fleet fleet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (model != car.model) return false;
        if (seat != null ? !seat.equals(car.seat) : car.seat != null) return false;
        if (licence_number != null ? !licence_number.equals(car.licence_number) : car.licence_number != null)
            return false;
        if (horsepower != null ? !horsepower.equals(car.horsepower) : car.horsepower != null) return false;
        if (engine != car.engine) return false;
        if (mileage != null ? !mileage.equals(car.mileage) : car.mileage != null) return false;
        if (registration_date != null ? !registration_date.equals(car.registration_date) : car.registration_date != null)
            return false;
        return fleet != null ? fleet.equals(car.fleet) : car.fleet == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (licence_number != null ? licence_number.hashCode() : 0);
        result = 31 * result + (horsepower != null ? horsepower.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (mileage != null ? mileage.hashCode() : 0);
        result = 31 * result + (registration_date != null ? registration_date.hashCode() : 0);
        result = 31 * result + (fleet != null ? fleet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model=" + model +
                ", seat=" + seat +
                ", licence_number='" + licence_number + '\'' +
                ", horsepower=" + horsepower +
                ", engine=" + engine +
                ", mileage=" + mileage +
                ", registration_data=" + registration_date +
                ", fleet=" + fleet +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public String getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }
}
