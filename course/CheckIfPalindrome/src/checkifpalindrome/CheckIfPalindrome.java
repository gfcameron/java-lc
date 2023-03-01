package checkifpalindrome;

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
 */

class CheckIfPalindrome {

    public boolean checkIfPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "racecar",
                "abba",
                "boulder"
        };
        CheckIfPalindrome cip = new CheckIfPalindrome();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = cip.checkIfPalindrome(testCases[i]);
            System.out.printf("Case %d: %s %t", i, testCases[i], result);
        }
    }
}