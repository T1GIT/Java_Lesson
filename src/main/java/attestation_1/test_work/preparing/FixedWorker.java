package attestation_1.test_work.preparing;

public class FixedWorker extends Worker {
    public FixedWorker(String name, double month) {
        super(name, month);
    }

    public FixedWorker(int id, String name, double month) {
        super(id, name, month);
    }

    @Override
    protected double salary(double row) {
        return row;
    }
}
