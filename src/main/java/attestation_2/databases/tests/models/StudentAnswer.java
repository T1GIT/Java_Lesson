package attestation_2.databases.tests.models;

import javax.persistence.*;

@Entity
@Table(name = "student_answer")
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestList test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User student;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public StudentAnswer() {}

    public int getId() {
        return id;
    }

    public TestList getTest() {
        return test;
    }

    public User getStudent() {
        return student;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setTest(TestList test) {
        this.test = test;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "StudentAnswer{" +
                "id='" + id + '\'' +
                ", test=" + test +
                ", student=" + student +
                ", answer=" + answer +
                '}';
    }
}
