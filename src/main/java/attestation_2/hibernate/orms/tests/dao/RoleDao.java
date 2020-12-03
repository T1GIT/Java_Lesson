package attestation_2.hibernate.orms.tests.dao;

import attestation_2.hibernate.orms.tests.models.Role;
import attestation_2.hibernate.utils.DaoImpl;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class RoleDao extends DaoImpl<Role> {

    public RoleDao() {}

    @Override
    public Role findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(Role.class, id);
    }

    @Override
    public List<Role> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<Role>) session.createQuery("From Role").list();
    }
}
