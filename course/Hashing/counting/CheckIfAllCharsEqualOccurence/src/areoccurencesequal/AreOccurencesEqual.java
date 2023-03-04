package areoccurencesequal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a string s, determine if all characters have the same frequency.
 */

class AreOccurencesEqual {

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        Set<Integer> frequencies = new HashSet<>(counts.values());
        return frequencies.size() == 1;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "abacbc",
                "abcdef",
                "aabbaa",
                "aabb"
        };
        AreOccurencesEqual aoe = new AreOccurencesEqual();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = aoe.areOccurrencesEqual(testCases[i]);
            System.out.printf("Case %d: %s %b\n", i, testCases[i], result);
        }
    }
}