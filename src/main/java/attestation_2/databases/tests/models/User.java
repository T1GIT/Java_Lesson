package attestation_2.databases.tests.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(unique = true)
    private String login;

    @Column(name = "password_hash")
    private String passwordHash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    protected User() {}

    public User(String firstName, String lastName, String middleName, String login, String passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Group getGroup() {
        return group;
    }

    public Role getRole() {
        return role;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public void setMiddleName(String middle_name) {
        this.middleName = middle_name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String password_hash) {
        this.passwordHash = password_hash;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", middle_name='" + middleName + '\'' +
                ", login='" + login + '\'' +
                ", password_hash='" + passwordHash + '\'' +
                ", group=" + group +
                ", role=" + role +
                '}';
    }
}
