package attestation_2.databases.tests.dao;

import attestation_2.databases.tests.models.Schedule;
import attestation_2.databases.tests.utils.DaoImpl;
import attestation_2.databases.tests.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class ScheduleDao extends DaoImpl<Schedule> {

    public ScheduleDao() {}


    public Schedule findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(Schedule.class, id);
    }

    @Override
    public List<Schedule> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<Schedule>) session.createQuery("From Schedule").list();
    }
}
