package attestation_2.databases.tests;


import attestation_2.databases.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import attestation_2.databases.tests.models.*;

public class TestTests {
    private static void init() {
        HibernateSession.setConf(new Configuration().configure("tests.cfg.xml")
                .addAnnotatedClass(StudentAnswer.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(TestList.class)
                .addAnnotatedClass(Schedule.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Test.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Subject.class)
        );
    }

    public static void main(String[] args) {
        init();
    }
}
