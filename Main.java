public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> titanWeightedGraph = new WeightedGraph<>(true);
        fillTitanWeights(titanWeightedGraph);

        System.out.println("Dijkstra (Path of Destruction):");
        Search<String> titanDijkstra = new DijkstraSearch<>(titanWeightedGraph, "Eren");
        outputPath(titanDijkstra, "Armin");

        System.out.println("--------------------------------");

        UnweightedGraph<String> titanUnweightedGraph = new UnweightedGraph<>(true);
        fillTitanFriendships(titanUnweightedGraph);

        System.out.println("DFS (Friendship Connections):");
        Search<String> titanDFS = new DepthFirstSearch<>(titanUnweightedGraph, "Eren");
        outputPath(titanDFS, "Levi");

        System.out.println("--------------------------------");

        System.out.println("BFS (Friendship Connections):");
        Search<String> titanBFS = new BreadthFirstSearch<>(titanUnweightedGraph, "Eren");
        outputPath(titanBFS, "Hange");
    }

    public static void fillTitanFriendships(UnweightedGraph<String> graph) {
        graph.addEdge("Eren", "Mikasa");
        graph.addEdge("Eren", "Armin");
        graph.addEdge("Mikasa", "Levi");
        graph.addEdge("Levi", "Hange");
        graph.addEdge("Armin", "Hange");
        graph.addEdge("Hange", "Erwin");
        graph.addEdge("Levi", "Erwin");
    }

    public static void fillTitanWeights(WeightedGraph<String> graph) {
        graph.addEdge("Eren", "Mikasa", 1.0);
        graph.addEdge("Eren", "Armin", 1.2);
        graph.addEdge("Mikasa", "Levi", 2.0);
        graph.addEdge("Levi", "Hange", 1.5);
        graph.addEdge("Armin", "Hange", 2.5);
        graph.addEdge("Hange", "Erwin", 3.0);
        graph.addEdge("Levi", "Erwin", 0.8);
    }

    public static void outputPath(Search<String> search, String key) {
        System.out.println("Path to " + key + ":");
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println("[END]");
    }
}