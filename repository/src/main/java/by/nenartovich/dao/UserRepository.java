package by.nenartovich.dao;

import by.nenartovich.entity.Role;
import by.nenartovich.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    @Query("select e.roles from User e where e.userName=?1")
    Set<Role> getRoleUser(String userName);
}
