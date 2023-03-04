package twosum2;

import java.util.Arrays;
/*
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the
same element twice.

You can return the answer in any order.
*/

class TwoSum2 {

    // Return the indices of two numbers in the list summing to the target
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers.length > 1) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    return result;
                }
            }
        }
        // Error case
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {

        class TestCase {
            int[] array;
            int target;

            TestCase(int[] array, int target) {
                this.array = array;
                this.target = target;
            }
        }

        TestCase[] testCases = {
                new TestCase(new int[] { 2, 7, 11, 15 }, 9),
                new TestCase(new int[] { 2, 3, 4 }, 6),
                new TestCase(new int[] { -1, 0 }, -1)
        };
        TwoSum2 ts = new TwoSum2();

        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: Target %d\n", i, testCases[i].target);
            System.out.println(Arrays.toString(testCases[i].array));
            // Print array
            System.out.println(Arrays.toString(ts.twoSum(testCases[i].array, testCases[i].target)));
        }
    }
}