package isomorphicstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving
the order of characters. No two characters may map to the same character, but a character
may map to itself.

 */

class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            // character has been seen before
            if (map.containsKey(cs)) {
                if (ct != map.get(cs)) {
                    return false;
                }
            } else {
                // new character, should be able to add it to the t set
                if (!set.add(ct)) {
                    return false;
                }
                map.put(cs, ct);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[][] testCases = {
                {
                        "badc", "baba"
                },
                {
                        "egg", "add"
                },
                {
                        "foo", "bar"
                },
                {
                        "paper", "title"
                },
        };
        IsomorphicStrings is = new IsomorphicStrings();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = is.isIsomorphic(testCases[i][0], testCases[i][1]);
            System.out.printf("Case %d: Strings %s and %s %b\n", i, testCases[i][0], testCases[i][1], result);
        }
    }
}