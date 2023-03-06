package sortcharsbyfrequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
 */

class SortCharsByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort(Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed());
        char[] result = new char[s.length()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : list) {
            for (int j = 0; j < entry.getValue(); j++) {
                result[i++] = entry.getKey();
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {

        String[] testCases = {
                "tree",
                "cccaaa",
                "Aabb",
        };
        SortCharsByFrequency fs = new SortCharsByFrequency();
        for (int i = 0; i < testCases.length; i++) {
            String result = fs.frequencySort(testCases[i]);
            System.out.printf("Case %d: %s to %s\n", i, testCases[i], result);
        }
    }
}