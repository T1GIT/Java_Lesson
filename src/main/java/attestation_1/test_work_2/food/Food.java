package attestation_1.test_work_2.food;

public abstract class Food {
    private final String name;
    private final String[] compound;
    protected final String measure;
    private final double price;
    private final double amount;

    public Food(String name, String[] compound, String measure, int price, int amount) {
        this.name = name;
        this.measure = measure;
        this.compound = compound;
        this.price = price;
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public String[] getCompound() {
        return compound;
    }

    public String getMeasure() {
        return measure;
    }

    public String getName() {
        return name;
    }
}
