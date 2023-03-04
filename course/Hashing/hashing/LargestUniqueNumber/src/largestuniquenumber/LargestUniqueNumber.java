package largestuniquenumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums, return the largest integer that only occurs once.
If no integer occurs once, return -1.
 */

class LargestUniqueNumber {

    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, true); // Mark as non-unique
            } else {
                map.put(num, false);
            }
        }
        int largest = -1; // Return -1 if not found
        for (int num : map.keySet()) {
            if (!map.get(num)) {
                largest = Math.max(largest, num);
            }
        }
        return (largest);
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 5, 7, 3, 9, 4, 9, 8, 3, 1 },
                { 9, 9, 8, 8 },
        };

        LargestUniqueNumber lun = new LargestUniqueNumber();
        for (int i = 0; i < testCases.length; i++) {
            int result = lun.largestUniqueNumber(testCases[i]);
            System.out.printf("Case %d: %s largest unique number is %d\n", i, Arrays.toString(testCases[i]),
                    result);
        }
    }
}