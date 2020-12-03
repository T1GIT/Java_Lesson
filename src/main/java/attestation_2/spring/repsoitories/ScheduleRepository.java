package attestation_2.spring.repsoitories;

import attestation_2.spring.models.Schedule;

import java.util.List;

public interface ScheduleRepository {
    List<Schedule> findByGroupId(int groupId);

    List<Schedule> findByTestListId(int testListId);
}
