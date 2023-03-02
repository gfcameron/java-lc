package highestaltitude;

import java.util.Arrays;

/*
There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

 */

class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int len = gain.length;
        int maxAlt = 0; // We are starting from 0 altitude
        int alt = maxAlt;
        for (int i = 0; i < len; i++) {
            alt += gain[i];
            maxAlt = Math.max(maxAlt, alt);
        }
        return maxAlt;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { -5, 1, 5, 0, -7 },
                { -4, -3, -2, -1, 4, 3, 2 },
        };
        FindTheHighestAltitude ha = new FindTheHighestAltitude();
        for (int i = 0; i < testCases.length; i++) {
            int result = ha.largestAltitude(testCases[i]);
            System.out.printf("Case %d: %s highest alititude %d\n", i, Arrays.toString(testCases[i]),
                    result);
        }
    }
}