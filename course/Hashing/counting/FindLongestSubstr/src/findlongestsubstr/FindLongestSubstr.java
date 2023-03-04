package findlongestsubstr;

import java.util.HashMap;
import java.util.Map;

/*
You are given a string s and an integer k. Find the length of the longest
substring that contains at most k distinct characters.
 */

class FindLongestSubstr {

    public int findLongestSubstring(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            while (counts.size() > k) {
                char remove = s.charAt(left);
                counts.put(remove, counts.getOrDefault(remove, 0) - 1);
                if (counts.get(remove) == 0) {
                    counts.remove(remove);
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        class TestCase {
            String s;
            int k;

            TestCase(String s, int k) {
                this.s = s;
                this.k = k;
            }
        }

        TestCase[] testCases = {
                new TestCase("eceba", 2),
                new TestCase("abccbaacz", 2),
                new TestCase("abcdd", 2),
                new TestCase("abcdeda", 3),
        };
        FindLongestSubstr rc = new FindLongestSubstr();
        for (int i = 0; i < testCases.length; i++) {
            int result = rc.findLongestSubstring(testCases[i].s, testCases[i].k);
            System.out.printf("Case %d: %s longest substr with max %d unique characters %d\n", i, testCases[i].s,
                    testCases[i].k, result);
        }
    }
}