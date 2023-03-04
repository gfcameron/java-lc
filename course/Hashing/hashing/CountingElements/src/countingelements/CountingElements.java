package countingelements;

import java.util.*;

/*
Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
If there are duplicates in arr, count them separately.
 */

class CountingElements {

    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            set.add(n);
        }
        int count = 0;
        for (int n : arr) {
            if (set.contains(n + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 1, 2, 3 },
                { 1, 1, 3, 3, 5, 5, 7, 7 },
        };

        CountingElements ce = new CountingElements();
        for (int i = 0; i < testCases.length; i++) {
            int result = ce.countElements(testCases[i]);
            System.out.printf("Case %d: %s numbers are %s\n", i, Arrays.toString(testCases[i]),
                    result);
        }
    }
}