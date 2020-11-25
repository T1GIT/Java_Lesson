package attestation_1.seminar_6.convertor;

public abstract class Degree implements Convertable {
    protected double value;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
