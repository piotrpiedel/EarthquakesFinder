package util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapUtil {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> mapToSort) {
        List<Map.Entry<K, V>> list = new LinkedList<>(mapToSort.entrySet());

        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


//    Map<Earthquake, Double> result2 = featureList
//                .stream()
//                .map(it -> new Earthquake(it.getProperty("place"), (Point) it.getGeometry()))
//                .collect(Collectors.toMap(Function.identity(), it -> distanceCalculatorHaversine.calculateDistance(it.getCoordinates(), coordinates)))
//                .entrySet()
//                .stream()
////                .filter(earthquakeDoubleEntry -> e)
//                .sorted(Map.Entry.comparingByValue())
//                .limit(10)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldDistance, newDistance) -> oldDistance, LinkedHashMap::new));
}
