package by.nenartovich.impl;

import by.nenartovich.UserService;
import by.nenartovich.dao.RoleRepository;
import by.nenartovich.dao.UserRepository;
import by.nenartovich.dto.RoleDto;
import by.nenartovich.dto.UserDto;
import by.nenartovich.entity.User;
import by.nenartovich.mappers.RoleMapper;
import by.nenartovich.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;

    @Override
    public Set<RoleDto> getRoleUser(String userName) {
        return userRepository.getRoleUser(userName).stream()
                .map(roleMapper::roleToRoleDto)
                .collect(Collectors.toSet());
    }

    @Override
    public UserDto saveUser(UserDto userDto, String roleName) {
        User user = userMapper.userDtoToUser(userDto);
        user.setRoles(new HashSet<>());
        user.setActive(true);
        user.getRoles().add(roleRepository.findByName(roleName));
        user.setPassword(encoder.encode(user.getUserName()));
        return userMapper.userToUserDto(userRepository.save(user));
    }
}
