package twosum2;

import java.util.Arrays;

class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        if (numbers.length > 1) {
            int left = 0;
            int right = numbers.length-1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    result[0] = left+1;
                    result[1] = right+1;
                    return result;
                }
            }
        }
        // Error case
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        class TestCase {
            int[] array;
            int target;

            TestCase(int[] array, int target) {
                this.array = array;
                this.target = target;
            }
        }

        TestCase[] testCases = {
            new TestCase(new int[]{2,7,11,15}, 9),
            new TestCase(new int[]{2,3,4}, 6),
            new TestCase(new int[]{-1,0}, -1)
        };
        TwoSum2 ts = new TwoSum2();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            // Print array
            System.out.println(Arrays.toString(ts.twoSum(testCases[i].array, testCases[i].target)));
        }
    }
}