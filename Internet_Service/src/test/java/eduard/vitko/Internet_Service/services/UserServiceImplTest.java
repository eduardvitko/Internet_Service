package eduard.vitko.Internet_Service.services;

import eduard.vitko.Internet_Service.domain.Role;
import eduard.vitko.Internet_Service.domain.User;
import eduard.vitko.Internet_Service.repositories.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserServiceImpl userService;
    @Resource
    private RoleRepository roleRepository;
    @Test
    void loadUserByUsername() {
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setName("Marina");
        user.setUsername("Marina");
        user.setPassword("2012");
        userService.saveUser(user);

    }

    @Test
    void saveRole() {
        Role role = new Role(0L, "ROLE_USER");
        userService.saveRole(role);
        String roleUser = roleRepository.findByName("ROLE_USER").getName();
        assertEquals(1, 1);
    }

    @Test
    void addRoleToUser() {
    }

    @Test
    void getUser() {
        User user = userService.getUser("Ed");
        assertEquals(1, 1);
        assertNotNull(user);

    }

    @Test
    void getUsers() {
    }

}
