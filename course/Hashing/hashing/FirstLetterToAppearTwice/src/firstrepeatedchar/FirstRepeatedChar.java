package firstrepeatedchar;

/*
Given a string s, return the first character to appear (at least) twice. It is guaranteed that the
input will have a duplicate character.
 */

class FirstRepeatedChar {

    public char repeatedCharacter(String s) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            if (++counts[ch - 'a'] == 2) {
                return ch;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

        String[] testCases = {
                "abccbaacz",
                "abcdd",
                "abcdeda"
        };
        FirstRepeatedChar rc = new FirstRepeatedChar();
        for (int i = 0; i < testCases.length; i++) {
            char result = rc.repeatedCharacter(testCases[i]);
            System.out.printf("Case %d: %s %c\n", i, testCases[i], result);
        }
    }
}