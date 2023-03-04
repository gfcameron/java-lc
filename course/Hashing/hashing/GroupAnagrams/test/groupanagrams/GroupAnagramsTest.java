package groupanagrams;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GroupAnagramsTest {

    private static GroupAnagrams groupAna;

    @BeforeClass
    public static void setUp() throws Exception {
        groupAna = new GroupAnagrams();
    }

    @Test
    public void case0() {
        String[] testCase = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        String[][] expected = {
                { "eat", "tea", "ate" },
                { "bat" },
                { "tan", "nat" },
        };

        List<List<String>> result = groupAna.groupAnagrams(testCase);
        Assert.assertEquals(expected.length, result.size());
        for (int i = 1; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], result.get(i).stream().toArray(String[]::new));
        }
    }

    @Test
    public void case1() {
        String[] testCase = {
                ""
        };
        String[][] expected = {
                { "" },
        };

        List<List<String>> result = groupAna.groupAnagrams(testCase);
        Assert.assertEquals(expected.length, result.size());
        for (int i = 1; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], result.get(i).stream().toArray(String[]::new));
        }
    }

    @Test
    public void case2() {
        String[] testCase = {
                "a"
        };
        String[][] expected = {
                { "a" },
        };

        List<List<String>> result = groupAna.groupAnagrams(testCase);
        Assert.assertEquals(expected.length, result.size());
        for (int i = 1; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], result.get(i).stream().toArray(String[]::new));
        }
    }

}