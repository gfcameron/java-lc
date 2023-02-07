package longestsubstr;

import java.util.HashSet;
import java.util.Set;

class LongestSubstr {

    public int lengthOfLongestSubstring(String s) {   
        int longest = Math.min(1,s.length());
        for (int spos = 0;spos < s.length()-longest;spos++) {
            char sch = s.charAt(spos);
            Set<Character> set = new HashSet<Character>();
            set.add(sch);
            for(int epos = spos+1; epos <= s.length(); epos++){
                if (epos == s.length() || !set.add(s.charAt(epos))) {
                    int diff = epos-spos;
                    longest = Math.max(diff,longest);
                    break;
                }
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
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            // Print reversed strings
            System.out.println(ls.lengthOfLongestSubstring(testCases[i]));
        }
    }
}