package net.slimou.carrental.company.repository;

import net.slimou.carrental.company.Clientele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteleRepository extends JpaRepository<Clientele, Integer> {
}
