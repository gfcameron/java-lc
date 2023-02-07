package binarysearch;

class BinarySearch {

    public int search(int[] nums, int target) {
        // Start from middle of the list
        int i = nums.length/2;

        if (i>0) {
            // Need search rounded up to next power of 2.
            int delta = i>>1;
            for (int mask = delta >> 1; mask != 0; mask >>=1) {
                delta |= mask;
            }
            delta++;

            // Need to ensure delta is rounded up or we will miss entries.
            while (delta !=0) {
                int num = nums[i];
                if (num < target) {
                    i = Integer.min(nums.length-1, i + delta);
                } else if (num == target) {
                    return i;
                } else {
                    i = Integer.max(0, i - delta);
                }
                delta >>= 1;
            };
        }
        // Check if we stepped past the end of list
        if (nums[i] == target) {
            return i;
        }
        return -1;
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
            new TestCase(new int[]{-1,0,3,5,9,12}, 9),
            new TestCase(new int[]{-1,0,3,5,9,12}, 2),
            new TestCase(new int[]{-1,0,3,5,9,12}, 0),
            new TestCase(new int[]{-1,0,3,5,9,12}, 12),
            new TestCase(new int[]{-1,0,3,5,9,12,15}, 9),
            new TestCase(new int[]{-1,0,3,5,9,12,15}, 0),
            new TestCase(new int[]{-1,0,3,5,9,12,15}, 15),
            new TestCase(new int[]{-1,0,3,5,9,12,15}, 2),
            new TestCase(new int[]{-1,0}, 0),
            new TestCase(new int[]{-1,0}, 2)
        };

        BinarySearch bs = new BinarySearch();

        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %d\n", i, bs.search(testCases[i].array, testCases[i].target));
        }
    }
}