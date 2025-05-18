import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<V, Double> distTo = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(start);
        PriorityQueue<V> pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));

        for (V v : graph.getAllVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            V u = pq.poll();
            Vertex<V> uVertex = graph.getVertex(u);
            for (Map.Entry<Vertex<V>, Double> entry : uVertex.getAdjacentVertices().entrySet()) {
                V v = entry.getKey().getData();
                double weight = entry.getValue();
                double newDist = distTo.get(u) + weight;

                if (newDist < distTo.get(v)) {
                    distTo.put(v, newDist);
                    edgeTo.put(v, u);
                    pq.remove(v);
                    pq.add(v);
                }
            }
        }
    }
}