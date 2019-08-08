package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    private int V;
    private LinkedList<Integer> adj[];


    DFS(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int j = 0; j < v; j++) {
            adj[j] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void dfsTraversal(int node, boolean[] visited) {
        visited[node] = true;
        System.out.println("node " + node);
        Iterator<Integer> it = adj[node].listIterator();
        while (it.hasNext()) {
            int newNode = it.next();
            if (!visited[newNode]) {
                visited[newNode] = true;
                dfsTraversal(newNode, visited);
            }
        }
    }

    public void DFSUtil(int node) {
        boolean[] visited = new boolean[V];
        dfsTraversal(node, visited);

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
