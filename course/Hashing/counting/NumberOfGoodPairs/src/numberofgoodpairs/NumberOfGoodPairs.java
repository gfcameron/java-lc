package numberofgoodpairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 */

class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        // Frequency count of numbers
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int pairs = 0;
        for (int val : counts.values()) {
            pairs += (val * (val - 1)) / 2;
        }
        return pairs;
    }

    // This was the best solution published...
    public int numIdenticalPairs2(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int count = hm.getOrDefault(num, 0);
            ans = ans + count;
            hm.put(num, count + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 1, 2, 3, 1, 1, 3 },
                { 1, 1, 1, 1 },
                { 1, 2, 3 },
        };

        NumberOfGoodPairs ngp = new NumberOfGoodPairs();
        for (int i = 0; i < testCases.length; i++) {
            int result = ngp.numIdenticalPairs(testCases[i]);
            int result2 = ngp.numIdenticalPairs2(testCases[i]);
            System.out.printf("Case %d: %s number of good pairs %d,%d\n", i, Arrays.toString(testCases[i]), result,
                    result2);
        }
    }
}