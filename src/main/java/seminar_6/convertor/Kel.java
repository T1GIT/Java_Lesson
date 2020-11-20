package seminar_6.convertor;

public class Kel extends Degree {
    public Kel(double value) {
        this.value = value;
    }

    @Override
    public double toFar() {
        return 9 * (this.value - 273.5) / + 32;
    }

    @Override
    public double toKel() {
        return this.value;
    }

    @Override
    public double toCel() {
        return this.value - 273.15;
    }
}
