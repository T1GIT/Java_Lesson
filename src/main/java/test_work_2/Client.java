package test_work_2;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        System.out.println("Hello, what you want to eat?");
        restaurant.getOrder();
    }
}
