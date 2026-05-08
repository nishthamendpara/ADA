import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class Kruskal {
    int V = 4, E = 5;
    Edge edge[] = new Edge[E];

    Kruskal() {
        for (int i = 0; i < E; ++i)
            edge[i] = new Edge();
    }

    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalMST() {
        Edge result[] = new Edge[V];

        for (int i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        int e = 0, i = 0;

        while (e < V - 1) {
            Edge next = edge[i++];

            int x = find(parent, next.src);
            int y = find(parent, next.dest);

            if (x != y) {
                result[e++] = next;
                union(parent, x, y);
            }
        }

        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
    }

    public static void main(String[] args) {
        Kruskal graph = new Kruskal();

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();
    }
}
