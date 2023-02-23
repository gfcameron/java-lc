package searchinsertpos;

/*
Given a sorted array of distinct integers and a target value, return the index
if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */
class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
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
            new TestCase(new int[]{1,3,5,6}, 5),
            new TestCase(new int[]{1,3,5,6}, 2),
            new TestCase(new int[]{1,3,5,6}, 7),
            new TestCase(new int[]{1,3,5,6}, 0),
            new TestCase(new int[]{1,3,5,6}, 1),
            new TestCase(new int[]{1,3,5,6}, 6),
            new TestCase(new int[]{1,3,5,6,7}, 5),
            new TestCase(new int[]{1,3,5,6,7}, 2),
            new TestCase(new int[]{1,3,5,6,7}, 8),
            new TestCase(new int[]{1,3,5,6,7}, 0),
            new TestCase(new int[]{1,3,5,6,7}, 1),
            new TestCase(new int[]{1,3,5,6,7}, 7),
        };

        SearchInsertPosition sip = new SearchInsertPosition();

        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %d\n", i, sip.searchInsert(testCases[i].array, testCases[i].target));
        }
    }
}