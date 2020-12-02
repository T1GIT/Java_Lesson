package tests;

import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import attestation_2.hibernate.orm.tests.models.*;
import attestation_2.hibernate.orm.tests.services.UserService;

class UserServiceTest {
    private void init() {
        HibernateSession.setConf(new Configuration().configure("tests.cfg.xml")
                .addAnnotatedClass(StudentAnswer.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(TestList.class)
                .addAnnotatedClass(Schedule.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(attestation_2.hibernate.orm.tests.models.Test.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Subject.class)
        );
    }

    @Test
    void findAllUsers() {
        init();
        UserService userService = new UserService();
        for (User user: userService.findAllUsers()) {
            System.out.println(user);
        }

//        for (int i = 0; i < 10; i++) {
//            userService.saveUser(new User("name_" + i, "a", "a", "aa" + i, "ijfije"));
//        }
    }
}