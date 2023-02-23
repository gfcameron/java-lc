package sorted;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order, return an array
of the squares of each number sorted in non-decreasing order.
 */

class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        // Find crossover point
        int zeroCrossIdx;
        for (zeroCrossIdx = 0; zeroCrossIdx < nums.length; zeroCrossIdx++) {
            if (nums[zeroCrossIdx] >= 0) {
                break;
            }
        }

        int[] result = new int[nums.length];
        // Create two lists centered on zero point
        int curNegIdx = zeroCrossIdx-1;
        int curPosIdx = zeroCrossIdx;
        for (int rIdx = 0; rIdx < result.length; rIdx++) {
            int num;
            if (curNegIdx < 0) {
                num = nums[curPosIdx++];
            } else if (curPosIdx >= nums.length) {
                num = nums[curNegIdx--];
            } else if ((nums[curNegIdx] + nums[curPosIdx]) > 0) {
                num = nums[curNegIdx--];
            } else {
                num = nums[curPosIdx++];
            }
            result[rIdx] = num*num;
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] testCases = {
            {-4,-1,0,3,10},
            {-7,-3,2,3,11}
        };
        SortedSquares ss = new SortedSquares();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            // Print array
            System.out.println(Arrays.toString(ss.sortedSquares(testCases[i])));
        }
    }
}