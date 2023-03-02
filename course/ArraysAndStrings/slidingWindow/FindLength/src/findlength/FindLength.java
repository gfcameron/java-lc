package findlength;

import java.util.Arrays;

/*
 * Given an array of positive integers nums and an integer k, find the length of the longest subarray
 * whose sum is less than or equal to k.
 */

class FindLength {

    public int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
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
                new TestCase(new int[] { 3, 1, 2, 7, 4, 2, 1, 1, 5 }, 8),
        };
        FindLength fl = new FindLength();
        for (int i = 0; i < testCases.length; i++) {
            int result = fl.findLength(testCases[i].nums, testCases[i].k);
            System.out.printf("Case %d: %s k=%d longest subarray: %d\n", i, Arrays.toString(testCases[i].nums),
                    testCases[i].k,
                    result);
        }
    }
}