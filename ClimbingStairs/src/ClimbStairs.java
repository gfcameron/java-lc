package climbsteps;

public class ClimbStairs {

  public  int climbStairs(int n) {
    if (n==1) {
      return 1;
    }
    int a = 1;
    int b = 2;
    int c;
    for (int i=2; i < n; i++) {
      c = a+b;
      a = b;
      b = c;
    }
    return b;
  }

  public static void main(String[] args) {

    int[] testCases = { 1, 2, 3, 4 };

    ClimbStairs cs = new ClimbStairs();
    for ( int i=0; i < testCases.length; i++ ) {
        System.out.printf("Case %d: %d steps %d\n", i, testCases[i], cs.climbStairs(testCases[i]));
    }
  }

}
