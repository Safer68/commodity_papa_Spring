package by.nenartovich;

import by.nenartovich.dto.RoleDto;
import by.nenartovich.dto.UserDto;

import java.util.Set;

public interface UserService {

    Set<RoleDto> getRoleUser(String userName);

    UserDto saveUser(UserDto userDto, String roleName);

}
