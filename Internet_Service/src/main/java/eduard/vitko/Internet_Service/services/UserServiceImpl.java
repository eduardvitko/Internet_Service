package eduard.vitko.Internet_Service.services;

import eduard.vitko.Internet_Service.domain.Role;
import eduard.vitko.Internet_Service.domain.User;
import eduard.vitko.Internet_Service.domain.UserDto;
import eduard.vitko.Internet_Service.domain.UserRegisterDto;
import eduard.vitko.Internet_Service.mapper.BusinessMapper;
import eduard.vitko.Internet_Service.repositories.RoleRepository;
import eduard.vitko.Internet_Service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final BusinessMapper businessMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            log.error("User not found in the my database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    @Override
    public User registerUser(UserRegisterDto userRegisterDto) {
        log.info("Saving new user {} to the database", userRegisterDto.getUsername());
        User userNew = new User();
        userNew.setFirstName(userRegisterDto.getFirstName());
        userNew.setLastName(userRegisterDto.getLastName());
        userNew.setUsername(userRegisterDto.getUsername());
        userNew.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userNew.setPhone(userRegisterDto.getPhone());
        userNew.setEmail(userRegisterDto.getEmail());
        Role role = roleRepository.findByName("ROLE_USER");
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(role);
        userNew.setRoles(roles);
        return userRepository.save(userNew);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        User findUser = userRepository.findByUsername(username);
        if (findUser == null) {
            log.error("User not found is Database");
        }
        return findUser;
    }

    @Override
    public List<UserDto> getUsers() {
        log.info("Fetching all users");
        List<User> users = userRepository.findAll();
        List<UserDto> dtoList = businessMapper.userDtoList(users);
        return dtoList;
    }
}
