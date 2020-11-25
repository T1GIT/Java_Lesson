package attestation_2.databases.tests.dao;

import attestation_2.databases.tests.models.TestList;
import attestation_2.databases.tests.utils.DaoImpl;
import attestation_2.databases.tests.utils.HibernateSession;
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