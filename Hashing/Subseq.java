package Hashing;

/*
Given an array arr[] of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Input Format:
The first line of input contains T, number of test cases. First line of line each test case contains a single integer N.
Next line contains N integer array.

Output Format:
Print the output of each test case in a seprate line.

Your Task:
This is a function problem. You only need to complete the function findLongestConseqSubseq that takes arr and n as parameters and retuns the length.

$$


Constraints:
1 <= T <= 100
1 <= N <= 105
0 <= a[i] <= 105

Example:
Input:
2
7
2 6 1 9 4 5 3
7
1 9 3 10 4 20 2

Output:
6
4

Explanation:
Testcase 1:  The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.


 */
public class Subseq {

    // Function to find Longest Consecutive Subsequence
    static int findLongestConseqSubseq(int arr[], int n) {
        // add your code here
        if (n == 1) {
            return 1;
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            if (!map.containsKey(num)) {
                int left = map.get(num - 1) != null ? map.get(num - 1) : 0;
                int right = map.get(num + 1) != null ? map.get(num + 1) : 0;

                int sum = left + right + 1;

                map.put(num, sum);

                res = Math.max(res, sum);

                map.put(num - left, sum);
                map.put(num + right, sum);
            } else {
                //duplicate
                continue;
            }
        }

        return res;
    }

    // Driver Code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            // Making object of GfG
            Subseq g = new Subseq();

            System.out.println(g.findLongestConseqSubseq(a, n));

            t--;
        }
    }

}
