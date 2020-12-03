package attestation_2.hibernate.orms.tests.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private TestList test;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Test() {}

    public int getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public TestList getTest() {
        return test;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setTest(TestList test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", test=" + test +
                ", question=" + question +
                '}';
    }
}
