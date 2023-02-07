package reversewordsinastring;

class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer result = new StringBuffer();
        for (String word: words) {
            // Get working stringbuffer
            StringBuffer sb = new StringBuffer(word);
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