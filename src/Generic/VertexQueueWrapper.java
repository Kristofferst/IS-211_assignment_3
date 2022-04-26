package Generic;

public class VertexQueueWrapper<T> implements Comparable<VertexQueueWrapper<T>> {


    private final Vertex<T> vertex;
    private final int priority;

    public VertexQueueWrapper(Vertex<T> vertex, int p){
        this.vertex = vertex;
        this.priority = p;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    @Override
    public int compareTo(VertexQueueWrapper o) {
        return Integer.compare(this.priority, o.priority);
    }
}
