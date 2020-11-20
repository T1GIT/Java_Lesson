package non_sorted;

public class Coup extends Car{
    private int length;
    public Coup(String model, int speed, String color, int length) {
//        super(model, speed, color);
        this.length = length;
    }
    public int getLength() {
        return length;
    }
}
