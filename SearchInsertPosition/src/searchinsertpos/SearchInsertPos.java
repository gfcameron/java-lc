package searchinsertpos;

class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        // Start from middle of the list
        int i = nums.length>>1;

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
        // Are we bigger than the last entry?
        if (nums[i] < target) {
            return i+1;
        }
        return i;
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