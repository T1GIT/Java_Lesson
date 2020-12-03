package attestation_2.hibernate.orms.tests.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(nullable = false, columnDefinition = "text")
    private String text;

    @NotNull
    @Column(nullable = false)
    private int score;

    @NotNull
    @Column(nullable = false)
    private boolean active;

    protected Question() {}

    public Question(String text, int score, boolean active) {
        this.setText(text);
        this.setScore(score);
        this.setActive(active);
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
                ", text='" + getText() + '\'' +
                ", score=" + getScore() +
                ", active=" + isActive() +
                '}';
    }
}
