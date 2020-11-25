package attestation_2.databases.tests;


import attestation_2.databases.tests.models.User;
import attestation_2.databases.tests.services.UserService;

public class TestTests {
    public static void main(String[] args) {
        UserService userService = new UserService();
        for (User user: userService.findAllUsers()) {
            System.out.println(user);
        }
    }
}
