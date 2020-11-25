package attestation_1.test_work;

public class Model2 extends Car {
    private final int number;
    private static final int price = 300;
    private static final int maxSpeed = 250;
    private static final String color = "red";
    private static final String typeKPP = "auto";

    public int getNumber() {return this.number;}
    public int getMaxSpeed() {return maxSpeed;}
    public int getPrice() {return price;}
    public String getColor() {return color;}
    public String getTypeKPP() {return typeKPP;}


    public Model2(int number) {
        this.number = number;
    }
}
