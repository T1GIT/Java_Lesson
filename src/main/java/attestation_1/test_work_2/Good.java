package attestation_1.test_work_2;

import attestation_1.test_work_2.food.Food;

public class Good {
    private final Food food;
    private final double amount;

    public Good(Food food, double amount) {
        this.food = food;
        this.amount = amount;
    }

    public double getPrice() {
        return food.getPrice() / food.getAmount() * amount;
    }

    public double getAmount() {
        return amount;
    }

    public Food getFood() {
        return food;
    }
}
