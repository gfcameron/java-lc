package customsortstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between
a letter in pattern and a non-empty word in s.

 */

class CustomSortString {

    public String customSortString(String order, String s) {
        int slen = s.length();
        int olen = order.length();
        char[] sc = s.toCharArray();
        // Create a frequency map
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : sc) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        // Create set with order
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < Math.min(olen, slen); i++) {
            set.add(order.charAt(i));
        }
        char[] result = new char[s.length()];
        int i = 0;
        for (char ch : order.toCharArray()) {
            // Add frequency times
            for (int j = 0; j < counts.getOrDefault(ch, 0); j++) {
                result[i++] = ch;
                // Have we processed the entire string?
                if (i == slen) {
                    return new String(result);
                }
            }
        }
        // Finally, append any character with no match in map in original order.
        for (char ch : sc) {
            if (!set.contains(ch)) {
                result[i++] = ch;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {

        String[][] testCases = {
                {
                        "kqep", "pekeq"
                },
                {
                        "cba", "abcd"
                },
                {
                        "cbafg", "abcd"
                },
        };
        CustomSortString css = new CustomSortString();
        for (int i = 0; i < testCases.length; i++) {
            String result = css.customSortString(testCases[i][0], testCases[i][1]);
            System.out.printf("Case %d: Order=%s s=%s output %s\n", i, testCases[i][0], testCases[i][1], result);
        }
    }
}