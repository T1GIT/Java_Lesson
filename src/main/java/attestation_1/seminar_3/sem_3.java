package attestation_1.seminar_3;

import java.util.*;

public abstract class sem_3 {
    public static <T> Collection <T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    public static void timerForDifferentCollections() {
        long lastTime;
        Random random = new Random();
        List<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        lastTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++) {
            double rand = Math.random();
            arrayList.add(rand);
        }
        System.out.println("Заполнение ArrayList: " + (System.currentTimeMillis() - lastTime) + " мс");
        lastTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++) {
            double rand = Math.random();
            linkedList.add(rand);
        }
        System.out.println("Заполнение LinkedList: " + (System.currentTimeMillis() - lastTime) + " мс");
        lastTime = System.currentTimeMillis();
        for (int i = 0; i <= 100000; i++) {
            double a = arrayList.get(random.nextInt(1000000));
        }
        System.out.println("Случайный доступ ArrayList: " + (System.currentTimeMillis() - lastTime) + " мс");
        lastTime = System.currentTimeMillis();
        for (int i = 0; i <= 100000; i++) {
            double a = linkedList.get(random.nextInt(1000000));
        }
        System.out.println("Случайный доступ LinkedList: " + (System.currentTimeMillis() - lastTime) + " мс");
    }


    public static Map<String, Integer> Frequensy_dict(String string) {
        Map<String, Integer> dict = new HashMap<>();
        for (String word: (string.toLowerCase()).split("[,;:.!?\\s]+")) {
            if (dict.containsKey(word)) {
                dict.replace(word, dict.get(word) + 1);
            } else {
                dict.put(word, 1);
            }
        }
        return dict;
    }
}
