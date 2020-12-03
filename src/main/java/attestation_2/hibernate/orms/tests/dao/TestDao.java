package attestation_2.hibernate.orms.tests.dao;

import attestation_2.hibernate.orms.tests.models.Test;
import attestation_2.hibernate.utils.DaoImpl;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class TestDao extends DaoImpl<Test> {

    public TestDao() {}


    public Test findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(Test.class, id);
    }

    @Override
    public List<Test> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<Test>) session.createQuery("From Test").list();
    }
}
