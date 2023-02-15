package binarysearch;

class BinarySearch {

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        if ((lo == nums.length) || (nums[lo] != target)) {
            return -1;
        }
        return lo;
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