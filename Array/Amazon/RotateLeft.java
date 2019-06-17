package Array.Amazon;

/*Given an unsorted array arr[] of size N, rotate it by D elements (counter-clockwise).
        Input:
        The first line of the input contains T denoting the number of testcases. First line of eacg test case contains two space separated elements, N denoting the size of the array and an integer D denoting the number size of the rotation. Subsequent line will be the N space separated array elements.
        Output:
        For each testcase, in a new line, output the rotated array.
        User Task:
        The task is to complete the function rotate() which rotates the array by given D elements. The newline isautomatically added by the driver code.
        Constraints:
        1 <= T <= 200
        1 <= N <= 107
        1 <= D <= N
        0 <= arr[i] <= 105
        Example:
        Input:
        2
        5 2
        1 2 3 4 5
        10 3
        2 4 6 8 10 12 14 16 18 20
        Output:
        3 4 5 1 2
        8 10 12 14 16 18 20 2 4 6
        Explanation :
        Testcase 1: 1 2 3 4 5  when rotated by 2 elements, it becomes 3 4 5 1 2.

        Hint :- Reversal of array concept might be useful here




        */
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RotateLeft {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            String[] starr = str.split(" ");
            int n = Integer.parseInt(starr[0]);
            int d = Integer.parseInt(starr[1]);
            int[] arr = new int[n];
            String str1 = br.readLine();
            String[] starr1 = str1.split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(starr1[j]);
            }
            new RotateArray().rotateArr(arr, d, n);
            StringBuffer sb = new StringBuffer();
            for (int t1 = 0; t1 < n; t1++)
                sb.append(arr[t1] + " ");
            System.out.println(sb);
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class RotateArray {
    static void rotateArr(int arr[], int d, int n) {
        // add your code here
        if (arr.length < 2 || arr == null) {
            return;
        }

        d = (d % n);
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

    }

    public static void reverse(int arr[], int i, int j) {
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
