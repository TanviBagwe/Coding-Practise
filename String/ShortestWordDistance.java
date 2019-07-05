package String;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.
 * <p>
 * Note
 * <p>
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * <p>
 * Analysis
 * <p>
 * We can scan the list and use two pointers to record the most recent indexes of the two words. Then we update the distance and the global minimum distance.
 */
public class ShortestWordDistance {


    public static int getShortestDistance(String[] words, String word1, String word2) {
        if (null == words || words.length == 0) {
            return -1;
        }
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(word1)) {
                p1 = i;
            }

            if (words[i].equalsIgnoreCase(word2)) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "makes";

        System.out.println("Shortest distance is :" + ShortestWordDistance.getShortestDistance(words, word1, word2));
    }
}
