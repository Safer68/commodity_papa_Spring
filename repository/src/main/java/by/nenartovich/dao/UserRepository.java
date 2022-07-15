package by.nenartovich.dao;

import by.nenartovich.entity.Product;
import by.nenartovich.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
