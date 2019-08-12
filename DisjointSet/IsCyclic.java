package DisjointSet;

public class IsCyclic {
    int V, E;

    class Edge {
        int src, dest;

        public Edge() {
            src = dest = 0;
        }
    }

    Edge[] edges;

    public IsCyclic(int v, int e) {
        this.V = v;
        this.E = e;

        edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    public int find(int[] parents, int k) {
        if (parents[k] == -1) {
            return k;
        }

        return find(parents, parents[k]);
    }

    public void union(int[] parents, int u, int v) {
        int uRoot = find(parents, u);
        int vRoot = find(parents, v);

        parents[uRoot] = vRoot;
    }

    public boolean iscyle(IsCyclic g) {

        int[] parents = new int[V];
        for (int k = 0; k < V; k++) {
            parents[k] = -1;
        }

        for (int j = 0; j < E; j++) {
            int eSrc = g.edges[j].src;
            int eDest = g.edges[j].dest;

            int srcRoot = find(parents, eSrc);
            int destRoot = find(parents, eDest);

            if (srcRoot == destRoot) {
                return true;
            }

            g.union(parents, srcRoot, destRoot);
        }
        return false;
    }

    public static void main(String[] args) {

        IsCyclic graph = new IsCyclic(3, 3);

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
