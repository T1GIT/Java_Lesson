package attestation_2.hibernate.orms.tests.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int duration;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "start_dt", nullable = false)
    private Date startDate;

    @NotNull
    @Temporal(TemporalType.TIME)
    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_dt")
    private Date endDate;

    @NotNull
    @Temporal(TemporalType.TIME)
    @Column(name = "end_time", nullable = false)
    private Date endTime;

    private boolean active;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private TestList testList;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    protected Schedule() {}

    public Schedule(int duration, Date startDate, Date startTime, Date endDate, Date endTime, boolean active) {
        this.duration = duration;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public boolean isActive() {
        return active;
    }

    public TestList getTestList() {
        return testList;
    }

    public Group getGroup() {
        return group;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTestList(TestList test) {
        this.testList = test;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
