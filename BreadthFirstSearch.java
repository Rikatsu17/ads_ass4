import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(UnweightedGraph<V> graph, V start) {
        super(start);
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            V u = queue.poll();
            Vertex<V> uVertex = graph.getVertex(u);
            for (Vertex<V> vVertex : uVertex.getAdjacentVertices().keySet()) {
                V v = vVertex.getData();
                if (!visited.contains(v)) {
                    edgeTo.put(v, u);
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
    }
}