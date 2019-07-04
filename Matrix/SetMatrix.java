/*package whatever //do not write package name here */
package Matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class SetMatrix {
    public static void setMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //iterate through matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    //set entire row to one
                    j = 0;
                    while (j < n) {
                        matrix[i][j] = 1;
                        j++;
                    }
                }
            }
        }
        printMatrix(matrix);
    }


    public static void printMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //code
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
            while (t-- > 0) {
                int m = Integer.parseInt(br.readLine().trim());// row
                int n = Integer.parseInt(br.readLine().trim());//col
                int[][] matrix = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(br.readLine().trim());
                    }
                }
                setMatrix(matrix);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}