package attestation_1.test_work.preparing;

public class Worker {
    private final int id;
    private final String name;
    private double month;
    private static int counter = 0;

    public Worker(String name, double income) {
        this.id = counter++;
        this.name = name;
        this.month = salary(income);
    }

    public Worker(int id, String name, double income) {
        this.id = id;
        this.name = name;
        this.month = salary(income);
    }

    protected double salary(double row) {
        return row;
    }

    public void setMonth(double month) {
        this.month = month;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMonth() {
        return month;
    }
}
