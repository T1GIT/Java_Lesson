package attestation_1.seminar_6.convertor;

public class Far extends Degree {
    public Far(double value) {
        this.value = value;
    }

    @Override
    public double toFar() {
        return this.value;
    }

    @Override
    public double toKel() {
        return 5 * (this.value - 32) / 9 + 273.15;
    }

    @Override
    public double toCel() {
        return 5 * (this.value + 32) / 9;
    }
}
