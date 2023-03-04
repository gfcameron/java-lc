package findnumbers;

import java.util.*;

/*
Given an integer array nums, find all the numbers x that satisfy the following:
x + 1 is not in nums, and x - 1 is not in nums.
 */

class FindNumbers {

    public List<Integer> findNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            if (!numSet.contains(num + 1) && !numSet.contains(num - 1)) {
                ans.add(num);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 1, 3, 4, 2, 2 },
                { 3, 1, 6, 4, 9 },
                { 0, 2, 3, 4, 5 },
        };

        FindNumbers rconv = new FindNumbers();
        for (int i = 0; i < testCases.length; i++) {
            List<Integer> result = rconv.findNumbers(testCases[i]);
            System.out.printf("Case %d: %s numbers are %s\n", i, Arrays.toString(testCases[i]),
                    Arrays.toString(result.toArray()));
        }
    }
}