package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int v, int u) {
        adj.get(v).add(u);
    }

    public static void BFSUtil(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v + 1];
        int s = 1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        for (int i = 1; i < visited.length; i++) {
            visited[i] = false;
        }
        while (!queue.isEmpty()) {
            int top = queue.pop();
            System.out.println(" elements" + top);
            ArrayList<Integer> list = adj.get(top);
            for (int j = 0; j < list.size(); j++) {
                int newNode = list.get(j);
                if (!visited[newNode]) {
                    visited[newNode] = true;
                    queue.add(newNode);
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
