package eduard.vitko.Internet_Service.services;

import eduard.vitko.Internet_Service.domain.Role;
import eduard.vitko.Internet_Service.domain.User;
import eduard.vitko.Internet_Service.domain.UserDto;
import eduard.vitko.Internet_Service.domain.UserRegisterDto;

import java.util.List;

public interface UserService {
    UserDto registerUser(UserRegisterDto registerDto);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<UserDto> getUsers();
}
