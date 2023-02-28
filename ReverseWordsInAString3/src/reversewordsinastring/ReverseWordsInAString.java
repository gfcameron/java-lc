package reversewordsinastring;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be
separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.

 */


class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word: words) {
            // Get working StringBuilder
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            result = result.append(sb).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {

        String[] testCases = {
            "Let's take LeetCode contest",
            "God Ding"
        };
        ReverseWordsInAString rs = new ReverseWordsInAString();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            // Print reversed strings
            System.out.println(rs.reverseWords(testCases[i]));
        }
    }
}