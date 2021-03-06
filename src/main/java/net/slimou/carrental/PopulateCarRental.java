package net.slimou.carrental;

import net.slimou.carrental.clientele.Account;
import net.slimou.carrental.clientele.repository.AccountRepository;
import net.slimou.carrental.clientele.Customer;
import net.slimou.carrental.clientele.repository.CustomerRepository;
import net.slimou.carrental.company.*;
import net.slimou.carrental.company.repository.*;
import net.slimou.carrental.contactinformation.Adress;
import net.slimou.carrental.contactinformation.repository.AdressRepository;
import net.slimou.carrental.contactinformation.Communication;
import net.slimou.carrental.contactinformation.repository.CommunicationRepository;
import net.slimou.carrental.reservation.Drive;
import net.slimou.carrental.reservation.repository.DriveRepository;
import net.slimou.carrental.fleet.Car;
import net.slimou.carrental.fleet.repository.CarRepository;
import net.slimou.carrental.reservation.Invoice;
import net.slimou.carrental.reservation.repository.InvoiceRepository;
import net.slimou.carrental.reservation.Reservation;
import net.slimou.carrental.reservation.repository.ReservationRepository;
import net.slimou.carrental.human.Person;
import net.slimou.carrental.human.repository.PersonRepository;
import net.slimou.carrental.human.Person_Data;
import net.slimou.carrental.human.repository.Person_DataRepository;
import net.slimou.carrental.staff.Employee;
import net.slimou.carrental.staff.repository.EmployeeRepository;
import net.slimou.carrental.staff.OrderBook;
import net.slimou.carrental.staff.repository.OrderBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class PopulateCarRental {

    Logger logger = LoggerFactory.getLogger(PopulateCarRental.class);

    private AdressRepository adressRepository;
    private CommunicationRepository communicationRepository;
    private OfficeRepository officeRepository;
    private Office_DataRepository office_dataRepository;
    private PersonRepository personRepository;
    private Person_DataRepository person_dataRepository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;
    private CarRepository carRepository;
    private DriveRepository driveRepository;
    private FleetRepository fleetRepository;
    private StaffRepository staffRepository;
    private ClienteleRepository clienteleRepository;
    private AccountRepository accountRepository;
    private InvoiceRepository invoiceRepository;
    private ReservationRepository reservationRepository;
    private OrderBookRepository orderBookRepository;

    public PopulateCarRental(AdressRepository adressRepository,
                             CommunicationRepository communicationRepository,
                             OfficeRepository officeRepository,
                             Office_DataRepository office_dataRepository,
                             PersonRepository personRepository,
                             Person_DataRepository person_dataRepository,
                             EmployeeRepository employeeRepository,
                             CustomerRepository customerRepository,
                             CarRepository carRepository,
                             DriveRepository driveRepository,
                             FleetRepository fleetRepository,
                             StaffRepository staffRepository,
                             ClienteleRepository clienteleRepository,
                             AccountRepository accountRepository,
                             InvoiceRepository invoiceRepository,
                             ReservationRepository reservationRepository,
                             OrderBookRepository orderBookRepository) {
        this.adressRepository = adressRepository;
        this.communicationRepository = communicationRepository;
        this.officeRepository = officeRepository;
        this.office_dataRepository = office_dataRepository;
        this.personRepository = personRepository;
        this.person_dataRepository = person_dataRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.driveRepository = driveRepository;
        this.fleetRepository = fleetRepository;
        this.staffRepository = staffRepository;
        this.clienteleRepository = clienteleRepository;
        this.accountRepository = accountRepository;
        this.invoiceRepository = invoiceRepository;
        this.reservationRepository = reservationRepository;
        this.orderBookRepository = orderBookRepository;
    }

    @Bean
    public CommandLineRunner createPerson() {
        return args -> {

            Person p1 = new Person("Max", "Mustermann");
            this.personRepository.save(p1);

            Adress a1 = new Adress("Musterweg", "42", 60439, "Musterstadt");
            this.adressRepository.save(a1);


            Communication c1 = new Communication("max@mustermann.de", "069-123456789");
            this.communicationRepository.save(c1);

            Person_Data pd1 = new Person_Data();
            pd1.setPerson(p1);
            pd1.setAdress(a1);
            pd1.setCommunication(c1);
            this.person_dataRepository.save(pd1);

            p1.setPerson_data(pd1);
            this.personRepository.save(p1);
            a1.setPerson_data(pd1);
            this.adressRepository.save(a1);
            c1.setPerson_data(pd1);
            this.communicationRepository.save(c1);

            //--------------------------------------------

            Person p2 = new Person("Maria", "Musterfrau");
            this.personRepository.save(p2);

            Adress a2 = new Adress("Bach", "15", 60439, "Musterstadt");
            this.adressRepository.save(a2);

            Communication c2 = new Communication("maria@musterfrau.de", "069-123456789");
            this.communicationRepository.save(c2);

            Person_Data pd2 = new Person_Data();
            pd2.setPerson(p2);
            pd2.setAdress(a2);
            pd2.setCommunication(c2);
            this.person_dataRepository.save(pd2);

            p2.setPerson_data(pd2);
            this.personRepository.save(p2);
            a2.setPerson_data(pd2);
            this.adressRepository.save(a2);
            c2.setPerson_data(pd2);
            this.communicationRepository.save(c2);

            //--------------------------------------------

            Person p3 = new Person("Karl", "Lohse");
            this.personRepository.save(p3);

            Adress a3 = new Adress("Schwengelgasse", "12", 60439, "Frankfurt");
            this.adressRepository.save(a3);

            Communication c3 = new Communication("karl@lohse.de", "069-123456789");
            this.communicationRepository.save(c3);

            Person_Data pd3 = new Person_Data();
            pd3.setPerson(p3);
            pd3.setAdress(a3);
            pd3.setCommunication(c3);
            this.person_dataRepository.save(pd3);

            p3.setPerson_data(pd3);
            this.personRepository.save(p3);
            a3.setPerson_data(pd3);
            this.adressRepository.save(a3);
            c3.setPerson_data(pd3);
            this.communicationRepository.save(c3);

            //--------------------------------------------

            Office o1 = new Office("Car 42");
            this.officeRepository.save(o1);

            Adress a4 = new Adress("Zeil", "3", 12345, "Fressgass");
            this.adressRepository.save(a4);

            Communication c4 = new Communication("info@car42.de", "069-42424242");
            this.communicationRepository.save(c4);

            Office_Data od1 = new Office_Data();
            od1.setOffice(o1);
            od1.setAdress(a4);
            od1.setCommunication(c4);
            this.office_dataRepository.save(od1);

            o1.setOffice_data(od1);
            this.officeRepository.save(o1);
            a4.setOffice_data(od1);
            this.adressRepository.save(a4);
            c4.setOffice_data(od1);
            this.communicationRepository.save(c1);

            //--------------------------------------------

            Staff staff1 = new Staff();
            staff1.setOffice(o1);
            this.staffRepository.save(staff1);

            //--------------------------------------------

            Employee e1 = new Employee();
            e1.setRole(Employee.Role.CONSULTANT);
            e1.setSalary(64000.00);
            e1.setDate_of_employment(LocalDate.of(1972,12,30));
            e1.setPerson(p1);
            e1.setStaff(staff1);
            this.employeeRepository.save(e1);

            //--------------------------------------------

            Employee e2 = new Employee();
            e2.setRole(Employee.Role.MANAGER);
            e2.setSalary(100000.00);
            e2.setDate_of_employment(LocalDate.of(1972,12,30));
            e2.setPerson(p2);
            e2.setStaff(staff1);
            this.employeeRepository.save(e2);

            //--------------------------------------------

            staff1.setEmployees(Arrays.asList(e1,e2));
            staff1.getEmployees().forEach(e->logger.info("Employee: {}",e.getPerson().getForname()));
            o1.setStaff(staff1);
            this.officeRepository.save(o1);

            //--------------------------------------------

            Clientele clientele1 = new Clientele();
            clientele1.setOffice(o1);
            this.clienteleRepository.save(clientele1);

            //--------------------------------------------

            Customer customer1 = new Customer(LocalDate.of(1984,1,1),p3);
            customer1.setClientele(clientele1);
            this.customerRepository.save(customer1);

            //--------------------------------------------

            clientele1.setCustomers(Arrays.asList(customer1));
            clientele1.getCustomers().forEach(e->logger.info("Customer: {}",e.getPerson().getForname()));

            o1.setClientele(clientele1);
            this.officeRepository.save(o1);

            //--------------------------------------------

            Fleet fleet1 = new Fleet();
            fleet1.setOffice(o1);
            this.fleetRepository.save(fleet1);

            o1.setFleet(fleet1);
            this.officeRepository.save(o1);

            //--------------------------------------------

            Car car1 = new Car();
            car1.setModel(Car.Model.COUPE);
            car1.setSeat(2);
            car1.setLicence_number("F-LO 666");
            car1.setHorsepower(75);
            car1.setEngine(Car.Engine.AUTOMATIC);
            car1.setMileage(84.000);
            car1.setFuelstatus(25.00);
            car1.setRegistration_date(LocalDate.of(2011,1,11));
            car1.setFleet(fleet1);
            this.carRepository.save(car1);

            //--------------------------------------------

            fleet1.setCars(Arrays.asList(car1));
            fleet1.getCars().forEach(c->logger.info("Car: {}",c.getLicence_number()));

            //--------------------------------------------

            Account account1 = new Account();
            account1.setCustomer(customer1);
            this.accountRepository.save(account1);

            //--------------------------------------------

            OrderBook ob1 = new OrderBook();
            ob1.setEmployee(e1);
            this.orderBookRepository.save(ob1);

            //--------------------------------------------

            Invoice invoice1 = new Invoice();
            invoice1.setMarked_out(false);
            invoice1.setSettled_in(false);
            this.invoiceRepository.save(invoice1);

            //--------------------------------------------

            Drive d1 = new Drive();
            d1.setStart(LocalDateTime.of(2021,9,2,15,42,15));
            d1.setEnd(LocalDateTime.of(2021,9,3,16,10,2));
            d1.setCompletion(false);
            this.driveRepository.save(d1);
            
            //--------------------------------------------

            Reservation r1 = new Reservation();
            r1.setRental_start(LocalDate.of(2011,1,11));
            r1.setRental_end(LocalDate.of(2011,1,12));
            r1.setAccount(account1);
            r1.setOrderBook(ob1);
            r1.setCar(car1);
            r1.setDrive(d1);
            r1.setInvoice(invoice1);
            this.reservationRepository.save(r1);

            //--------------------------------------------

            logger.info("End");
        };
    }

}
