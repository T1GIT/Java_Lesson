package attestation_1.seminar_6.convertor;

public class Cel extends Degree{
    public Cel(double value) {
        this.value = value;
    }

    @Override
    public double toFar() {
        return 9 * (this.value + 32) / 5;
    }

    @Override
    public double toKel() {
        return this.value + 273.5;
    }

    @Override
    public double toCel() {
        return this.value;
    }
}
