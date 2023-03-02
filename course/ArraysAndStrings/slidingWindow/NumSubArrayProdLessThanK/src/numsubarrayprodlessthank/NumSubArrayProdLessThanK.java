package numsubarrayprodlessthank;

import java.util.Arrays;

/*
 * Given an array of positive integers nums and an integer k, return the number of contiguous subarrays where the
 * product of all the elements in the subarray is strictly less than k.
 */

class NumSubArrayProdLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (left <= right && curr >= k) {
                curr /= nums[left];
                left++;
            }
            ans += right - left + 1;
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
                new TestCase(new int[] { 10, 5, 2, 6 }, 100),
        };
        NumSubArrayProdLessThanK nsa = new NumSubArrayProdLessThanK();
        for (int i = 0; i < testCases.length; i++) {
            int result = nsa.numSubarrayProductLessThanK(testCases[i].nums, testCases[i].k);
            System.out.printf("Case %d: %s k=%d number of subarrays %d\n", i, Arrays.toString(testCases[i].nums),
                    testCases[i].k,
                    result);
        }
    }
}