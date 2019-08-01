package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    private int v;
    private LinkedList<Integer> adj[];

    DFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int u) {
        adj[v].add(u);
    }

    void dfsTraverse(int node, boolean[] visited) {
        visited[node] = true;
        System.out.println(node);

        Iterator<Integer> list = adj[node].listIterator();
        while (list.hasNext()) {
            int n = list.next();

            if (!visited[n]) {
                visited[n] = true;
                dfsTraverse(n, visited);
            }
        }
    }

    void DFSUtil(int node) {
        boolean visited[] = new boolean[v];
        dfsTraverse(node, visited);
    }

    public static void main(String[] args) {


        DFS g = new DFS(4);


        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);


        g.DFSUtil(1);
    }
}
