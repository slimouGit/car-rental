package net.slimou.carrental.employee;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {
}
