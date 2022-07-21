package by.nenartovich.dao;

import by.nenartovich.entity.Client;
import by.nenartovich.entity.Manager;
import by.nenartovich.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByName(String name);
    @Query("select e.orders from Client e where e.id=?1")
    List<Order> getClientOrders(Long clientId);
    @Query("select e from Client e where e.user.userName=?1")
    Client findByUserName(String userName);
}
