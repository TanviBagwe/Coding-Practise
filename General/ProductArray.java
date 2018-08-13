package practise.uber;

/**
 * 
Good morning!


This is your coding interview problem for today.

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 * @author tbagwe
 *
 */
public class ProductArray {
	
	void productArray(int arr[], int n) 
    {
        int i, temp = 1;
         
        /* Allocate memory for the product array */
        int prod[] = new int[n];
 
        /* Initialize the product array as 1 */
        for(int j=0;j<n;j++)
            prod[j]=1;
 
        /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) 
        {
            prod[i] = temp;
            temp *= arr[i];
        }
 
        /* Initialize temp to 1 for product on right side */
        temp = 1;
 
        /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) 
        {
            prod[i] *= temp;
            temp *= arr[i];
        }
 
        /* print the constructed prod array */
        for (i = 0; i < n; i++)
            System.out.print(prod[i] + " ");
 
        return;
    }
 
    /* Driver program to test above functions */
    public static void main(String[] args) {
        ProductArray pa = new ProductArray();
        int arr[] = {1,2,3,4};
        int n = arr.length;
        System.out.println("The product array is : ");
        pa.productArray(arr, n);
    }

}
