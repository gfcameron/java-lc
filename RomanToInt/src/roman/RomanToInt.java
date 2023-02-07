package roman;

import java.util.*;

class RomanToInt {

    private static final HashMap<Character, Integer> romanNumMap = new HashMap<Character, Integer>()
    {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
   };

    public static Map<Character, Integer> getMap() {
        return Collections.unmodifiableMap(romanNumMap);
    }

    public int romanToInt(String s) {
        int result = 0;
        // Need to keep track of what the last character was
        int prevNum = 0;
        for (char curCh : s.toCharArray()) {
            int curNum;
            curNum = getMap().getOrDefault(curCh, 0);
            // See if subtraction rule is in effect
            result += curNum;
        if (curNum > prevNum) {
                // Last step we added when we should have subtracted
                result -= prevNum * 2;
            }
            prevNum = curNum;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "III",
            "LVII",
            "MCMXCIV"
        };
        RomanToInt rconv = new RomanToInt();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %s\n", i, rconv.romanToInt(testCases[i]));
        }
    }
}