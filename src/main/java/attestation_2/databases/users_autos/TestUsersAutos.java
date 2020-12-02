package attestation_2.databases.users_autos;

import attestation_2.databases.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import attestation_2.databases.users_autos.models.*;


public class TestUsersAutos {
    private static void init() {
        HibernateSession.setConf(new Configuration().configure("tests.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Auto.class)
        );
    }

    public static void main(String[] args) {
        init();
    }
}
