package attestation_2.databases.tests.services;

import attestation_2.databases.tests.dao.ScheduleDao;
import attestation_2.databases.tests.models.Schedule;

import java.util.List;

public class ScheduleService {
    private final ScheduleDao scheduleDao = new ScheduleDao();

    public ScheduleService() {
    }

    public Schedule findSchedule(int id) {
        return scheduleDao.findById(id);
    }

    public void saveSchedule(Schedule schedule) {
        scheduleDao.save(schedule);
    }

    public void updateSchedule(Schedule schedule) {
        scheduleDao.update(schedule);
    }

    public void deleteSchedule(Schedule schedule) {
        scheduleDao.delete(schedule);
    }

    public List<Schedule> findAllSchedules() {
        return scheduleDao.getAll();
    }
}