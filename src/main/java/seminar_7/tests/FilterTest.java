package seminar_7.tests;

import org.junit.jupiter.api.Test;
import seminar_7.Filter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    @Test
    void filter() {
        String[] array = {"sjefief", "fiejf", "f", null};
        String[] newArray = Filter.filter(array, s -> s != null && s.length() > 3);
        System.out.println(Arrays.toString(newArray));
    }
}