package net.slimou.carrental;

import net.slimou.carrental.adress.Adress;
import net.slimou.carrental.adress.AdressRepository;
import net.slimou.carrental.communication.Communication;
import net.slimou.carrental.communication.CommunicationRepository;
import net.slimou.carrental.customer.Customer;
import net.slimou.carrental.customer.CustomerRepository;
import net.slimou.carrental.employee.Employee;
import net.slimou.carrental.employee.EmployeeRepository;
import net.slimou.carrental.office.Office;
import net.slimou.carrental.office.OfficeRepository;
import net.slimou.carrental.office.Office_Data;
import net.slimou.carrental.office.Office_DataRepository;
import net.slimou.carrental.person.Person;
import net.slimou.carrental.person.PersonRepository;
import net.slimou.carrental.person.Person_Data;
import net.slimou.carrental.person.Person_DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    public PopulateCarRental(AdressRepository adressRepository,
                             CommunicationRepository communicationRepository,
                             OfficeRepository officeRepository,
                             Office_DataRepository office_dataRepository,
                             PersonRepository personRepository,
                             Person_DataRepository person_dataRepository,
                             EmployeeRepository employeeRepository,
                             CustomerRepository customerRepository) {
        this.adressRepository = adressRepository;
        this.communicationRepository = communicationRepository;
        this.officeRepository = officeRepository;
        this.office_dataRepository = office_dataRepository;
        this.personRepository = personRepository;
        this.person_dataRepository = person_dataRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
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

            //--------------------------------------------

            Employee e1 = new Employee();
            e1.setRole(Employee.Role.CONSULTANT);
            e1.setSalary(64000.00);
            e1.setDate_of_employment(LocalDate.of(1972,12,30));
            e1.setPerson(p1);
            e1.setOffice(o1);
            this.employeeRepository.save(e1);

            //--------------------------------------------

            Employee e2 = new Employee();
            e2.setRole(Employee.Role.MANAGER);
            e2.setSalary(100000.00);
            e2.setDate_of_employment(LocalDate.of(1972,12,30));
            e2.setPerson(p2);
            e2.setOffice(o1);
            this.employeeRepository.save(e2);

            //--------------------------------------------

            o1.setEmployees(Arrays.asList(e1,e2));
            logger.info("Employees {}", o1.getEmployees());
            o1.getEmployees().forEach(e->logger.info("E: {}",e.getPerson().getForname()));

            //--------------------------------------------

            Customer customer1 = new Customer(LocalDate.of(1984,01,01),p3);
            customer1.setOffice(o1);
            this.customerRepository.save(customer1);

            //--------------------------------------------

            o1.setCustomers(Arrays.asList(customer1));
            logger.info("Employees {}", o1.getEmployees());
            o1.getEmployees().forEach(e->logger.info("E: {}",e.getPerson().getForname()));


        };
    }
}
