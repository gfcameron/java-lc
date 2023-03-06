package maximumerasurevalue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 */

class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int result = 0;
        int curSum = 0;

        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < len; right++) {
            // Advance start until window set is unique
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                curSum -= nums[left];
                left++;
            }
            curSum += nums[right];
            set.add(nums[right]);
            result = Math.max(result, curSum);
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 4, 2, 4, 5, 6 },
                { 5, 2, 1, 2, 5, 2, 1, 2, 5 },
        };

        MaximumErasureValue mev = new MaximumErasureValue();
        for (int i = 0; i < testCases.length; i++) {
            int result = mev.maximumUniqueSubarray(testCases[i]);
            System.out.printf("Case %d: %s maximum erasure value %d\n", i, Arrays.toString(testCases[i]),
                    result);
        }
    }
}