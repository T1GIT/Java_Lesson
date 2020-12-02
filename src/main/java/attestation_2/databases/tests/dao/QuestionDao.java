package attestation_2.databases.tests.dao;

import attestation_2.databases.tests.models.Question;
import attestation_2.databases.utils.DaoImpl;
import attestation_2.databases.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class QuestionDao extends DaoImpl<Question> {

    public QuestionDao() {}


    public Question findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(Question.class, id);
    }

    @Override
    public List<Question> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<Question>) session.createQuery("From Question").list();
    }
}
