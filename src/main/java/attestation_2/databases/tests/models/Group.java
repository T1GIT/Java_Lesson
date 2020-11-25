package attestation_2.databases.tests.models;


import javax.persistence.*;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private int id;

    @Column(unique = true)
    private String name;
    
    private int year;
    
    private int semester;

    protected Group() {}

    public Group(String name, int year, int semester) {
        this.name = name;
        this.year = year;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                '}';
    }
}   
