package users_autos;

import attestation_2.hibernate.orms.users_autos.services.AutoService;
import attestation_2.hibernate.orms.users_autos.services.UserService;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import attestation_2.hibernate.orms.users_autos.models.*;


public class MainUsersAutos {
    private static void init() {
        HibernateSession.setConf(new Configuration().configure("tests.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Auto.class)
        );

        UserService userService = new UserService();
        AutoService autoService = new AutoService();

        for (int i = 0; i < 10; i++) {
            User user = new User("name_" + i, 18 + i);
            userService.saveUser(user);
            Auto auto = new Auto("model" + i, "green");
            auto.setUser(user);
            autoService.saveAuto(auto);
        }
    }

    public static void main(String[] args) {
        init();
    }
}
