package seminar_2.Figures;

public abstract class Shape {
    final private double volume;

    public Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }
}
