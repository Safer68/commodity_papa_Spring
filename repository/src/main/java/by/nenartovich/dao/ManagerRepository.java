package by.nenartovich.dao;

import by.nenartovich.entity.Manager;
import by.nenartovich.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    @Query("select e.orders from Manager e where e.id=?1")
    List<Order> getManagerOrders(Long managerId);
}