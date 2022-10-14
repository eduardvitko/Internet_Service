package eduard.vitko.Internet_Service.services;

import eduard.vitko.Internet_Service.domain.Role;
import eduard.vitko.Internet_Service.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
