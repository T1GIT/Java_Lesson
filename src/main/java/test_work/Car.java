package test_work;

public abstract class Car {
    private int number;
    private String color;
    private int maxSpeed;
    private String typeKPP;
    private int speed = 0;
    private int price;
    private boolean isStarted = false;

    public void start() {
        this.isStarted = true;
    }

    public void stop() {
        this.isStarted = false;
        this.speed = 0;
    }

    public void accelerate(int speed) {
        if (speed > maxSpeed) {
            throw new AssertionError("Incorrect value");
        } else if (!isStarted) {
            throw new AssertionError("Car isn't started");
        } else {
            this.speed = speed;
        }
    }
}
