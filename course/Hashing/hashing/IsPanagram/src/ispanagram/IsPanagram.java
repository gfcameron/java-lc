package ispanagram;

import java.util.HashSet;
import java.util.Set;

/*
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence
is a pangram, or false otherwise.
 */

class IsPanagram {

    public boolean checkIfPangram(String sentence) {
        char[] sch = sentence.toCharArray();
        Set<Character> seen = new HashSet<>();
        for (char c : sch) {
            seen.add(c);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!seen.contains(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "thequickbrownfoxjumpsoverthelazydog",
                "leetcode",
                "nowisthetimeforallgoodmentocometotheaidoftheparty",
                "onrcsnlxckptsxffbyswujpamfltvmdoxovggepknmtacrjkkorjgvgtgaiaudspnpxkwikevmjeephhiyvnoymjwjfopovscbefecnoytjxfwasabwohqujwowmakpyuuqvgfab"
        };
        IsPanagram ispana = new IsPanagram();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = ispana.checkIfPangram(testCases[i]);
            System.out.printf("Case %d: %s %b\n", i, testCases[i], result);
        }
    }
}