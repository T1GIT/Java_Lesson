package attestation_2.spring.repsoitories;

import attestation_2.spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoleId(int roleId);

    List<User> findByGroupId(int groupId);
}
