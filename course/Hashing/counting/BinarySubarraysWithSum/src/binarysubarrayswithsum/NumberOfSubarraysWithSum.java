package binarysubarrayswithsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.
 */

class NumberOfSubarraysWithSum {

    public int numberOfSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        // Prefix sum
        int psum = 0;
        int count = 0;
        for (int num : nums) {
            psum += num;
            count += map.getOrDefault(psum - goal, 0);
            if (psum == goal) {
                count++;
            }
            map.put(psum, map.getOrDefault(psum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

        class TestCase {
            int[] nums;
            int goal;

            TestCase(int[] nums, int goal) {
                this.nums = nums;
                this.goal = goal;
            }
        }

        TestCase[] testCases = {
                new TestCase(new int[] { 1, 0, 1, 0, 1 }, 2),
                new TestCase(new int[] { 0, 0, 0, 0, 0 }, 0),
        };

        NumberOfSubarraysWithSum nsa = new NumberOfSubarraysWithSum();
        for (int i = 0; i < testCases.length; i++) {
            int result = nsa.numberOfSubarraysWithSum(testCases[i].nums, testCases[i].goal);
            System.out.printf("Case %d: %s with goal %d numbers are %d\n", i, Arrays.toString(testCases[i].nums),
                    testCases[i].goal, result);
        }
    }
}