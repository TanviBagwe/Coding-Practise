package General;

import java.util.HashMap;

/**
 * Problem: TWITTER
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers “69”, “88”, and “818” are all strobogrammatic.
 * <p>
 * <p>
 * Thoughts:
 * This is actually almost the same problem as 125 LeetCode Java: Valid Palindrome – Easy. But now the condition is not to check if two char in the front and back are the same but to check if they meet the requirement on mapping.
 * 1->1, 8->8, 0->0, 6->9 and 9->6 is the mapping.
 */

public class StroboGramaticNumber {

    /**
     * @param num
     * @return
     */


    public static boolean isStroboGrammatic(int num) {
        HashMap<Character, Character> idealNos = new HashMap<Character, Character>();
        idealNos.put('1', '1');
        idealNos.put('0', '0');
        idealNos.put('8', '8');
        idealNos.put('6', '9');
        idealNos.put('9', '6');

        if (num == 0) {
            return true;
        }

        String numString = String.valueOf(num);

        int left = 0;
        int right = numString.length() - 1;

        while (left <= right) {
            if (!idealNos.containsKey(numString.charAt(left)) || (!idealNos.get(numString.charAt(left)).equals(numString.charAt(right)))) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

    public static void main(String args[]) {

        int num = 1981;
        if (isStroboGrammatic(num)) {
            System.out.println("Num is strobo grammatic num");
        } else {
            System.out.println("Num is not strobo grammatic num");
        }
    }
}
