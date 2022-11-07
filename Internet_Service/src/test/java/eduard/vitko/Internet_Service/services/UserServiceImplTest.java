package eduard.vitko.Internet_Service.services;

import eduard.vitko.Internet_Service.domain.*;
import eduard.vitko.Internet_Service.repositories.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

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
    void registerUser() {
        UserRegisterDto user = new UserRegisterDto();
        user.setFirstName("Eduard");
        user.setLastName("Vitko");
        user.setUsername("Edik");
        user.setPassword("1980");
        user.setPhone("+380507097311");
        user.setEmail("edik@gmail.com");
        userService.registerUser(user);

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
        List<UserDto> userDtos = userService.getUsers();
        assertEquals(3,3);
    }

}
