package roman;

import java.util.*;

class IntToRoman {

    private static TreeMap<Integer, String> binarysearchNumMap = new TreeMap<Integer, String>()
    {
        {
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }
   };

   NavigableMap<Integer, String> dmap = Collections.unmodifiableNavigableMap(binarysearchNumMap.descendingMap());

    public static Map<Integer, String> getMap() {
        return Collections.unmodifiableMap(binarysearchNumMap);
    }

    public String isValid(int num) {
        String result = "";
    
        while (num > 0) {
            // Iterate in reverse over map
            for(NavigableMap.Entry<Integer, String> entry : dmap.entrySet()) {
                if (num >= entry.getKey()) {
                    num -= entry.getKey();
                    result += entry.getValue();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testCases = { 3, 47, 1994, 0 };
        IntToRoman rconv = new IntToRoman();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %s\n", i, rconv.isValid(testCases[i]));
        }
    }
}