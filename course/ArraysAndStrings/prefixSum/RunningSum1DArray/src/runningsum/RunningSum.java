package runningsum;

import java.util.Arrays;

/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
 */

class RunningSum {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 1, 2, 3, 4 },
                { 1, 1, 1, 1, 1 },
                { 3, 1, 2, 10, 1 },
        };
        RunningSum rs = new RunningSum();
        for (int i = 0; i < testCases.length; i++) {
            int[] result = rs.runningSum(testCases[i]);
            System.out.printf("Case %d: %s running sum %s\n", i, Arrays.toString(testCases[i]),
                    Arrays.toString(result));
        }
    }
}