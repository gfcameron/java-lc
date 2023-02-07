
import java.util.*;

class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <=n; i++) {
            String entry = "";
            if (i%3 == 0) {
                entry = "Fizz";
            }
            if (i%5 == 0) {
                entry = entry + "Buzz";
            }
            if (entry.length() == 0) {
                entry = String.valueOf(i);
            }
            result.add(entry);
        }
        return result;
    }


    public static void main(String[] args) {

        int[] testCases = { 3, 5, 15 };

        FizzBuzz fb = new FizzBuzz();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            System.out.println(fb.fizzBuzz(testCases[i]));
        }
    }

}