package isbadversion;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class IsBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        // Start from middle of the list
        int version = Integer.max(n>>1, 1);

        // Run initial check before changing
        boolean isBad = isBadVersion(version);

        // Need search rounded up to next power of 2.
        int delta = (version+1)>>1;
        for (int mask = delta >> 1; mask != 0; mask >>=1) {
            delta |= mask;
        }
        delta++;

        // Need to ensure delta is rounded up or we will miss entries.
        while (delta !=0) {
            if (isBad) {
                version = Integer.max(1, version - delta);
            } else {
                version = Integer.min(n, version + delta);
            }
            isBad = isBadVersion(version);
            delta >>= 1;
        };

        if (!isBad) {
            version++;
        }
        return version;
    }


    public static void main(String[] args) {
    
        class TestCase {
            int version;
            int badVersion;

            TestCase(int version, int badVersion) {
                this.version = version;
                this.badVersion = badVersion;
            }
        }

        TestCase[] testCases = {
            new TestCase(5, 4),
            new TestCase(1, 1),
        };
        IsBadVersion bv = new IsBadVersion();
        for (int i=0; i < testCases.length; i++ ) {
            bv.setBadVersion(testCases[i].badVersion);
            System.out.printf("Case %d: %d\n", i, bv.firstBadVersion(testCases[i].version));
        }
    }
}