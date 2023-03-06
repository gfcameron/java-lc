package sequentialdigits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
*/

class SequentialDigits {

  public List<Integer> sequentialDigits(int low, int high) {
    int lowDigits = (int) Math.log10(low) + 1;
    int lowMSD = (int) (low / Math.pow(10.0, lowDigits - 1));
    List<Integer> results = new ArrayList<>();
    for (int totalDigits = lowDigits; totalDigits <= 9; totalDigits++) {
      for (int firstDigit = lowMSD; firstDigit + totalDigits <= 10; firstDigit++) {
        // Build number
        int num = firstDigit;
        for (int i = 1; i < totalDigits; i++) {
          num = (num * 10) + (firstDigit + i);
        }
        System.out.println(num);
        if (num < low) {
          continue;
        }
        if (num <= high) {
          results.add(num);
        } else {
          return results;
        }
      }
      lowMSD = 1;
    }
    return results;
  }

  public List<Integer> sequentialDigits2(int low, int high) {
    String digits = "123456789";
    int l = String.valueOf(low).length();
    int h = String.valueOf(high).length();
    ArrayList<Integer> arr = new ArrayList<>();

    for (int i = l; i <= h; i++) {
      for (int j = 0; j < 10 - i; j++) {
        int num = Integer.parseInt(digits.substring(j, j + i));
        if (num >= low && num <= high) {
          arr.add(num);
        }
      }
    }
    Collections.sort(arr);
    return arr;
  }

  public static void main(String[] args) {
    int[][] testCases = {
        { 100, 300 },
        { 1000, 13000 },
    };
    SequentialDigits sd = new SequentialDigits();
    for (int i = 0; i < testCases.length; i++) {
      List<Integer> result = sd.sequentialDigits(testCases[i][0], testCases[i][1]);
      List<Integer> result2 = sd.sequentialDigits2(testCases[i][0], testCases[i][1]);
      System.out.printf("Case %d: %s numbers are %s, %s\n", i, Arrays.toString(testCases[i]),
          Arrays.toString(result.toArray()), Arrays.toString(result2.toArray()));
    }
  }
}
