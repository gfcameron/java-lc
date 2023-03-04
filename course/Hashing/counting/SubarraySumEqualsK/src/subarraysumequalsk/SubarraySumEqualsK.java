package subarraysumequalsk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k, find the number of subarrays whose sum is equal to k.
 */

class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        // Empty subarray is a is a subarray with sum 0.
        counts.put(0, 1);
        int ans = 0;
        int curr = 0;
        for (int num : nums) {
            curr += num;
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
                new TestCase(new int[] { 1, 1, 1 }, 2),
                new TestCase(new int[] { 1, 2, 3 }, 3),
                new TestCase(new int[] { 1, 2, 1, 2, 1 }, 3),
        };

        SubarraySumEqualsK sas = new SubarraySumEqualsK();
        for (int i = 0; i < testCases.length; i++) {
            int result = sas.subarraySum(testCases[i].nums, testCases[i].k);
            System.out.printf("Case %d: %s with k=%d numbers are %d\n", i, Arrays.toString(testCases[i].nums),
                    testCases[i].k, result);
        }
    }
}