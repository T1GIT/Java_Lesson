package attestation_2.hibernate.orms.users_autos.dao;

import attestation_2.hibernate.utils.DaoImpl;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.Session;
import attestation_2.hibernate.orms.users_autos.models.Auto;
import attestation_2.hibernate.orms.users_autos.models.User;

import java.util.List;

public class UserDao extends DaoImpl<User> {

    public UserDao(){}

    public User findById(int id){
        Session session = HibernateSession.getSession();
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        Session session = HibernateSession.getSession();
        return (List<User>) session.createQuery("From User").list();
    }

    public Auto findAutoById(int id){
        return HibernateSession.getSession().get(Auto.class, id);
    }

}
