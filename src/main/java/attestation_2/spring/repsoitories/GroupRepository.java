package attestation_2.spring.repsoitories;

import attestation_2.spring.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
