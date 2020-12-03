package tests;


import attestation_2.hibernate.orms.tests.services.RoleService;
import attestation_2.hibernate.orms.tests.services.StudentAnswerService;
import attestation_2.hibernate.orms.tests.services.TestListService;
import attestation_2.hibernate.orms.tests.services.UserService;
import attestation_2.hibernate.utils.HibernateSession;
import org.hibernate.cfg.Configuration;
import attestation_2.hibernate.orms.tests.models.*;

public class MainTests {
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
        // Task A
        RoleService roleService = new RoleService();
        UserService userService = new UserService();

        Role teacherRole = new Role("Teacher");
        roleService.saveRole(teacherRole);
        Role studentRole = new Role("Student");
        roleService.saveRole(studentRole);
        for (int i = 0; i < 5; i++) {
            User stud = new User("stud_" + i,
                    "ln", "mn",
                    "studLogin_" + i, "ph");
            stud.setRole(studentRole);
            userService.saveUser(stud);
        }

        for (int i = 0; i < 10; i++) {
            User teach = new User("teach_" + i,
                    "ln", "mn",
                    "teachLogin_" + i, "ph");
            teach.setRole(teacherRole);
            userService.saveUser(teach);
        }

        TestListService testListService = new TestListService();
        StudentAnswerService studentAnswerService = new StudentAnswerService();

        for (User user: userService.findAllUsers()) {
            if (user.getRole().getName().equals("Student")) {
                TestList testList = new TestList("test_" + user.getFirstName());
                testListService.saveTestList(testList);
                StudentAnswer studentAnswer = new StudentAnswer();
                studentAnswer.setStudent(user);
                studentAnswer.setTestList(testList);
                studentAnswerService.saveStudentAnswer(studentAnswer);
            }
        }

        // Task B
        System.out.println("Teachers:");
        for (User user: userService.findAllUsers()) {
            if (user.getRole().getId() == teacherRole.getId()) {
                System.out.println(user);
            }
        }

        // Task C
        System.out.println("Students:");
        for (User user: userService.findAllUsers()) {
            if (user.getRole().getId() == studentRole.getId()) {
                System.out.println(user);
            }
        }

        // Task D
        System.out.println("Students:");
        for (User user: userService.findAllUsers()) {
            if (user.getRole().getId() == studentRole.getId()) {
                // Лень
            }
        }

        // Task E
        // Лень
    }
}
