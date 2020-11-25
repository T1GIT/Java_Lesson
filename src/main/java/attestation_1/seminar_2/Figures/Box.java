package attestation_1.seminar_2.Figures;

public class Box extends Shape {
    private double empty;

    public Box(double volume) {
        super(volume);
        this.empty = volume;
    }

    public boolean add(Shape fig) {
        if (fig.getVolume() > this.empty) {
            return false;
        }
        else {
            this.empty -= fig.getVolume();
            return true;
        }
    }
}
