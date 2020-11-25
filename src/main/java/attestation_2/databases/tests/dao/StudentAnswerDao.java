package attestation_2.databases.tests.dao;

import attestation_2.databases.tests.models.StudentAnswer;
import attestation_2.databases.tests.utils.DaoImpl;
import attestation_2.databases.tests.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class StudentAnswerDao extends DaoImpl<StudentAnswer> {

    public StudentAnswerDao() {}


    public StudentAnswer findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(StudentAnswer.class, id);
    }

    @Override
    public List<StudentAnswer> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<StudentAnswer>) session.createQuery("From StudentAnswer").list();
    }
}
