package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the
same element twice.

You can return the answer in any order.
*/

class TwoSum {

    // This returns the numbers not the index
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hmap.containsKey(target - num)) {
                return new int[] { hmap.get(target - nums[i]), i };
            } else {
                hmap.put(num, i);
            }
        }
        return new int[] { -1, -1 };
    }

    // This returns the numbers not the index
    public int[] twoSumNumsOnly(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[] { target - num, num };
            } else {
                set.add(num);
            }
        }
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
                new TestCase(new int[] { 3, 2, 4 }, 6),
                new TestCase(new int[] { -1, 0 }, -1)
        };
        TwoSum ts = new TwoSum();

        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: Target %d\n", i, testCases[i].target);
            System.out.println(Arrays.toString(testCases[i].array));
            // Print array
            System.out.println(Arrays.toString(ts.twoSum(testCases[i].array, testCases[i].target)));
            // Print nums only
            System.out.printf("Nums only: %s\n",
                    Arrays.toString(ts.twoSumNumsOnly(testCases[i].array, testCases[i].target)));
        }
    }
}