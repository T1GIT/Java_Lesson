package attestation_2.hibernate.tests.dao;

import attestation_2.hibernate.tests.models.Answer;
import attestation_2.hibernate.utils.DaoImpl;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class AnswerDao extends DaoImpl<Answer> {

    public AnswerDao() {}


    public Answer findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(Answer.class, id);
    }

    @Override
    public List<Answer> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<Answer>) session.createQuery("From Answer").list();
    }
}
