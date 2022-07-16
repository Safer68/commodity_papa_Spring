package by.nenartovich;

import by.nenartovich.dto.RoleDto;

import java.util.Set;

public interface UserService {

    Set<RoleDto> getRoleUser(String userName);

}
