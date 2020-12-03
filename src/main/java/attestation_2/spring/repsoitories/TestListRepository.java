package attestation_2.spring.repsoitories;

import attestation_2.spring.models.TestList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestListRepository extends JpaRepository<TestList, Integer> {
    List<TestList> findBySubjectId(int subjectId);

    List<TestList> findByTeacherId(int teacherId);
}
