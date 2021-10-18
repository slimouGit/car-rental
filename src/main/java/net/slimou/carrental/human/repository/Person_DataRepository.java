package net.slimou.carrental.human.repository;

import net.slimou.carrental.human.Person_Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Person_DataRepository extends JpaRepository<Person_Data, Integer> {
}
