package maxavgsubarray1;

import java.util.Arrays;

/*
 * Given an array of positive integers nums and an integer k, return the number of contiguous subarrays where the
 * product of all the elements in the subarray is strictly less than k.
 */

class NaxAvgSubArray1 {

    public double findMaxAverage(int[] nums, int k) {
        // Compute initial subarray
        long sum = 0;
        if (k > nums.length) {
            k = nums.length;
        }
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long max = sum;
        for (int i = 0; i < nums.length - k; i++) {
            sum -= nums[i];
            sum += nums[i + k];
            if (sum > max) {
                max = sum;
            }
        }
        return ((double) max) / k;
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
                new TestCase(new int[] { 1, 12, -5, -6, 50, 3 }, 4),
        };
        NaxAvgSubArray1 masa = new NaxAvgSubArray1();
        for (int i = 0; i < testCases.length; i++) {
            double result = masa.findMaxAverage(testCases[i].nums, testCases[i].k);
            System.out.printf("Case %d: %s k=%d, largest window average %f\n", i, Arrays.toString(testCases[i].nums),
                    testCases[i].k,
                    result);
        }
    }
}