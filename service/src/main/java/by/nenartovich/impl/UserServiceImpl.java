package by.nenartovich.impl;

import by.nenartovich.UserService;
import by.nenartovich.dao.UserRepository;
import by.nenartovich.dto.RoleDto;
import by.nenartovich.mappers.RoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleMapper roleMapper;

    @Override
    public Set<RoleDto> getRoleUser(String userName) {
        return userRepository.getRoleUser(userName).stream()
                .map(roleMapper::roleToRoleDto)
                .collect(Collectors.toSet());
    }
}
