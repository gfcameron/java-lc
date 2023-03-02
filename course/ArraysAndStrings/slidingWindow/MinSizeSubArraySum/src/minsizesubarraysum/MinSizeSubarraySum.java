package minsizesubarraysum;

import java.util.Arrays;

/*
 * Given an array of positive integers nums and an integer k, find the length of the longest subarray
 * whose sum is less than or equal to k.
 */

class MinSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        // If needed, advance right
        for (int right = 0; right < len; right++) {
            // target is -ve if window is big enough.
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right + 1 - left);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        class TestCase {
            int[] nums;
            int target;

            TestCase(int[] nums, int target) {
                this.nums = nums;
                this.target = target;
            }
        }
        TestCase[] testCases = {
                new TestCase(new int[] { 2, 3, 1, 2, 4, 3 }, 7),
                new TestCase(new int[] { 1, 4, 4 }, 4),
                new TestCase(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }, 11),
                new TestCase(new int[] { 2, 3, 1, 1, 1, 1, 1 }, 5),
        };
        MinSizeSubarraySum mssa = new MinSizeSubarraySum();
        for (int i = 0; i < testCases.length; i++) {
            int result = mssa.minSubArrayLen(testCases[i].target, testCases[i].nums);
            System.out.printf("Case %d: %s target %d min size subarray: %d\n", i, Arrays.toString(testCases[i].nums),
                    testCases[i].target,
                    result);
        }
    }
}