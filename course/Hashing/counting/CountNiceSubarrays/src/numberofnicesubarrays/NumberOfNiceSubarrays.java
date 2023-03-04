package numberofnicesubarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of positive integers nums and an integer k. Find the number of subarrays
with exactly k odd numbers in them.
 */

class NumberOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        // The empty subarray is a subarray with sum 0.
        counts.put(0, 1);
        int ans = 0;
        int curr = 0;
        for (int num : nums) {
            curr += num % 2;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        class TestCase {
            int[] nums;
            int k;

            TestCase(int[] nums, int k) {
                this.nums = nums;
                this.k = k;
            }
        }

        TestCase[] testCases = {
                new TestCase(new int[] { 1, 1, 2, 1, 1 }, 3),
                new TestCase(new int[] { 2, 4, 6 }, 1),
                new TestCase(new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, 2),
        };

        NumberOfNiceSubarrays nnsa = new NumberOfNiceSubarrays();
        for (int i = 0; i < testCases.length; i++) {
            int result = nnsa.numberOfSubarrays(testCases[i].nums, testCases[i].k);
            System.out.printf("Case %d: %s with k=%d numbers are %d\n", i, Arrays.toString(testCases[i].nums),
                    testCases[i].k, result);
        }
    }
}