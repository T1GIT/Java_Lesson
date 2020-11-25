package attestation_2.databases.tests.utils;

import attestation_2.databases.tests.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class HibernateSession {

    private static SessionFactory sessionFactory;

    private HibernateSession(){}

    public static Session getSession() {
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Answer.class);
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Question.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Schedule.class);
                configuration.addAnnotatedClass(StudentAnswer.class);
                configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(Test.class);
                configuration.addAnnotatedClass(TestList.class);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory.openSession();
    }
}
