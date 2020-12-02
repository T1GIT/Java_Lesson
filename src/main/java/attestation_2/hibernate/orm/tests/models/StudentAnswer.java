package attestation_2.hibernate.orm.tests.models;

import javax.persistence.*;

@Entity
@Table(name = "std_answers")
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "row_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestList testList;

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
