package Array.Amazon;

/*
Trapping Rain Water
Difficulty: Medium

Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.

https://practice.geeksforgeeks.org/problems/trapping-rain-water/1/?track=SPC-Arrays&batchId=140
 */
public class TrappingWater {

    /*This is a function problem.You only need to complete the function given below*/


    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) {

        // Your code here
        if (arr.length < 3) {
            return 0;
        }

        int[] maxRight = new int[arr.length];
        int[] maxLeft = new int[arr.length];

        maxRight[arr.length - 2] = arr[arr.length - 1];
        maxLeft[1] = arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] > maxLeft[i - 1]) {
                maxLeft[i] = arr[i - 1];
            } else {
                maxLeft[i] = maxLeft[i - 1];
            }

            if (arr[arr.length - i] > maxRight[arr.length - i]) {
                maxRight[arr.length - i - 1] = arr[arr.length - i];
            } else {
                maxRight[arr.length - i - 1] = maxRight[arr.length - i];
            }
        }

        int waterArea = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < maxLeft[i] && arr[i] < maxRight[i]) {
                waterArea += Math.min(maxLeft[i], maxRight[i]) - arr[i];
            }
        }

        return waterArea;
    } // Your code here


}


