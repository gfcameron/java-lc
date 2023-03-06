package findluckyintegerinarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers arr, a lucky integer is an integer that has a frequency
in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.
 */

class FindLuckyIntegerInArray {

    public int findLucky(int[] arr) {
        // Count frequency
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int lucky = -1;
        for (int num : arr) {
            if (counts.get(num) == num) {
                lucky = lucky > num ? lucky : num;
            }
        }
        return lucky;
    }

    public int findLucky2(int[] arr) {
        Arrays.sort(arr);
        int cnt = 0, val = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            cnt = 1;
            val = arr[i];
            while (i != 0 && arr[i] == arr[i - 1]) {
                cnt++;
                i--;
            }
            if (val == cnt)
                return val;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 2, 2, 3, 4 },
                { 1, 2, 2, 3, 3, 3 },
                { 2, 2, 2, 3, 3 },
        };

        FindLuckyIntegerInArray fli = new FindLuckyIntegerInArray();
        for (int i = 0; i < testCases.length; i++) {
            int result = fli.findLucky(testCases[i]);
            int result2 = fli.findLucky2(testCases[i]);
            System.out.printf("Case %d: %s lucky number is %d,%d\n", i, Arrays.toString(testCases[i]),
                    result, result2);
        }
    }
}