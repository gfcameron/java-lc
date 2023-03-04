package intersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a 2D array nums that contains n arrays of distinct integers, return a sorted array 
ontaining all the numbers that appear in all n arrays.
 */

class IntersectionOfMultipleArrays {

    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int[] arr : nums) {
            for (int x : arr) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }
        }

        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int key : counts.keySet()) {
            if (counts.get(key) == n) {
                ans.add(key);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                {
                        { 3, 1, 2, 4, 5 },
                        { 1, 2, 3, 4 },
                        { 3, 4, 5, 6 },
                },
                {
                        { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                },
        };

        IntersectionOfMultipleArrays rconv = new IntersectionOfMultipleArrays();
        for (int i = 0; i < testCases.length; i++) {
            List<Integer> result = rconv.intersection(testCases[i]);
            System.out.printf("Case %d: %s numbers are %s\n", i, Arrays.deepToString(testCases[i]),
                    Arrays.toString(result.toArray()));
        }
    }
}