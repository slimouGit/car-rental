package net.slimou.carrental.clientele.repository;

import net.slimou.carrental.clientele.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository   extends JpaRepository<Customer, Integer> {
}
