package russiandollenvelope;

import java.util.Arrays;

/* 
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents 
the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one
envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.
*/

class RussianDollEnvelope {
  
    public int maxEnvelopes(int[][] envelopes) {
      // Sort envelopes by increasing width first, decreasing height if widths are equal
      Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
  
      // Same as 300. Longest Increasing Subsequence
      int result = 0;
      // Height of envelopes that fit
      int[] dp = new int[envelopes.length];
      // Try each envelope smallest to largest
      for (int[] env : envelopes) {
        // Search 0..ans in dp for e[1] (Width)
        int i = Arrays.binarySearch(dp, 0, result, env[1]);
        if (i < 0) {
          i = -(i + 1);
        }
        // Preserve the height
        dp[i] = env[1];
        if (i == result) {
          ++result;
        }
      }  
      return result;
    }

    public static void main(String[] args) {
      int[][][] testCases = {
        {{5,4},{6,4},{6,7},{2,3}},
        {{1,1},{1,1},{1,1}},
        {{4,5},{4,6},{6,7},{2,3},{1,1}}
      };
      RussianDollEnvelope rdu = new RussianDollEnvelope();
      for ( int i=0; i < testCases.length; i++ ) {
          System.out.printf("Case %d: %d\n", i, rdu.maxEnvelopes(testCases[i]));
      }
    }
  }
  