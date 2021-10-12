package net.slimou.carrental.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Person_DataRepository extends JpaRepository<Person_Data, Integer> {
}
