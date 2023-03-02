package answerqueries;

import java.util.Arrays;

/*
 * Given an integer array nums, an array queries where queries[i] = [x, y]
 * and an integer limit, return a boolean array that represents the answer
 * to each query. A query is true if the sum of the subarray from x to y is
 * less than limit, or false otherwise.
 */

class AnswerQueries {

    public boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            int curr = prefix[y] - prefix[x] + nums[x];
            ans[i] = curr < limit;
        }

        return ans;
    }

    public static void main(String[] args) {

        class TestCase {
            int[] nums;
            int[][] queries;
            int limit;

            TestCase(int[] nums, int[][] queries, int limit) {
                this.nums = nums;
                this.queries = queries;
                this.limit = limit;
            }
        }

        TestCase[] testCases = {
                new TestCase(
                        new int[] { 1, 6, 3, 2, 7, 2 },
                        new int[][] { { 0, 3 }, { 2, 5 }, { 2, 4 } }, 13),
        };
        AnswerQueries aq = new AnswerQueries();
        for (int i = 0; i < testCases.length; i++) {
            boolean[] result = aq.answerQueries(testCases[i].nums, testCases[i].queries, testCases[i].limit);
            System.out.printf("Case %d: %s, queries %s, limit %d %s\n", i, Arrays.toString(testCases[i].nums),
                    Arrays.deepToString(testCases[i].queries), testCases[i].limit, Arrays.toString(result));
        }
    }
}