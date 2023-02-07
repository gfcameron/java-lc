class RichestCustomer {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int cust = 0; cust < accounts.length; cust++) {
            int custWealth = 0;
            for (int accBalance : accounts[cust]) {
                custWealth += accBalance;
            }
            maxWealth = Integer.max(custWealth, maxWealth);
        }
        return maxWealth;
    }

    public static void main(String[] args) {

        int[][] testCase0 = {
            {1,2,3},
            {3,2,1}
        };

        int[][] testCase1 = {
            {1,5},
            {7,3},
            {3,5}
        };

        int[][] testCase2 = {
            {2,8,7},
            {7,1,3},
            {1,9,5}
        };

        int[][][] testCases = { 
            testCase0,
            testCase1,
            testCase2
        };

        RichestCustomer rc = new RichestCustomer();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            System.out.println(rc.maximumWealth(testCases[i]));
        }
    }
}