package attestation_1.test_work.preparing;

public class HourWorker extends Worker {
    public HourWorker(String name, double inHour) {
        super(name, inHour);
    }

    public HourWorker(int id, String name, double month) {
        super(id, name, month);
    }

    @Override
    protected double salary(double row) {
        return 20.8 * 8 * row;
    }
}
