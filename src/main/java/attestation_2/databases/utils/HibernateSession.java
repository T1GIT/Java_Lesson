package attestation_2.databases.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class HibernateSession {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public static void setConf(Configuration configuration) {
        HibernateSession.configuration = configuration;
    }

    public static Session getSession() {
        if(sessionFactory == null){
            try{
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory.openSession();
    }
}
