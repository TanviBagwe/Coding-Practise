package Graph;

/**
 * Description - Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 * Example:
 * Input : mat[][] = {{1, 1, 0, 0, 0},
 * {0, 1, 0, 0, 1},
 * {1, 0, 0, 1, 1},
 * {0, 0, 0, 0, 0},
 * {1, 0, 1, 0, 1}
 * Output : 5
 * Solution - The problem can be easily solved by applying DFS() on each component. In each DFS() call, a component or a sub-graph is visited. We will call DFS on the next un-visited component. The number of calls to DFS() gives the number of connected components. BFS can also be used.
 * <p>
 * What is an island ? A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 * <p>
 * {1,  1, 0, 0, 0},
 * {0, 1, 0, 0, 1},
 * {1, 0, 0, 1, 1},
 * {0, 0, 0, 0, 0},
 * {1, 0, 1, 0, 1}
 */
public class Island {

    static final int ROW = 5;
    static final int COL = 5;

    private static boolean isSafe(int[][] m, int row, int col, boolean[][] visited) {
        return ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && m[row][col] == 1 && !visited[row][col]);
    }

    private static void DFSUtil(int[][] m, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        //all nodes to check adjacent 8 neighbors for connectivity
        int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            if (isSafe(m, row + rowNbr[k], col + colNbr[k], visited)) {
                DFSUtil(m, row + rowNbr[k], col + colNbr[k], visited);
            }
        }

    }

    public int countIslands(int[][] M) {
        boolean[][] visited = new boolean[ROW][COL];
        int count = 0;

        //go through  all row and col to see visited 1 is there or no
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFSUtil(M, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0}};

        Island island = new Island();
        System.out.println("No of Islands are " + island.countIslands(M));


    }
}
