package combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
 */

class Combine {

    public List<Integer> combine(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans.add(arr1[i]);
                i++;
            } else {
                ans.add(arr2[j]);
                j++;
            }
        }

        while (i < arr1.length) {
            ans.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            ans.add(arr2[j]);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {

        class TestCase {
            int[] arr1;
            int[] arr2;

            TestCase(int[] arr1, int[] arr2) {
                this.arr1 = arr1;
                this.arr2 = arr2;
            }
        }

        TestCase[] testCases = {
                new TestCase(new int[] { 1, 4, 7, 20 }, new int[] { 3, 5, 6 }),
        };
        Combine cmb = new Combine();
        for (int i = 0; i < testCases.length; i++) {
            List<Integer> res = cmb.combine(testCases[i].arr1, testCases[i].arr2);
            System.out.printf("Case %d: %s,%s to %s\n", i, Arrays.toString(testCases[i].arr1),
                    Arrays.toString(testCases[i].arr2),
                    Arrays.toString(res.stream().mapToInt(Integer::intValue).toArray()));
        }
    }
}