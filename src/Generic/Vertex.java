package Generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {
    private final T data;
    private final List<Edge<T>> edges;

    public Vertex(T data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Vertex<T> destination, int weight){
        edges.add(new Edge<>(this, destination, weight));
    }

    public T getData() {
        return data;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return data.equals(vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "" +data+"";
    }
}
