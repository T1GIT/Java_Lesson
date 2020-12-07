package attestation_2.spring.models;

import attestation_2.spring.utils.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "test_lists")
public class TestList extends AuditModel {
    @Id
    @NotNull
//    @GeneratedValue(    strategy = GenerationType.SEQUENCE,    generator = "pooled-lo")
//    @GenericGenerator(    name = "pooled-lo",
//            strategy = "sequence",    parameters = {
//                    @Parameter(name = "sequence_name", value = "post_sequence"),
//                    @Parameter(name = "initial_value", value = "1"),
//                    @Parameter(name = "optimizer", value = "pooled-lo")    })
    private int id;

    @NotNull
    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User teacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "tests",
            joinColumns = @JoinColumn(name = "test_list_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "question_id", nullable = false))
    private List<Question> questions;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "student_answers",
            joinColumns = @JoinColumn(name = "test_list_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "answer_id", nullable = false))
    private List<Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "student_answers",
            joinColumns = @JoinColumn(name = "test_list_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "student_id", nullable = false))
    private List<User> students;

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

    public List<Question> getQuestions() { return questions; }

    public List<Answer> getAnswers() {
        return answers;
    }
    public List<User> getStudents() {
        return students;
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

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void removeQuestion(Question question) {
        this.questions.remove(question);
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setStudents(List<User> students) {
        this.students = students;
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
