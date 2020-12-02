package attestation_2.hibernate.tests.dao;

import attestation_2.hibernate.tests.models.TestList;
import attestation_2.hibernate.utils.DaoImpl;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class TestListDao extends DaoImpl<TestList> {

    public TestListDao() {}


    public TestList findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(TestList.class, id);
    }

    @Override
    public List<TestList> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<TestList>) session.createQuery("From TestList").list();
    }
}
