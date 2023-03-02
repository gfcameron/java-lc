package findpivotindex;

import java.util.Arrays;

/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
 */

class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] ps = new int[len + 1];
        // Compute prefix sums
        ps[0] = 0;
        for (int i = 0; i < len; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }
        // find the pivot index
        for (int i = 1; i < len + 1; i++) {
            if (ps[i - 1] == ps[len] - ps[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 1, 7, 3, 6, 5, 6 },
                { 1, 2, 3 },
                { 2, 1, -1 },
                { -1, -1, 0, 1, 0, -1 },
                { -1, -1, 0, 1, 1, 0 },
        };
        FindPivotIndex pi = new FindPivotIndex();
        for (int i = 0; i < testCases.length; i++) {
            int result = pi.pivotIndex(testCases[i]);
            System.out.printf("Case %d: %s pivot element %d\n", i, Arrays.toString(testCases[i]),
                    result);
        }
    }
}