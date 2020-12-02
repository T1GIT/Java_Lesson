import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import attestation_2.hibernate.users_autos.models.Auto;
import attestation_2.hibernate.users_autos.models.User;
import attestation_2.hibernate.users_autos.services.*;

class AutoTest {
    private void init() {
        HibernateSession.setConf(new Configuration().configure("users_autos.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Auto.class)
        );
    }

    @Test
    void setUser() {
        init();
        UserService userService = new UserService();
        AutoService autoService = new AutoService();
        for (User user: userService.findAllUsers()) {
            System.out.println(user);
            Auto auto = new Auto("model_" + user.getId(), "red");
            auto.setUser(user);
            autoService.saveAuto(auto);
        }
    }
}