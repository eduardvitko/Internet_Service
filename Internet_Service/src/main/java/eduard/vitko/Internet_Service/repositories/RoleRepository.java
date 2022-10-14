package eduard.vitko.Internet_Service.repositories;

import eduard.vitko.Internet_Service.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
