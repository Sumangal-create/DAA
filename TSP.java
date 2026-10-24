
import java.util.Scanner;

public class TSP {
    static int n;
    static int[][] graph;
    static int[][] mst;
    static boolean[] visited;
    static int[] tour;
    static int index = 0;

    // Prim's algorithm to construct MST
    static void primMST() {
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] inMST = new boolean[n];

        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        key[0] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;

            for (int v = 0; v < n; v++) {
                if (!inMST[v] &&
                    (u == -1 || key[v] < key[u])) {
                    u = v;
                }
            }

            inMST[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 &&
                    !inMST[v] &&
                    graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        mst = new int[n][n];

        for (int v = 1; v < n; v++) {
            int p = parent[v];
            mst[p][v] = 1;
            mst[v][p] = 1;
        }
    }

    // Preorder DFS traversal of MST
    static void preorder(int u) {
        visited[u] = true;
        tour[index++] = u;

        for (int v = 0; v < n; v++) {
            if (mst[u][v] == 1 && !visited[v]) {
                preorder(v);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        graph = new int[n][n];
        visited = new boolean[n];
        tour = new int[n + 1];

        System.out.println("Enter distance matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        primMST();
        preorder(0);

        // Return to starting city
        tour[index++] = 0;

        int cost = 0;

        System.out.println("Approximate TSP Tour:");

        for (int i = 0; i < index; i++) {
            System.out.print(tour[i]);

            if (i < index - 1) {
                System.out.print(" -> ");
            }
        }

        for (int i = 0; i < index - 1; i++) {
            cost += graph[tour[i]][tour[i + 1]];
        }

        System.out.println("\nApproximate tour cost: " + cost);

        sc.close();
    }
}
