package attestation_2.hibernate.orm.tests.models;

import javax.persistence.*;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestList test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
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
