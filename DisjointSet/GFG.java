package DisjointSet;

/*package whatever //do not write package name here */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * In the social media network facebook, people look forward to connect to each other. 2 people mutually decides to connect. In this problem you will be given 2 type of tasks, letsbefriends and arewefriends. In the letsbefriends query, you will be given 2 person and they will be added to each other circle. In the arewefriends query, you will be given 2 person and you have to tell whether they are connected directly/indirectly or they are independent. 2 people are considered friends if they are directly or indirectly connected.
 * <p>
 * <p>
 * Input: First line of input contains number of testcases T. For each testcase, next line contains an input N, which will represent the maximum number of people involved in the facebook hub. The third line will have name of N people space separated. The fourth line will have number of queries q and then there will be q queries each starting with letsbefriends or arewefriends and two person names person1 and person2.
 * <p>
 * Output: For each arewefriends operation code will return 1(true : If they are directly or indirectly connected) or 0(false : If they are not connected).
 * <p>
 * Note: Initally everybody in facebook hub is not connected. Person name will be in lowercase latin letters with no spaces.
 * <p>
 * Constraints:
 * 1 <= T <= 10
 * 1 <= N <= 5*105
 * 1<= Q <= 5*105
 * Total number of persons are equal to N.
 * <p>
 * Example:
 * Input:
 * 1
 * 5
 * akshit ankit akash mayank siddhant
 * 5
 * letsbefriends mayank ankit
 * arewefriends mayank siddhant
 * letsbefriends mayank akash
 * arewefriends ankit akash
 * arewefriends akash akshit
 * <p>
 * Output:
 * 0
 * 1
 * 0
 * <p>
 * Explanation:
 * There are a total of 5 people in the facebook hub namely, akshit ankit akash mayank siddhant.
 * For the first query,  letsbefriends mayank ankit, mayank and ankit become friends.
 * For the second query, arewefriends mayank siddhant , mayank and siddhant are not friends so return 0.
 * For the third query, letsbefriends mayank akash , mayank and akash become friends.
 * For the fourth query, arewefriends ankit akash, ankit and akash are connected through mayank so return 1.
 * For the fifth query, arewefriends akash akshit, akash and akshit are not friends so return 0.
 */
class GFG {
    Map<String, Integer> rank;
    Map<String, String> parent;
    int n;

    // Constructor
    public GFG(String[] ppl, int n) {
        rank = new HashMap<String, Integer>();
        parent = new HashMap<String, String>();
        this.n = n;
        makeSet(ppl);
    }

    // Creates n sets with single item in each
    void makeSet(String[] ppl) {
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in
            // their own set.
            rank.put(ppl[i], 0);
            parent.put(ppl[i], ppl[i]);
        }
    }

    // Returns representative of x's set
    String find(String x) {
        // Finds the representative of the set
        // that x is an element of


        if (null != parent.get(x) && !(parent.get(x).equalsIgnoreCase(x))) {
            // if x is not the parent of itself
            // Then x is not the representative of
            // his set,
            parent.put(x, find(parent.get(x)));

            // so we recursively call Find on its parent
            // and move i's node directly under the
            // representative of this set
        }

        return parent.get(x);
    }

    // Unites the set that includes x and the set
    // that includes x
    void union(String x, String y) {
        // Find representatives of two sets
        String xRoot = find(x), yRoot = find(y);

        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot.equalsIgnoreCase(yRoot))
            return;

        // If x's rank is less than y's rank
        if (rank.get(xRoot) < rank.get(yRoot))

            // Then move x under y  so that depth
            // of tree remains less
            parent.put(xRoot, yRoot);

            // Else if y's rank is less than x's rank
        else if (rank.get(yRoot) < rank.get(xRoot))

            // Then move y under x so that depth of
            // tree remains less
            parent.put(yRoot, xRoot);

        else // if ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            parent.put(yRoot, xRoot);

            // And increment the the result tree's
            // rank by 1
            rank.put(xRoot, rank.get(xRoot) + 1);
        }
    }


    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// no of test case
        for (int i = 0; i < n; i++) {
            //now get no of people
            int noOfPpl = sc.nextInt();
            String[] ppl = new String[noOfPpl];
            sc.nextLine();
            String allPpl = sc.nextLine();
            ppl = allPpl.split(" ");


            GFG gfg = new GFG(ppl, noOfPpl);
            //now get no of queries
            int queries = sc.nextInt();
            String[] quList = new String[queries];
            for (int l = 0; l < queries; l++) {
                sc.nextLine();
                quList[l] = sc.nextLine();
            }
            for (int k = 0; k < queries; k++) {

                String[] querywords = quList[k].split(" ");
                if (querywords[0].equalsIgnoreCase("letsbefriends")) {
                    //call union

                    gfg.union(querywords[1], querywords[2]);

                } else {

                    //call find and print
                    String rootX = gfg.find(querywords[1]);
                    String rootY = gfg.find(querywords[2]);
                    if (rootX.equalsIgnoreCase(rootY)) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }

                }
            }
        }

    }
}
