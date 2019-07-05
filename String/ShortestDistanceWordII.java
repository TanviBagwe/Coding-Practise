package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Shortest Word Distance II
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = “makes”, word2 = “coding”, return 1.

Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Analysis

We can pre scan the list to record the indexes for each word, and store the sorted index list into a HashTable. The key is the word, and the value is the sorted index list.  In the query process, the problem becomes to find the minimum difference between the values in the two sorted index lists.

For example,  the indexes for word1 might be  {1, 5, 9}, and the indexes for word2 might be {4, 11, 15}, then we can easily use the idea of merging sorted lists to get the minimum.*/
public class ShortestDistanceWordII {

    public static int getDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String x = words[i];
            if (map.containsKey(words)) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }

        List<Integer> index1es = map.get(word1);
        List<Integer> index2es = map.get(word2);
        int p1 = 0;
        int p2 = 0;
        while (p1 < index1es.size() && p2 < index2es.size()) {
            int i1 = index1es.get(p1);
            int i2 = index2es.get(p2);
            min = Math.min(min, Math.abs(i1 - i2));
            if (i1 < i2) {
                p1++;
            } else {
                p2++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";

        System.out.println("Shortest distance is :" + ShortestDistanceWordII.getDistance(words, word1, word2));
    }
}
