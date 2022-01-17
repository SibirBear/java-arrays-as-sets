package sibirbear;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class arraysAsSets {

    private final Object[] array;

    public arraysAsSets(final Object[] array) {
        this.array = array;
    }

    public static <T> T[] intersection(final T[]... arrays) {
        Set<T> set = new HashSet<>(Arrays.asList(arrays[0]));
        for (int i = 1; i < arrays.length; i++) {
            set.retainAll(Arrays.asList(arrays[i]));
        }
        return (T[]) set.toArray();
    }

    public static <T> T[] union(final T[]... arrays) {
        Set<T> set = new HashSet<>();
        for (int i = 0; i < arrays.length; i++) {
            set.addAll(Arrays.asList(arrays[i]));
        }
        return (T[]) set.toArray();
    }

    public static <T> T[] diff(final T[]... arrays) {
        Set<T> set = new HashSet<>(Arrays.asList(arrays[0]));
        for (int i = 1; i < arrays.length; i++) {
            set.removeAll(Arrays.asList(arrays[i]));
        }
        return (T[]) set.toArray();
    }

    public <T> boolean includes(final T element) {
        return Arrays.asList(this.array).contains(element);
    }

}
