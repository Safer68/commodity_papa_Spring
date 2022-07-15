package by.nenartovich.impl;

import by.nenartovich.dao.ManagerRepository;
import by.nenartovich.dao.UserRepository;
import by.nenartovich.entity.Manager;
import by.nenartovich.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user " + username + "!");
        }

        return new UserDetailsImpl(user);
    }

}
