package General.TopCompaniesQuestions;

import java.util.Arrays;

/*
Uber
Write a program that determines the smallest number of perfect squares that sum up to N.

Here are a few examples:

Given N = 4, return 1 (4)
Given N = 17, return 2 (16 + 1)
Given N = 18, return 2 (9 + 9)
Create a storage array whose final value will be returned

        Fill the array with Integer.MAX_VALUE to get a minimum value by comparision
        Base Cases : ret[0] = 0 and ret[1] = 1
        For each i, compute min(ret[i - j * j] + 1, ret[i]) where j ranges from 1 to j * j <= i
*/
public class PerfectSquare {

    public int numSquares(int n) {
        int[] ret = new int[n + 1];
        Arrays.fill(ret, Integer.MAX_VALUE);
        ret[0] = 0;
        ret[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                ret[i] = Math.min(ret[i - j * j] + 1, ret[i]);
            }
        }
        return ret[n];
    }

    public static void main(String args[]) {
        int number = 20;
        PerfectSquare p = new PerfectSquare();
        int output = p.numSquares(number);
        System.out.println(" number is " + output);
    }
}
