package test_work;

public class Model1 extends Car {
    private final int number;
    private static final int price = 100;
    private static final int maxSpeed = 200;
    private static final String color = "red";
    private static final String typeKPP = "auto";

    public int getNumber() {return this.number;}
    public int getMaxSpeed() {return maxSpeed;}
    public int getPrice() {return price;}
    public String getColor() {return color;}
    public String getTypeKPP() {return typeKPP;}


    public Model1(int number) {
        this.number = number;
    }
}
