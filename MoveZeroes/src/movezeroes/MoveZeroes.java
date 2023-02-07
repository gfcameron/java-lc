package movezeroes;

import java.util.Arrays;

class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int shift = 0;
        for (int i = 0; (i+shift) < nums.length; i++ ) {
            // Skip if not zero
            while (((i+shift) < nums.length) && (nums[(i+shift)] == 0))  {
                shift++;
            }
            if (((i+shift) < nums.length) && (shift > 0)) {
                nums[i] = nums[i+shift];
            }
        }
        // Zero fill the remainder
        for (int i = nums.length-shift; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {

        int[][] testCases = {
            new int[]{0,1,0,3,12},
            new int[]{0}
        };
        MoveZeroes mz = new MoveZeroes();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            mz.moveZeroes(testCases[i]);
            // Print array
            System.out.println(Arrays.toString(testCases[i]));
        }
    }
}