package missingnumber;

import java.util.*;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */

class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    // This was a posted O(1) space solution posted by realwaffle
    public int missingNumber2(int[] nums) {
        int len = nums.length;
        int numsSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSum += nums[i];
        }
        return (len * (len - 1)) / 2 + len - numsSum;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 3, 0, 1 },
                { 0, 1 },
                { 9, 6, 4, 2, 3, 5, 7, 0, 1 },
        };

        MissingNumber mn = new MissingNumber();
        for (int i = 0; i < testCases.length; i++) {
            int result = mn.missingNumber(testCases[i]);
            int result2 = mn.missingNumber2(testCases[i]);
            System.out.printf("Case %d: %s missing number is %d,%d\n", i, Arrays.toString(testCases[i]),
                    result, result2);
        }
    }
}