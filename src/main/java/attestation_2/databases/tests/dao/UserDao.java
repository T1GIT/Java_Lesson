package attestation_2.databases.tests.dao;

import attestation_2.databases.tests.models.User;
import attestation_2.databases.tests.utils.DaoImpl;
import attestation_2.databases.tests.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class UserDao extends DaoImpl<User> {

    public UserDao() {}


    public User findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<User>) session.createQuery("From User").list();
    }
}
