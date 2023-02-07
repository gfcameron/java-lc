
class NumberOfSteps {

    public int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            steps++;
            if (num%2 == 0) {
                num /= 2;
            } else {
                num--;
            }
        }
        return steps;
    }


    public static void main(String[] args) {

        int[] testCases = { 14, 8, 123 };

        NumberOfSteps numSteps = new NumberOfSteps();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %d\n", i, numSteps.numberOfSteps(testCases[i]));
        }
    }
}