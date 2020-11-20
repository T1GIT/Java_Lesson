package test_work_2.food.from;

import test_work_2.food.Food;

public class Kitchen extends Food {
    public Kitchen(String name, String[] compound, int price, int amount) {
        super(name, compound, "mg", price, amount);
    }
}
