package getequalsubstringswithinbudget;

/*
You are given two strings s and t of the same length and an integer maxCost.

You want to change s to t. Changing the ith character of s to ith character of t
costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).

Return the maximum length of a substring of s that can be changed to be the same as the corresponding
substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be
changed to its corresponding substring from t, return 0.
 */

class GetEqualSubstringsWithinBudget {

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int left = 0, right;
        for (right = 0; right < len; right++) {
            int diff = s.charAt(right) - t.charAt(right);
            diff = diff > 0 ? diff : -diff;
            if (diff > 0) {
                maxCost -= diff;
            }
            // If maxCost reaches 0, we can't flip anymore
            if (maxCost < 0) {
                // Move the left side of the window, see if we lose a mismatch
                diff = s.charAt(left) - t.charAt(left);
                diff = diff > 0 ? diff : -diff;
                if (diff > 0) {
                    maxCost += diff;
                }
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        class TestCase {
            String s;
            String t;
            int maxCost;

            TestCase(String s, String t, int maxCost) {
                this.s = s;
                this.t = t;
                this.maxCost = maxCost;
            }
        }
        TestCase[] testCases = {
                new TestCase("abcd", "bcdf", 3),
                new TestCase("abcd", "cdef", 3),
                new TestCase("abcd", "acde", 0),
        };
        GetEqualSubstringsWithinBudget ges = new GetEqualSubstringsWithinBudget();
        for (int i = 0; i < testCases.length; i++) {
            int result = ges.equalSubstring(testCases[i].s, testCases[i].t, testCases[i].maxCost);
            System.out.printf("Case %d: s=%s t=%s with maxCost=%d is %d\n", i,
                    testCases[i].s, testCases[i].t, testCases[i].maxCost, result);
        }
    }
}