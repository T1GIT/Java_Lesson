package attestation_2.hibernate.users_autos.services;

import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import attestation_2.hibernate.users_autos.models.Auto;
import attestation_2.hibernate.users_autos.models.User;

class UserServiceTest {
    private void init() {
        HibernateSession.setConf(new Configuration().configure("users_autos.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Auto.class)
        );
    }

    @Test
    void findAllUsers() {
        UserService userService = new UserService();
        for (User user: userService.findAllUsers()) {
            System.out.println(user);
        }
    }
}