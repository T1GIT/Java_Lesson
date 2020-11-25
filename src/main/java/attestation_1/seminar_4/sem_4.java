package attestation_1.seminar_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class sem_4 {
    public static  <T, K> HashMap<K, HashSet<T>> mapSwap(HashMap<T, K> map) {
        HashMap<K, HashSet<T>> newMap = new HashMap<K, HashSet<T>>();

        for (Map.Entry<T, K> entry: map.entrySet()) {
            newMap.compute(entry.getValue(),(inKey, inValue) -> {
                if (inValue == null) {
                    inValue = new HashSet<T>();
                }

                inValue.add(entry.getKey());

                return inValue;
            });
        }

        return newMap;
    }
}
