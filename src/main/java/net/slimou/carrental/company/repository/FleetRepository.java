package net.slimou.carrental.company.repository;

import net.slimou.carrental.company.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetRepository extends JpaRepository<Fleet,Integer> {
}
