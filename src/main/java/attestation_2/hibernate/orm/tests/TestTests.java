package attestation_2.hibernate.orm.tests;


import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import attestation_2.hibernate.orm.tests.models.*;

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
