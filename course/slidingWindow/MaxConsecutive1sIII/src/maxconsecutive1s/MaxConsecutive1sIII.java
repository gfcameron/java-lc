package maxconsecutive1s;

import java.util.Arrays;

/*
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's
 * in the array if you can flip at most k 0's.
 */

class MaxConsecutive1sIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // Keep stepping through until we see k+1 zeros
            if (nums[right] == 0) {
                k--;
            }
            // If k<0 we have used up all our allowable 0s.
            if (k < 0) {
                // Increment k if left pointer has a 0
                k += 1 - nums[left++];
            }
        }
        return right - left;
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
                new TestCase(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2),
                new TestCase(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3),
                new TestCase(new int[] { 0, 0, 0, 1 }, 4),
                new TestCase(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 0),
        };
        MaxConsecutive1sIII max1s = new MaxConsecutive1sIII();
        for (int i = 0; i < testCases.length; i++) {
            int result = max1s.longestOnes(testCases[i].nums, testCases[i].k);
            System.out.printf("Case %d: %s maximum consecutive 1's with %d flips: %d\n", i,
                    Arrays.toString(testCases[i].nums),
                    testCases[i].k,
                    result);
        }
    }
}