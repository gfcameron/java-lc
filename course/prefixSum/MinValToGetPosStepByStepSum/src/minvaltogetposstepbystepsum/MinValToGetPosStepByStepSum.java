package minvaltogetposstepbystepsum;

import java.util.Arrays;

/*
 * Given an array of integers nums, you start with an initial positive value startValue.
 * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right)
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 */

class MinValToGetPosStepByStepSum {

    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(minSum, sum);
        }
        return 1 - (minSum > 0 ? 0 : minSum);
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { -3, 2, -3, 4, 2 },
                { 1, 2 },
                { 1, -2, -3 }
        };
        MinValToGetPosStepByStepSum msv = new MinValToGetPosStepByStepSum();
        for (int i = 0; i < testCases.length; i++) {
            int result = msv.minStartValue(testCases[i]);
            System.out.printf("Case %d: %s, start value %d\n", i, Arrays.toString(testCases[i]), result);
        }
    }
}