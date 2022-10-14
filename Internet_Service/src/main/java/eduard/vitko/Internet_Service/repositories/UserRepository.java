package eduard.vitko.Internet_Service.repositories;

import eduard.vitko.Internet_Service.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
