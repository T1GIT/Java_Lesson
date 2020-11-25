package attestation_1.seminar_7.tests;

import org.junit.jupiter.api.Test;
import attestation_1.seminar_7.Filter;

import java.util.Arrays;

class FilterTest {

    @Test
    void filter() {
        String[] array = {"sjefief", "fiejf", "f", null};
        String[] newArray = Filter.filter(array, s -> s != null && s.length() > 3);
        System.out.println(Arrays.toString(newArray));
    }
}