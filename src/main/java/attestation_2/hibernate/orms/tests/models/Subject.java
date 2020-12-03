package attestation_2.hibernate.orms.tests.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;

    protected Subject() {}

    public Subject(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
