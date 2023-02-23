import java.util.*;
class RansomNote {

/* 
Given two strings ransomNote and magazine, return true if ransomNote can be constructed
    by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.
*/


    private Map<Character, Integer> constructLetterMap(String words) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : words.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count+1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> noteMap = constructLetterMap(ransomNote);
        Map<Character, Integer> magMap = constructLetterMap(magazine);

        for (Map.Entry<Character, Integer> entry : noteMap.entrySet() ) {
            Character ch = entry.getKey();
            // Do we have enough characters?
            if (!magMap.containsKey(ch) || (magMap.get(ch) < entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        class TestCase {
            String ransomNote;
            String magazine;

            TestCase(String ransomNote, String magazine) {
                this.ransomNote = ransomNote;
                this.magazine = magazine;
            }
        };

        TestCase[] testCases = {
            new TestCase( "a", "b" ),
            new TestCase( "aa", "ab" ),
            new TestCase( "aa", "aab" )
        };
        RansomNote note = new RansomNote();
        for ( int i=0; i < testCases.length; i++ ) {
            TestCase tc = testCases[i];
            System.out.printf("Case %d: %b\n", i, note.canConstruct(tc.ransomNote, tc.magazine));
        }
    }

}