package reverseprefix;

/*
Given a 0-indexed string word and a character ch, reverse the segment of word that starts at
index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch
does not exist in word, do nothing.

 */

class ReversePrefix {

    public String reversePrefix(String word, char ch) {
        // Mutable copy
        char[] sch = word.toCharArray();
        for (int right = 0; right < sch.length; right++) {
            if (sch[right] == ch) {
                // Do the swap from here
                for (int left = 0; left < right; left++) {
                    char temp = sch[left];
                    sch[left] = sch[right];
                    sch[right--] = temp;
                }
                break;
            }
        }
        return new String(sch);
    }

    public static void main(String[] args) {
        class TestCase {
            String word;
            char ch;

            TestCase(String word, char ch) {
                this.word = word;
                this.ch = ch;
            }
        }
        TestCase[] testCases = {
                new TestCase("abcdefd", 'd'),
                new TestCase("xyxzxe", 'z'),
                new TestCase("abcd", 'z'),
        };
        ReversePrefix rol = new ReversePrefix();
        for (int i = 0; i < testCases.length; i++) {
            String res = rol.reversePrefix(testCases[i].word, testCases[i].ch);
            System.out.printf("Case %d: %s with %c to %s\n", i, testCases[i].word, testCases[i].ch, res);
        }
    }
}