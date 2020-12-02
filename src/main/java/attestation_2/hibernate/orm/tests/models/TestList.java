package attestation_2.hibernate.orm.tests.models;

import javax.persistence.*;

@Entity
@Table(name = "tst_lists")
public class TestList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "row_id")
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    protected TestList() {}

    public TestList(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TestList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", teacher=" + teacher +
                '}';
    }
}
