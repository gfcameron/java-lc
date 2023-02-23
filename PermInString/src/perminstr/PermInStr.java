package perminstr;

import java.util.Arrays;

/*

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
 
*/

class PermInStr {

    private int charShift(char ch) {
        return (int)(ch-'a');
    }

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len > s2Len) {
            return false;
        }

        // Count of characters in src and destination
        char[] srcLetters = new char[26];
        char[] dstLetters = new char[26];

        // Initialize the reference window
        for (int pos=0; pos < s1Len; pos++) {
            srcLetters[charShift(s1.charAt(pos))]+=1;
            dstLetters[charShift(s2.charAt(pos))]+=1;
        }
        if (Arrays.equals(srcLetters, dstLetters)) {
            return true;
        }

        for (int pos=1; pos <= s2Len - s1Len; pos++) {
            // Slide the check window
            dstLetters[charShift(s2.charAt(pos-1))]-=1;
            dstLetters[charShift(s2.charAt(pos+s1Len-1))]+=1;
            if (Arrays.equals(srcLetters, dstLetters)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[][] testCases = {
            {"ab", "eidbaooo"},
            {"ab", "eidboaoo"}
        };
        PermInStr pis = new PermInStr();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:%b\n", i, pis.checkInclusion(testCases[i][0], testCases[i][1]));
        }
    }
}