import java.util.*;

public abstract class Search<V> {
    protected final Map<V, V> edgeTo = new HashMap<>();
    protected final V start;

    public Search(V start) {
        this.start = start;
    }

    public boolean hasPathTo(V v) {
        return edgeTo.containsKey(v) || v.equals(start);
    }

    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != null && !x.equals(start); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}