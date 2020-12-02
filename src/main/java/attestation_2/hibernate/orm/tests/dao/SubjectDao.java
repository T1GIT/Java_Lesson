package attestation_2.hibernate.orm.tests.dao;

import attestation_2.hibernate.orm.tests.models.Subject;
import attestation_2.hibernate.utils.DaoImpl;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class SubjectDao extends DaoImpl<Subject> {

    public SubjectDao() {}


    @Override
    public Subject findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(Subject.class, id);
    }

    @Override
    public List<Subject> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<Subject>) session.createQuery("From Subject").list();
    }
}
