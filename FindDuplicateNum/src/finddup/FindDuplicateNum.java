package finddup;

import java.util.*;

class FindDuplicateNum {

    public int findDuplicateNum(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums) {
            if (!s.add(num)) {
                return num;
            }
        }
        return Integer.MIN_VALUE;
    }

    public int findDuplicateNum2(int[] list) {
        for (int i=0; i < list.length; i++) {
            for (int j=i+1; j < list.length; j++) {
                if (list[i] == list[j]) {
                    return list[i];
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] testCase0 = {1,3,4,2,2};
        int[] testCase1 = {3,1,3,4,2};
        int[] testCase2 = {1,2,3,4,5};

        int[][] testCases = { testCase0, testCase1, testCase2 };
        FindDuplicateNum rconv = new FindDuplicateNum();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %d\n", i, rconv.findDuplicateNum(testCases[i]));
        }
    }
}