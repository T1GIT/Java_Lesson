import attestation_2.databases.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import attestation_2.databases.tests.models.*;
import attestation_2.databases.tests.services.UserService;

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
                .addAnnotatedClass(attestation_2.databases.tests.models.Test.class)
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
    }
}