package net.slimou.carrental.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteleRepository extends JpaRepository<Clientele, Integer> {
}
