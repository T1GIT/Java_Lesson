package attestation_2.spring.repsoitories;

import attestation_2.spring.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
