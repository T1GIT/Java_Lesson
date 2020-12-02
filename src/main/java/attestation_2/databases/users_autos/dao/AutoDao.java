package attestation_2.databases.users_autos.dao;

import attestation_2.databases.utils.DaoImpl;
import attestation_2.databases.utils.HibernateSession;
import org.hibernate.Session;
import attestation_2.databases.users_autos.models.Auto;

import java.util.List;

public class AutoDao extends DaoImpl<Auto> {

    public AutoDao() {}

    public Auto findById(int id){
        Session session = HibernateSession.getSession();
        return session.get(Auto.class, id);
    }

    @Override
    public List<Auto> getAll() {
        Session session = HibernateSession.getSession();
        return (List<Auto>) session.createQuery("From Auto").list();
    }
}
