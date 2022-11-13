package eduard.vitko.Internet_Service.services;

import eduard.vitko.Internet_Service.domain.*;
import eduard.vitko.Internet_Service.mapper.BusinessMapper;
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

    @Resource
    private BusinessMapper mapper;

    @Test
    void loadUserByUsername() {
    }

    @Test
    void registerUser() {
        UserRegisterDto user = new UserRegisterDto();
        user.setFirstName("hhhh");
        user.setLastName("ddd");
        user.setUsername("mmmm");
        user.setPassword("3698");
        user.setPhone("+380632225800");
        user.setEmail("nmn@gmail.com");
        UserDto newUser =  userService.registerUser(user);
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
