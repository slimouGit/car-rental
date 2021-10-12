package net.slimou.carrental;

import net.slimou.carrental.adress.Adress;
import net.slimou.carrental.adress.AdressRepository;
import net.slimou.carrental.communication.Communication;
import net.slimou.carrental.communication.CommunicationRepository;
import net.slimou.carrental.office.OfficeRepository;
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

    public PopulateCarRental(AdressRepository adressRepository, CommunicationRepository communicationRepository,
                             OfficeRepository officeRepository, Office_DataRepository office_dataRepository,
                             PersonRepository personRepository, Person_DataRepository person_dataRepository) {
        this.adressRepository = adressRepository;
        this.communicationRepository = communicationRepository;
        this.officeRepository = officeRepository;
        this.office_dataRepository = office_dataRepository;
        this.personRepository = personRepository;
        this.person_dataRepository = person_dataRepository;
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


        };
    }
}
