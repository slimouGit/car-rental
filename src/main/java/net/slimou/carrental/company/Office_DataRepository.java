package net.slimou.carrental.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Office_DataRepository extends JpaRepository<Office_Data, Integer> {
}
