package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int v, int u) {

        adj.get(v).add(u);

    }

    static void BFSUtil(ArrayList<ArrayList<Integer>> adj, int v) {

        boolean visited[] = new boolean[v + 1];

        //first mark all visited as false
        for (int i = 1; i <= v; i++) {
            visited[i] = false;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        //now traverse trough graph
        int s = 1;
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int top = queue.pop();

            System.out.println(" out -->" + top);

            ArrayList<Integer> listWithNode = adj.get(top);
            if (null != listWithNode && !listWithNode.isEmpty()) {
                // check if it is visited or not
                for (int j = 0; j < listWithNode.size(); j++) {
                    int newNode = listWithNode.get(j);
                    if (!visited[newNode]) {
                        visited[listWithNode.get(j)] = true;
                        queue.add(listWithNode.get(j));
                    }
                }

            }
        }

    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int v = 6;
        for (int i = 0; i < v + 1; i++) {
            adj.add(new ArrayList<Integer>());
        }

        //adding edge one by one
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 6);

        BFSUtil(adj, v);
    }
}
