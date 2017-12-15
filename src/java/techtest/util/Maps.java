package techtest.util;

import java.util.Map;
import java.util.HashMap;

public class Maps {
    public static <K, T> Map<K, T> newMap() {
        return new HashMap<K, T>();
    }
}
