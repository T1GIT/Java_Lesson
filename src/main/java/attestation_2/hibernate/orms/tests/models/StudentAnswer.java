package attestation_2.hibernate.orms.tests.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "std_answers")
public class StudentAnswer {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private TestList testList;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User student;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    public StudentAnswer() {}

    public int getId() {
        return id;
    }

    public TestList getTestList() {
        return testList;
    }

    public User getStudent() {
        return student;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setTestList(TestList test) {
        this.testList = test;
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
                ", test=" + testList +
                ", student=" + student +
                ", answer=" + answer +
                '}';
    }
}
