package net.slimou.carrental.fleet;

import net.slimou.carrental.company.Fleet;
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

    @Column(name="fuelstatus")
    private Double fuelstatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="registration_date")
    private LocalDate registration_date;

    @ManyToOne
    private Fleet fleet;


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

    public Double getFuelstatus() {
        return fuelstatus;
    }

    public void setFuelstatus(Double fuelstatus) {
        this.fuelstatus = fuelstatus;
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
