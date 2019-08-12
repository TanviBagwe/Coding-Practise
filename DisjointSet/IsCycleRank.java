package DisjointSet;

public class IsCycleRank {

    int V, E;

    class Edge {
        int src, dest;

        public Edge() {
            src = dest = 0;
        }
    }

    Edge edges[];

    public IsCycleRank(int v, int e) {
        this.V = v;
        this.E = e;

        edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    class Subset {
        int parent;
        int rank;
    }


    public int find(Subset[] subsets, int u) {
        if (subsets[u].parent != u) {
            subsets[u].parent = find(subsets, subsets[u].parent);
        }
        return subsets[u].parent;
    }


    public void union(Subset[] subsets, int u, int v) {

        int uRoot = find(subsets, u);
        int vRoot = find(subsets, v);

        if (subsets[uRoot].rank < subsets[vRoot].rank) {
            subsets[uRoot].parent = vRoot;
        } else if (subsets[vRoot].rank < subsets[uRoot].rank) {
            subsets[vRoot].parent = uRoot;
        } else {
            subsets[vRoot].parent = uRoot;
            subsets[uRoot].rank++;
        }
    }


    public boolean iscyle(IsCycleRank g) {

        int nodes = g.V;
        int lines = g.E;

        Subset[] subsets = new Subset[nodes];
        for (int v = 0; v < nodes; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        for (int j = 0; j < lines; j++) {

            int xRoot = find(subsets, g.edges[j].src);
            int yRoot = find(subsets, g.edges[j].dest);

            if (xRoot == yRoot) {
                return true;
            }

            union(subsets, xRoot, yRoot);
        }
        return false;
    }

    public static void main(String[] args) {

        IsCycleRank graph = new IsCycleRank(3, 3);

        /*edge 0 -1*/
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        /*edge 1 -2*/
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;

        /*edge 0 -2*/
        graph.edges[2].src = 2;
        graph.edges[2].dest = 0;

        if (graph.iscyle(graph)) {
            System.out.println("graph is cyclic");
        } else {
            System.out.println("graph is not cyclic");
        }

    }
}
