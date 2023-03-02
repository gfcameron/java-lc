package answerqueries;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnswerQueriesTest {

    private static AnswerQueries aq;

    @BeforeClass
    public static void setUp() throws Exception {
        aq = new AnswerQueries();
    }

    @Test
    public void case0() {
        int[] nums = { 1, 6, 3, 2, 7, 2 };
        int[][] queries = { { 0, 3 }, { 2, 5 }, { 2, 4 } };
        int limit = 13;
        boolean[] result = aq.answerQueries(nums, queries, limit);
        Assert.assertArrayEquals(result, new boolean[] { true, false, true });
    }
}