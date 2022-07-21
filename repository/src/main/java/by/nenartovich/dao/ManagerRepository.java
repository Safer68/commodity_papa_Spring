package by.nenartovich.dao;

import by.nenartovich.entity.Manager;
import by.nenartovich.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByName(String managerName);
    @Query("select e.orders from Manager e where e.id=?1")
    List<Order> getManagerOrders(Long managerId);
    @Query("select e.orders from Manager e where e.name=?1")
    List<Order> getManagerOrders (String managerName);
    @Query("select e.orders from Manager e where e.id=?2")
    Page<Order> findAll(Pageable paged,Long managerId);
    @Query("select e from Manager e where e.user.userName=?1")
    Manager findByUserName(String userName);
}