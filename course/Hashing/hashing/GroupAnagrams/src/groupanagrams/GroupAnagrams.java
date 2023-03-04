package groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence
is a pangram, or false otherwise.
 */

class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<String>());
            }

            groups.get(key).add(s);
        }

        return new ArrayList<List<String>>(groups.values());
    }

    public static void main(String[] args) {

        String[][] testCases = {
                {
                        "eat", "tea", "tan", "ate", "nat", "bat"
                },
                {
                        ""
                },
                {
                        "a"
                }
        };
        GroupAnagrams groupAna = new GroupAnagrams();
        for (int i = 0; i < testCases.length; i++) {
            List<List<String>> result = groupAna.groupAnagrams(testCases[i]);

            System.out.printf("Case %d: %s %s\n", i, Arrays.toString(testCases[i]),
                    Arrays.toString(result.toArray()));

        }
    }
}
