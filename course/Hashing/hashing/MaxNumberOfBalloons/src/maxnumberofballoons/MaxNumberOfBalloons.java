package maxnumberofballoons;

import java.util.Arrays;

/*
Given a string s, determine if all characters have the same frequency.
 */

class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        // b,a,l,o,n
        int needed[] = { 0, 0, 0, 0, 0 };
        // Count frequency
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    needed[0]++;
                    break;
                case 'a':
                    needed[1]++;
                    break;
                case 'l':
                    needed[2]++;
                    break;
                case 'o':
                    needed[3]++;
                    break;
                case 'n':
                    needed[4]++;
                    break;
                default:
                    continue;
            }
        }
        // Letters 'l' and 'o' are needed 2x
        needed[2] /= 2;
        needed[3] /= 2;
        // lowest adjusted frequency will be first
        Arrays.sort(needed);
        return needed[0];
    }

    public static void main(String[] args) {

        String[] testCases = {
                "nlaebolko",
                "loonbalxballpoon",
                "leetcode",
        };
        MaxNumberOfBalloons nb = new MaxNumberOfBalloons();
        for (int i = 0; i < testCases.length; i++) {
            int result = nb.maxNumberOfBalloons(testCases[i]);
            System.out.printf("Case %d: %s %d\n", i, testCases[i], result);
        }
    }
}