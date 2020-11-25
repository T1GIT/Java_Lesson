package attestation_1.seminar_2.Figures;

public abstract class SolidOfRevolution extends Shape {
    final private double radius;

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
