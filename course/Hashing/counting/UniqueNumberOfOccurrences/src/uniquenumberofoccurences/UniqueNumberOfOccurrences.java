package uniquenumberofoccurences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given an array of integers arr, a lucky integer is an integer that has a frequency
in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.
 */

class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        // Count frequency
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : counts.keySet()) {
            int freq = counts.get(num);
            if (!set.add(freq)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 1, 2, 2, 1, 1, 3 },
                { 1, 2 },
                { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 },
        };

        UniqueNumberOfOccurrences uno = new UniqueNumberOfOccurrences();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = uno.uniqueOccurrences(testCases[i]);
            System.out.printf("Case %d: %s unique number of occurrences %b\n", i, Arrays.toString(testCases[i]),
                    result);
        }
    }
}