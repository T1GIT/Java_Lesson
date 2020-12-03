package attestation_2.hibernate.orms.tests.dao;

import attestation_2.hibernate.orms.tests.models.Group;
import attestation_2.hibernate.utils.DaoImpl;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class GroupDao extends DaoImpl<Group> {

    public GroupDao() {}


    @Override
    public Group findById(int id) {
        Session session = HibernateSession.getSession();
        return session.get(Group.class, id);
    }

    @Override
    public List<Group> getAll() {
        Session session = HibernateSession.getSession();
        return  (List<Group>) session.createQuery("From Group").list();
    }
}
