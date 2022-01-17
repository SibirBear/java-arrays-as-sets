import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sibirbear.arraysAsSets;
import static sibirbear.arraysAsSets.*;

class arraysAsSetsTest {

    private final String[] friends1 = {"vasya", "kolya", "petya"};
    private final String[] friends2 = {"igor", "petya", "sergey", "vasya", "sasha"};
    private final String[] friends3 = {"maxim", "rostislav", "petya"};
    private final arraysAsSets includesTest1 = new arraysAsSets(new String[] {"rostislav", "maxim", "kolya"});
    private final arraysAsSets includesTest2 = new arraysAsSets(new Integer[] {4, 13});
    private final arraysAsSets includesTest3 = new arraysAsSets(new Integer[] {});

    @Test
    void intersectionTest() {
        String[] expected = {"petya"};
        Assertions.assertArrayEquals(expected, intersection(friends1, friends2, friends3));
    }

    @Test
    void unionTest() {
        String[] expected = {"igor", "rostislav", "maxim", "kolya", "sergey", "vasya", "sasha", "petya"};
       Assertions.assertArrayEquals(expected, union(friends1, friends2, friends3));
    }

    @Test
    void diffTest() {
        String[] expected = {"kolya"};
        Assertions.assertArrayEquals(expected, diff(friends1, friends2, friends3));
    }

    @Test
    void includesTest() {
        Assertions.assertTrue(includesTest1.includes("maxim"));
        Assertions.assertFalse(includesTest2.includes(10));
        Assertions.assertFalse(includesTest3.includes(5));
    }

}