package reverseonlyletters;

/*
Given a string s, reverse the string according to the following rules:

    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.

Return s after reversing it.

 */

class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        // Mutable copy
        char[] sch = s.toCharArray();
        int right = s.length() - 1;
        for (int left = 0; left <= right; left++) {
            // Skip invalid characters on left and right
            char lch = sch[left];
            if (Character.isAlphabetic(lch)) {
                // Swap with next valid right
                do {
                    char rch = sch[right];
                    if (Character.isAlphabetic(rch)) {
                        sch[left] = sch[right];
                        sch[right--] = lch;
                        break;
                    }
                } while (--right > left);
            }
        }
        return new String(sch);
    }

    public static void main(String[] args) {

        String[] testCases = {
                "ab-cd",
                "a-bC-dEf-ghIj",
                "Test1ng-Leet=code-Q!"
        };
        ReverseOnlyLetters rol = new ReverseOnlyLetters();
        for (int i = 0; i < testCases.length; i++) {
            String res = rol.reverseOnlyLetters(testCases[i]);
            System.out.printf("Case %d: %s to %s\n", i, testCases[i], res);
        }
    }
}