package net.slimou.carrental.staff.repository;

import net.slimou.carrental.staff.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {
}
