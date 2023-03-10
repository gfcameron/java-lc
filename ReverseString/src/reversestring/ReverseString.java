package reversestring;

import java.util.Arrays;

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
 */

class ReverseString {

    public void reverseString(char[] s) {
        for (int i=0; i < s.length/2; i++) {
            char ch = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = ch;
        }
    }

    public static void main(String[] args) {

        char[][] testCases = {
            {'h', 'e', 'l', 'l', 'o'},
            {'H', 'a', 'n', 'n', 'a', 'h'}
        };
        ReverseString rs = new ReverseString();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            rs.reverseString(testCases[i]);
            // Print array
            System.out.println(Arrays.toString(testCases[i]));
        }
    }
}