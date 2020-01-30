package util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapUtil {

    private MapUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> mapToSort) {
        List<Map.Entry<K, V>> list = new LinkedList<>(mapToSort.entrySet());

        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> getEntriesSortedByValue(Map<K, V> map, int numberOfEntriesToGet) {
        Map<K, V> result = map
                .entrySet()
                .stream()
                .limit(numberOfEntriesToGet)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return sortByValue(result);
    }
}