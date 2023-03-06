package wordpatterns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between
a letter in pattern and a non-empty word in s.

 */

class WordPatterns {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] words = s.split(" ");
        // Check error conditions
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) {
                    return false;
                }
                continue;
            }
            // Something new
            if (!set.add(word)) {
                return false;
            }
            map.put(ch, word);
        }
        return true;
    }

    public static void main(String[] args) {

        String[][] testCases = {
                {
                        "aaa", "aa aa aa aa"
                },
                {
                        "abba", "dog dog dog dog"
                },
                {
                        "abba", "dog cat cat dog"
                },
                {
                        "abba", "dog cat cat fish"
                },
                {
                        "aaaa", "dog cat cat dog"
                },
        };
        WordPatterns wp = new WordPatterns();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = wp.wordPattern(testCases[i][0], testCases[i][1]);
            System.out.printf("Case %d: Pattern %s words %s %b\n", i, testCases[i][0], testCases[i][1], result);
        }
    }
}