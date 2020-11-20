package seminar_2.Figures;

public class Cylinder extends SolidOfRevolution {
    final private double height;

    public Cylinder(double radius, double height) {
        super((Math.PI * radius * radius * height), radius);
        this.height = height;
    }
}
