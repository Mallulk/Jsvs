public class Graph {
    int v;
    int graph[][];
    Graph(int v) {
        this.v = v;
        graph = new int[v][v];
    }
    void connectedge(int s, int d) {
        graph[s][d] = 1;
        graph[d][s] = 1;
    }
    void print() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        Graph graph = new Graph(4);
        graph.connectedge(0, 1);
        graph.connectedge(0, 2);
        graph.connectedge(1, 3);
        graph.print();
    }
}