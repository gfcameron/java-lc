package sumofuniqueelements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.
 */

class SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (int num : nums) {
            if (counts.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 1, 2, 3, 2 },
                { 1, 1, 1, 1, 1 },
                { 1, 2, 3, 4, 5 },
        };

        SumOfUniqueElements sue = new SumOfUniqueElements();
        for (int i = 0; i < testCases.length; i++) {
            int result = sue.sumOfUnique(testCases[i]);
            System.out.printf("Case %d: %s unique elements sum is %d\n", i, Arrays.toString(testCases[i]),
                    result);
        }
    }
}