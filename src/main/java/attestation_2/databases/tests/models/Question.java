package attestation_2.databases.tests.models;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private int id;

    private String text;

    private int score;

    private boolean active;

    protected Question() {}

    public Question(String text, int score, boolean active) {
        this.text = text;
        this.score = score;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getScore() {
        return score;
    }

    public boolean isActive() {
        return active;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", active=" + active +
                '}';
    }
}
