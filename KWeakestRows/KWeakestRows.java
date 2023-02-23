
import java.util.*;

class KWeakestRows {
/*
    You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
    The soldiers are positioned in front of the civilians.
    That is, all the 1's will appear to the left of all the 0's in each row.
    A row i is weaker than a row j if one of the following is true:
    
        The number of soldiers in row i is less than the number of soldiers in row j.
        Both rows have the same number of soldiers and i < j.
    
    Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
*/

    public int[] kWeakestRows(int[][] mat, int k) {

        class Tuple implements Comparable<Tuple>{
            int row;
            int col;
        
            Tuple(int row, int col) {
                this.row = row;
                this.col = col;
            }

            // compareTo sorts by columns
            @Override
            public int compareTo(Tuple tuple) {
                return this.col - tuple.col;
            }
        }

        // Error handling
        if (k > mat.length) {
            return null;
        }

        int[] result = new int[k];
        List<Tuple> rowStrength = new ArrayList<Tuple>();
        int rowLength = mat.length;
        int colLength = mat[0].length;
        for ( int row = 0; row < rowLength; row++ ) {
            int col = 0;
            while (col < colLength) {
                if (mat[row][col] == 0) {
                    break;
                }
                col++;
            }
            // The columns are the key we sort on
            Tuple rowCol = new Tuple(row, col);
            rowStrength.add(rowCol);
        }
        Collections.sort(rowStrength);
        Iterator<Tuple> it = rowStrength.iterator();

        for (int i=0; i < k; i++) {
            result[i] = it.next().row;
        }
        return result;
    }

    public static void main(String[] args) {

        class TestCase {
            int[][] matrix;
            int k;

            TestCase(int[][] matrix, int k) {
                this.matrix = matrix;
                this.k = k;
            }
        };

        int[][] matrix0 = {
            {1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}
        };
        TestCase testCase0 = new TestCase( matrix0, 3);

        int[][] matrix1 = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };
        TestCase testCase1 = new TestCase( matrix1, 2);

        TestCase[] testCases = {
            testCase0,
            testCase1
        };

        KWeakestRows kw = new KWeakestRows();

        for ( int i=0; i < testCases.length; i++ ) {
            TestCase tc = testCases[i];
            System.out.printf("Case %d:", i);
            int[] weakest = kw.kWeakestRows(tc.matrix, tc.k);
            System.out.println(Arrays.toString(weakest));
        }
    }

}