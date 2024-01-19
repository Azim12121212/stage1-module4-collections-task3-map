package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionValueFinder {
    public boolean isFunctionValuePresent(List<Integer> sourceList, int requiredValue) {
        Map<Integer, Integer> functionMap = calculateFunctionMap(sourceList);

        for (Map.Entry<Integer, Integer> e : functionMap.entrySet()) {
            if (e.getValue()==requiredValue) {
                return true;
            }
        }

        return false;
    }

    private Map<Integer, Integer> calculateFunctionMap(List<Integer> sourceList) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i: sourceList) {
            map.put(i, 5*i+2);
        }

        return map;
    }
}
