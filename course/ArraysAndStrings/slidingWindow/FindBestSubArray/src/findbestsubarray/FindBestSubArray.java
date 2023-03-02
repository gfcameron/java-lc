package findbestsubarray;

import java.util.Arrays;

/*
 * Given an array of positive integers nums and an integer k, return the number of contiguous subarrays where the
 * product of all the elements in the subarray is strictly less than k.
 */

class NumSubArrayProdLessThanK {

    public int findBestSubarray(int[] nums, int k) {
        // Precompute the initial window
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }
        // Slide the window
        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
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
                new TestCase(new int[] { 3, -1, 4, 12, -8, 5, 6 }, 4),
        };
        NumSubArrayProdLessThanK bsa = new NumSubArrayProdLessThanK();
        for (int i = 0; i < testCases.length; i++) {
            int result = bsa.findBestSubarray(testCases[i].nums, testCases[i].k);
            System.out.printf("Case %d: %s k=%d greatest window sum %d\n", i, Arrays.toString(testCases[i].nums),
                    testCases[i].k,
                    result);
        }
    }
}