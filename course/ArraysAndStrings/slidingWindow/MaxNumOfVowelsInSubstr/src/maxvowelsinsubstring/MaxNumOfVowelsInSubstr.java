package maxvowelsinsubstring;

/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring
of s with length k.
 */

class MaxNumOfVowelsInSubstr {

    final static private String VOWELS = "AEIOUaeiou";

    public int maxVowels(String s, int k) {
        int len = s.length();
        int vowels = 0;
        int winSize = k < len ? k : len;
        // Fixed window of size k, calculate initial elements
        for (int i = 0; i < winSize; i++) {
            if (VOWELS.indexOf(s.charAt(i)) >= 0) {
                vowels++;
            }
        }
        int maxVowels = vowels;
        int right = winSize;
        for (int left = 0; left < len - winSize; left++) {
            // Sliding out a vowel?
            if (VOWELS.indexOf(s.charAt(left)) >= 0) {
                vowels--;
            }
            // Sliding in a vowel?
            if (VOWELS.indexOf(s.charAt(right++)) >= 0) {
                vowels++;
                maxVowels = (maxVowels > vowels) ? maxVowels : vowels;
            }
        }
        return maxVowels;
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
                new TestCase("abciiidef", 3),
                new TestCase("aeiou", 2),
                new TestCase("leetcode", 3),
                new TestCase("rhythms", 4),
        };
        MaxNumOfVowelsInSubstr mv = new MaxNumOfVowelsInSubstr();
        for (int i = 0; i < testCases.length; i++) {
            int result = mv.maxVowels(testCases[i].s, testCases[i].k);
            System.out.printf("Case %d: %s with substring length k=%d is %d\n", i,
                    testCases[i].s, testCases[i].k, result);
        }
    }
}