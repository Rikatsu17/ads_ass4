import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(UnweightedGraph<V> graph, V start) {
        super(start);
        Set<V> visited = new HashSet<>();
        dfs(graph, start, visited);
    }

    private void dfs(UnweightedGraph<V> graph, V u, Set<V> visited) {
        visited.add(u);
        Vertex<V> uVertex = graph.getVertex(u);
        for (Vertex<V> vVertex : uVertex.getAdjacentVertices().keySet()) {
            V v = vVertex.getData();
            if (!visited.contains(v)) {
                edgeTo.put(v, u);
                dfs(graph, v, visited);
            }
        }
    }
}