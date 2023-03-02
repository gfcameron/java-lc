package numarray;

import java.util.Arrays;

/*
 * Given an integer array nums, an array queries where queries[i] = [x, y]
 * and an integer limit, return a boolean array that represents the answer
 * to each query. A query is true if the sum of the subarray from x to y is
 * less than limit, or false otherwise.
 */

class NumArray {

    private int[] psNums;

    public NumArray(int[] nums) {
        int len = nums.length;
        // Store as prefix sums
        psNums = new int[len + 1];
        psNums[0] = 0;
        for (int i = 0; i < len; i++) {
            psNums[i + 1] = psNums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return psNums[right + 1] - psNums[left];
    }

    public static void main(String[] args) {

        class TestCase {
            int[] nums;
            int[][] sumRanges;

            TestCase(int[] nums, int[][] sumRanges) {
                this.nums = nums;
                this.sumRanges = sumRanges;
            }
        }

        TestCase[] testCases = {
                new TestCase(
                        new int[] { -2, 0, 3, -5, 2, -1 },
                        new int[][] { { 0, 2 }, { 2, 5 }, { 0, 5 } }),
        };
        for (int i = 0; i < testCases.length; i++) {
            NumArray na = new NumArray(testCases[i].nums);
            int len = testCases[i].sumRanges.length;
            int[] res = new int[len];
            for (int j = 0; j < len; j++) {
                res[j] = na.sumRange(testCases[i].sumRanges[j][0], testCases[i].sumRanges[j][1]);
            }
            System.out.printf("Case %d: nums %s, psNums %s, sumRanges %s results %s\n", i,
                    Arrays.toString(testCases[i].nums),
                    Arrays.toString(na.psNums), Arrays.deepToString(testCases[i].sumRanges), Arrays.toString(res));
        }
    }
}