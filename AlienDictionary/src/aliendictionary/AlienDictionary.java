package aliendictionary;

class AlienDictionary {

    /**
     * @param words Words to be checked
     * @param order Character order
     * @return true or false
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] charMap = new int[26];
        for (int i = 0; i < order.length(); i++){
            charMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j >= words[i + 1].length()) {
                    return false;
                }
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currentWordChar = words[i].charAt(j) - 'a';
                    int nextWordChar = words[i + 1].charAt(j) - 'a';
                    if (charMap[currentWordChar] > charMap[nextWordChar]) return false;
                    // if we find the first different letter and they are sorted,
                    // then there's no need to check remaining letters
                    else break;
                }
            }
        }
        return true;
    }

    static class Case {
        String[] words;
        String order;

        Case(String[] words, String order) {
            this.words = words;
            this.order = order;
        }
    };

    public static void main(String[] args) {

        Case[] testCases = {
            new Case(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"),
            new Case(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz")
        };

        AlienDictionary ad = new AlienDictionary();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %s\n", i, ad.isAlienSorted(testCases[i].words, testCases[i].order));
        }
    }
}