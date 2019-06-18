package String;

/*
Examples:
Input: str = “aaaad”
Output: 1
// “aaaad” is a anagram of a palindrome “aadaa”

Input: str = “abcd”
Output: 0
// “abcd” is not a anagram of any palindrome.
 */
public class AnagramPalidrome {
    public static boolean checkPalindrome(String input) {
        int[] count = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            count[ch - 'a']++;
        }
        int oddOccur = 0;
        for (int cnt : count) {
            if (oddOccur > 1) // more than 1 char should have odd frequency
                return false;
            if (cnt % 2 == 1)
                oddOccur++;
        }
        return true;
    }

}
