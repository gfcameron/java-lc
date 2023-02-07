package isbadversion;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class IsBadVersionTest {

    private static IsBadVersion isBadVersion;

    @BeforeClass
    public static void setUp() throws Exception {
        isBadVersion = new IsBadVersion();
    }

    @Test
    public void case0() {
        // Set the bad version
        isBadVersion.setBadVersion(4);
        Assert.assertEquals(4, isBadVersion.firstBadVersion(5));
    }

    @Test
    public void case1() {
        // Set the bad version
        isBadVersion.setBadVersion(1);
        Assert.assertEquals(1, isBadVersion.firstBadVersion(1));
    }

    @Test
    public void case2() {
        // Set the bad version
        isBadVersion.setBadVersion(2);
        Assert.assertEquals(2, isBadVersion.firstBadVersion(2));
    }

    @Test
    public void case3() {
        // Set the bad version
        isBadVersion.setBadVersion(3);
        Assert.assertEquals(3, isBadVersion.firstBadVersion(2));
    }

    @Test
    public void case4() {
        // Set the bad version
        isBadVersion.setBadVersion(500);
        Assert.assertEquals(500, isBadVersion.firstBadVersion(500));
    }

    @Test
    public void case5() {
        // Set the bad version
        isBadVersion.setBadVersion(1);
        Assert.assertEquals(1, isBadVersion.firstBadVersion(500));
    }

    @Test
    public void case6() {
        // Set the bad version
        isBadVersion.setBadVersion(223);
        Assert.assertEquals(223, isBadVersion.firstBadVersion(500));
    }

}