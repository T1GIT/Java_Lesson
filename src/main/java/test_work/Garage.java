package test_work;

import java.util.HashMap;
import java.util.Map;

public class Garage {
    private final int maxAmount;
    private final HashMap<String, Integer> storage = new HashMap<>();

    public int getMaxAmount() {return this.maxAmount;}
    public HashMap<String, Integer> getStorage() {return this.storage;}

    public Garage(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void printByAmount() {
        for (Map.Entry<String, Integer> entry: this.storage.entrySet()) {

        }
    }

}
