package attestation_1.test_work_2;

import attestation_1.test_work_2.food.from.Bar;
import attestation_1.test_work_2.food.from.Kitchen;

import java.util.HashSet;
import java.util.Scanner;

public class Restaurant {
    private final Scanner scr = new Scanner(System.in);
    private final Menu barMenu;
    private final Menu kitchenMenu;
    private final HashSet<Order> orders;
    private final static String measure = "rub";

    public Restaurant() {
        this.barMenu = getTodayMenu.bar("Monday");
        this.kitchenMenu = getTodayMenu.kitchen("Monday");
        this.orders = new HashSet<>();
    }

    private static class getTodayMenu {
        private static Menu bar(String day) {
            Menu menu = new Menu();
            menu.addItem("Jeen Tonic", new Bar("JinTonic", "1 2 3".split(" +"), 20, 100));
            menu.addItem("Beer", new Bar("Beer", "4 5".split(" +"), 10, 100));
            return menu;
        }

        private static Menu kitchen(String day) {
            Menu menu = new Menu();
            menu.addItem("1", new Kitchen("2", "1 2 3".split(" +"), 500, 300));
            menu.addItem("2", new Kitchen("1", "4 5".split(" +"), 200, 500));
            return menu;
        }
    }

    public void getOrder() {
        Order order = null;
        // Asking order from console
        this.orders.add(order);
        cook(order);
    }

    public void cook(Order order) {
        // Cooking...
        give(order);
    }

    public void give(Order order) {
        System.out.println(order);
        System.out.printf("Price: %.2f %s", order.getPrice(), measure);
    }
}
