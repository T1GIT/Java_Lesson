package attestation_2.hibernate.orm.tests.dao;

import attestation_2.hibernate.orm.tests.models.Question;
import attestation_2.hibernate.utils.DaoImpl;
import attestation_2.hibernate.utils.HibernateSession;
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
