package twostringsareclose;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Two strings are considered close if you can attain one from the other using the following operations:

    Operation 1: Swap any two existing characters.
        For example, abcde -> aecdb
    Operation 2: Transform every occurrence of one existing character into another existing character,
    and do the same with the other character.
        For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */

class TwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) {
            return false;
        }
        // Create a frequency map for both strings
        Map<Character, Integer> counts1 = new HashMap<>();
        Map<Character, Integer> counts2 = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            counts1.put(ch1, counts1.getOrDefault(ch1, 0) + 1);
            counts2.put(ch2, counts2.getOrDefault(ch2, 0) + 1);
        }
        Integer[] cnt1 = counts1.values().toArray(new Integer[0]);
        Arrays.sort(cnt1);
        Integer[] cnt2 = counts2.values().toArray(new Integer[0]);
        Arrays.sort(cnt2);
        if (!Arrays.equals(cnt1, cnt2)) {
            return false;
        }
        Character[] key1 = counts1.keySet().toArray(new Character[0]);
        Arrays.sort(key1);
        Character[] key2 = counts2.keySet().toArray(new Character[0]);
        Arrays.sort(key2);
        return Arrays.equals(key1, key2);
    }

    public static void main(String[] args) {

        String[][] testCases = {
                {
                        "abc", "bca"
                },
                {
                        "a", "aa"
                },
                {
                        "cabbba", "abbccc"
                },
                {
                        "uau", "ssx"
                },
        };
        TwoStringsAreClose tsac = new TwoStringsAreClose();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = tsac.closeStrings(testCases[i][0], testCases[i][1]);
            System.out.printf("Case %d: s1=%s s2=%s close %b\n", i, testCases[i][0], testCases[i][1], result);
        }
    }
}