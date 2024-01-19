package com.epam.mjc.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyValueSwapper {
    public static Map<String, Integer> swap(Map<Integer, String> sourceMap) {
        Map<String, Integer> map = new HashMap<>();

        if (sourceMap.isEmpty()) {
        } else {
            List<Integer> listKeys = new ArrayList<>();
            List<String> listValues = new ArrayList<>();

            // save all the values and keys of the sourceMap into the lists
            for (Map.Entry<Integer, String> e : sourceMap.entrySet()) {
                listKeys.add(e.getKey());
                listValues.add(e.getValue());
            }

            // find out a bigger key of the same values and remove it from the sourceMap
            Integer smallKey = null;
            String sameValue = null;
            for (int i=0; i<listValues.size()-1; i++) {
                for (int j=i+1; j<listValues.size(); j++) {
                    if (listValues.get(i).equals(listValues.get(j))) {
                        sameValue = listValues.get(i);
                        if (listKeys.get(i)<listKeys.get(j)) {
                            smallKey = listKeys.get(i);
                        } else {
                            smallKey = listKeys.get(j);
                        }
                    }
                }
            }

            // finally just swap the key and values into the map
            for (Map.Entry<Integer, String> e : sourceMap.entrySet()) {
                if (e.getValue().equals(sameValue)) {
                    map.put(e.getValue(), smallKey);
                } else {
                    map.put(e.getValue(), e.getKey());
                }
            }
        }

        return map;
    }
    public static void main(String[] args) {
        Map<Integer, String> sourceMap = new HashMap<>();
        sourceMap.put(10, "one");
        sourceMap.put(2, "two");
        sourceMap.put(3, "three");
        sourceMap.put(1, "one");
        System.out.println(swap(sourceMap));
    }
}
