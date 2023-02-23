package rotatearray;

import java.util.Arrays;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */

class RotateArray {

    public void rotate(int[] nums, int k) {

        int shift = k%nums.length;

        int[] firstFrag = Arrays.copyOfRange(nums, 0, nums.length-shift);
        int[] secondFrag = Arrays.copyOfRange(nums, nums.length-shift, nums.length);

        for (int i=0; i < secondFrag.length; i++) {
            nums[i] = secondFrag[i];
        }
        for (int i=0; i < firstFrag.length; i++) {
            nums[secondFrag.length+i] = firstFrag[i];
        }
    }

    public static void main(String[] args) {

        class TestCase {
            int[] array;
            int rotations;

            TestCase(int[] array, int rotations) {
                this.array = array;
                this.rotations = rotations;
            }
        }

        TestCase[] testCases = {
            new TestCase(new int[]{1,2,3,4,5,6,7}, 3),
            new TestCase(new int[]{-1,-100,3,99}, 2)
        };
        RotateArray ra = new RotateArray();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            ra.rotate(testCases[i].array, testCases[i].rotations);
            // Print array
            System.out.println(Arrays.toString(testCases[i].array));
        }
    }
}