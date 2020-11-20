package seminar_2.Figures;

public class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(((4.0/3) * Math.PI * Math.pow(radius, 3)), radius);
    }
}
