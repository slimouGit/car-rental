package net.slimou.carrental;

import net.slimou.carrental.adress.Adress;
import net.slimou.carrental.adress.AdressRepository;
import net.slimou.carrental.communication.Communication;
import net.slimou.carrental.communication.CommunicationRepository;
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

    public PopulateCarRental(AdressRepository adressRepository, CommunicationRepository communicationRepository, OfficeRepository officeRepository, Office_DataRepository office_dataRepository, PersonRepository personRepository, Person_DataRepository person_dataRepository, EmployeeRepository employeeRepository) {
        this.adressRepository = adressRepository;
        this.communicationRepository = communicationRepository;
        this.officeRepository = officeRepository;
        this.office_dataRepository = office_dataRepository;
        this.personRepository = personRepository;
        this.person_dataRepository = person_dataRepository;
        this.employeeRepository = employeeRepository;
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

            Office o1 = new Office("Car 42");
            this.officeRepository.save(o1);

            Adress a2 = new Adress("Zeil", "3", 12345, "Fressgass");
            this.adressRepository.save(a2);

            Communication c2 = new Communication("info@car42.de", "069-42424242");
            this.communicationRepository.save(c2);

            Office_Data od1 = new Office_Data();
            od1.setOffice(o1);
            od1.setAdress(a2);
            od1.setCommunication(c2);
            this.office_dataRepository.save(od1);

            Employee e1 = new Employee();
            e1.setRole(Employee.Role.CONSULTANT);
            e1.setSalary(64000.00);
            e1.setDate_of_employment(LocalDate.of(1972,12,30));
            e1.setPerson(p1);
            e1.setOffice(o1);
            this.employeeRepository.save(e1);



        };
    }
}
