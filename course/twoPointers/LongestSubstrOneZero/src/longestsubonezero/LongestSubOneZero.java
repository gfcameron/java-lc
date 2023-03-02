package longestsubonezero;

/*
 * Return true if a given string is a palindrome, false otherwise.
 */

class LongestSubOneZero {

    public int findLength(String s) {
        int left = 0;
        int curr = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                curr++;
            }
            while (curr > 1) {
                if (s.charAt(left) == '0') {
                    curr--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "1101100111",
                "1",
                "0",
                ""
        };
        LongestSubOneZero ls = new LongestSubOneZero();
        for (int i = 0; i < testCases.length; i++) {
            int result = ls.findLength(testCases[i]);
            System.out.printf("Case %d: %s longest is %d\n", i, testCases[i], result);
        }
    }
}