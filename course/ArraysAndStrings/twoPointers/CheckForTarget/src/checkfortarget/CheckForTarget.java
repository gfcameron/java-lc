package checkfortarget;

import java.util.Arrays;

/*
 * Given a sorted array of unique integers and a target integer, return true if there exists a pair of numbers
 * that sum to target, false otherwise.
 */

class CheckForTarget {

    public boolean checkForTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int curr = nums[left] + nums[right];
            if (curr == target) {
                return true;
            }

            if (curr > target) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        class TestCase {
            int[] nums;
            int target;

            TestCase(int[] nums, int target) {
                this.nums = nums;
                this.target = target;
            }
        }

        TestCase[] testCases = {
                new TestCase(new int[] { 1, 2, 4, 6, 8, 9, 14, 15 }, 13),
        };
        CheckForTarget cft = new CheckForTarget();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = cft.checkForTarget(testCases[i].nums, testCases[i].target);
            System.out.printf("Case %d: %s %d %b\n", i, Arrays.toString(testCases[i].nums), testCases[i].target,
                    result);
        }
    }
}