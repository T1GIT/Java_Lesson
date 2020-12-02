import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import attestation_2.hibernate.users_autos.models.Auto;
import attestation_2.hibernate.users_autos.models.User;
import attestation_2.hibernate.users_autos.services.UserService;

class UserServiceTest_users_autos {
    private void init() {
        HibernateSession.setConf(new Configuration().configure("users_autos.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Auto.class)
        );
    }

    @Test
    void saveUser() {
        init();
        UserService userService = new UserService();
        for (int i = 0; i < 10; i++) {
            userService.saveUser(new User("name_" + i, i));
        }
    }
}