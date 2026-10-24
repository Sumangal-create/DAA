
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class Kruskals {

    static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent, parent[x]);
    }

    static boolean union(int[] parent, int u, int v) {
        int rootU = find(parent, u);
        int rootV = find(parent, v);

        if (rootU == rootV) {
            return false;
        }

        parent[rootU] = rootV;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];

        System.out.println("Enter source, destination and weight:");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        // Sort edges by weight
        Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));

        // Initially, each vertex is in its own set
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalCost = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        for (int i = 0; i < m && count < n - 1; i++) {
            Edge e = edges[i];

            if (union(parent, e.u, e.v)) {
                System.out.println(
                    e.u + " - " + e.v + " : " + e.weight
                );

                totalCost += e.weight;
                count++;
            }
        }

        if (count != n - 1) {
            System.out.println("MST does not exist.");
        } else {
            System.out.println("Total MST cost: " + totalCost);
        }

        sc.close();
    }
}
