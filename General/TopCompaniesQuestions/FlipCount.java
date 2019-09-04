package General.TopCompaniesQuestions;

/**
 * You are given a string consisting of the letters x and y, such as xyxxxyxyy. In addition, you have an operation called flip, which changes a single x to y or vice versa.
 * <p>
 * Determine how many times you would need to apply this operation to ensure that all x’s come before all y’s. In the preceding example, it suffices to flip the second and sixth characters, so you should return 2.
 * Linked In
 */
public class FlipCount {

    public int flipCountReturn(String inputString) {
        if (null == inputString) {
            return 0;
        }

        int flipC = 0;
        int yCount = 0;
        int xCount = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'x') {
                if (yCount > 0) {
                    flipC = flipC + 1;
                } else {
                    continue;
                }
            } else {
                if ((i < inputString.length() - 2 && inputString.charAt(i + 1) != 'y') || (i > 0 && inputString.charAt(i - 1) != 'y')) {
                    yCount = yCount + 1;
                }
            }
        }

        if (flipC > yCount && yCount != 0) {
            flipC = yCount;
        }
        return flipC;
    }

    public static void main(String args[]) {
        String inputString = "xxyxxxyyyxyy";
        FlipCount f = new FlipCount();
        System.out.println("No of flips will be " + f.flipCountReturn(inputString));
    }
}
