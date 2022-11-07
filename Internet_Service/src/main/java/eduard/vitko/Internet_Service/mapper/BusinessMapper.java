package eduard.vitko.Internet_Service.mapper;

import eduard.vitko.Internet_Service.domain.Role;
import eduard.vitko.Internet_Service.domain.RoleDto;
import eduard.vitko.Internet_Service.domain.User;
import eduard.vitko.Internet_Service.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessMapper {

    public UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        userDto.setActive(user.isActive());
        userDto.setBalance(user.getBalance());
        userDto.setRoles(user.getRoles().stream().map(role -> toRoleDto(role)).collect(Collectors.toList()));
        return userDto;
    }

    public User convertToUserEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setActive(userDto.isActive());
        user.setBalance(userDto.getBalance());
        user.setRoles(userDto.getRoles().stream().map(roleDto -> toRoleEntity(roleDto)).collect(Collectors.toList()));
        return user;
    }
    public RoleDto toRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }

    public Role toRoleEntity(RoleDto roleDto) {
        Role role1 = new Role();
        role1.setId(roleDto.getId());
        role1.setName(roleDto.getName());
        return role1;
    }
    public List<UserDto> userDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        return users.stream().map(user -> convertToUserDto(user)).collect(Collectors.toList());
    }

}
