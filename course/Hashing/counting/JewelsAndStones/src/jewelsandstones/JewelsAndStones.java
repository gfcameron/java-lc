package jewelsandstones;

import java.util.HashSet;
import java.util.Set;

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 */

class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        // Mark jewel types
        for (char ch : jewels.toCharArray()) {
            // Add one to the losers loss count
            set.add(ch);
        }
        int num = 0;
        // Look for jewel type in stones and count
        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {

        String[][] testCases = {
                {
                        "aA", "aAAbbbb"
                },
                {
                        "z", "ZZ"
                },
        };
        JewelsAndStones jas = new JewelsAndStones();
        for (int i = 0; i < testCases.length; i++) {
            int result = jas.numJewelsInStones(testCases[i][0], testCases[i][1]);
            System.out.printf("Case %d: jewels %s stones %s %d\n", i, testCases[i][0], testCases[i][1], result);
        }
    }
}