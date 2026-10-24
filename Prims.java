
import java.util.Scanner;

public class Prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];

        System.out.println("Enter adjacency matrix (0 = no edge):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        visited[0] = true;
        int edges = 0;
        int totalCost = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        while (edges < n - 1) {
            int min = Integer.MAX_VALUE;
            int u = -1, v = -1;

            // Find minimum edge from visited to unvisited
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && graph[i][j] != 0
                                && graph[i][j] < min) {
                            min = graph[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }

            // Graph is disconnected
            if (u == -1) {
                System.out.println("MST does not exist.");
                sc.close();
                return;
            }

            System.out.println(u + " - " + v + " : " + min);

            visited[v] = true;
            totalCost += min;
            edges++;
        }

        System.out.println("Total MST cost: " + totalCost);
        sc.close();
    }
}
