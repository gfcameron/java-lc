package issubsequence;

/*
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 */

class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {

        String[][] testCases = {
                { "ace", "abcde" },
                { "acf", "abcde" }
        };
        IsSubsequence cip = new IsSubsequence();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = cip.isSubsequence(testCases[i][0], testCases[i][1]);
            System.out.printf("Case %d: %s is a subseet of %s %b\n", i, testCases[i][0], testCases[i][1], result);
        }
    }
}