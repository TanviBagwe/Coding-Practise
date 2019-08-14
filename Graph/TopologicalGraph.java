package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalGraph {

    private int V;
    private LinkedList<Integer> adj[];


    public TopologicalGraph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void topologicalSortUtil(int v, boolean[] visited, Stack stack) {

        //mark current node as visited
        visited[v] = true;

        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            int node = it.next();
            if (!visited[node]) {
                topologicalSortUtil(node, visited, stack);
            }
        }

        stack.push(new Integer(v));
    }

    public void topologicalSort() {
        boolean[] visited = new boolean[V];

        for (int j = 0; j < V; j++) {
            visited[j] = false;
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(" elelment " + stack.pop());
        }


    }

    public static void main(String args[]) {
        TopologicalGraph g = new TopologicalGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();

    }
}
