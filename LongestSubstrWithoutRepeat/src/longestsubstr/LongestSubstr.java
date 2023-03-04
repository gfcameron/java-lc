package longestsubstr;

import java.util.HashSet;
import java.util.Set;

/*
 * Longest substring of non-repeating characters
 */

class LongestSubstr {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int longest = 0;
        int left = 0;
        // Sliding window
        for (int right = 0; right < s.length(); right++) {
            // Check for repeated character in the window set
            if (set.contains(s.charAt(right))) {
                // We hit a repeated character so advance left pointer
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            } else {
                set.add(s.charAt(right));
                longest = Math.max(longest, right - left + 1);
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "abcabcbb",
                "bbbbb",
                "pwwkew"
        };
        LongestSubstr ls = new LongestSubstr();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d:", i);
            // Print reversed strings
            System.out.println(ls.lengthOfLongestSubstring(testCases[i]));
        }
    }
}