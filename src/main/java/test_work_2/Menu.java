package test_work_2;

import test_work_2.food.Food;

import java.util.Collection;
import java.util.HashMap;


public class Menu {
    private final HashMap<String, Food> items;
    private final HashMap<String, Food> stopList = new HashMap<>();
    
    public Menu() {
        this.items = new HashMap<>();
    }
    
    public boolean contains(String name) {
        return this.items.containsKey(name);
    }
    
    public void addItem(String name, Food item) {
        this.items.put(name, item);
    }
    
    public boolean delItem(String name, Food item) {
        return this.items.remove(name, item);
    }
    
    public boolean addStopList(String name, Food item) {
        boolean answer = this.items.remove(name, item);
        if (answer) this.stopList.put(name, item);
        return answer;
    }
    
    public HashMap<String, Food> getStopList() {
        return stopList;
    }
}
