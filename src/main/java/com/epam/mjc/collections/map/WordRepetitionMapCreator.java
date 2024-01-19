package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.Map;

public class WordRepetitionMapCreator {
    public static Map<String, Integer> createWordRepetitionMap(String sentence) {
        Map<String, Integer> map = new HashMap<>();

        if (sentence.isEmpty()) {
        } else {
            String[] words = sentence.split("\\W+");
            int counter = 1;

            for (int i=0; i<words.length-1; i++) {
                words[i] = words[i].toLowerCase();
                for (int j=i+1; j<words.length; j++) {
                    words[j] = words[j].toLowerCase();
                    if (words[i].equals(words[j])) {
                        counter++;
                    }
                }
                if (!map.containsKey(words[i])) {
                    map.put(words[i], counter);
                }
                counter=1;
            }

            if (!map.containsKey(words[words.length-1])) {
                map.put(words[words.length-1], counter);
            }
        }

        return map;
    }
    public static void main(String[] args) {
        String s1 = "hello word in lOwEr cAsE, HELLO WORD in UpPeR CaSe.";
        String s2 = "Java Map can store pairs of keys and values.";
        System.out.println(createWordRepetitionMap(s2));
    }
}
