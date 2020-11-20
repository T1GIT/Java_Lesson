package test_work_2;

import java.util.Collection;
import java.util.HashSet;

public class Order {
    private final HashSet<Good> items;
    private final HashSet<Good> stopList = new HashSet<>();
    private double price = 0;

    public Order() {
        this.items = new HashSet<>();
    }

    public Order(Collection<Good> items) {
        this.items = new HashSet<>(items);
        for (Good item: items) this.price += item.getPrice();
    }

    public void addItem(Good item) {
        this.items.add(item);
        this.price += item.getPrice();
    }

    public boolean delItem(Good item) {
        boolean answer = this.items.remove(item);
        if (answer) this.price -= item.getPrice();
        return answer;
    }

    public double getPrice() {
        return price;
    }
}
