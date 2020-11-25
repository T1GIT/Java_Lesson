package attestation_1.seminar_7;

import java.util.Arrays;
import java.util.function.Function;

public class Filter {
    public static<T> T[] filter(T[] array, Function<T, Boolean> proc) {
        int position = 0;
        for (T item: array) {
            if (proc.apply(item)) {
                array[position] = item;
                position++;
            }
        }
        return Arrays.copyOf(array, position);
    }
}
