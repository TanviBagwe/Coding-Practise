package General;

/**
 * This problem was asked by Squarespace.
 * <p>
 * Write a function, add_subtract, which alternately adds and subtracts curried arguments. Here are some sample operations:
 */

public class AlternateAddSubtrack {

    public int alterAddSubtract(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int ans = 0;

        for (int no = 0; no < nums.length; no++) {
            if (no == 0) {
                ans = nums[no];
            } else if (no % 2 == 1) {
                ans = ans + nums[no];
            } else {
                ans = ans - nums[no];
            }


        }

        return ans;
    }


    public static void main(String[] args) {
        int[] numbers = {-5, 10, 3, 9};
        AlternateAddSubtrack a = new AlternateAddSubtrack();
        System.out.println("output is " + a.alterAddSubtract(numbers));
    }
}
