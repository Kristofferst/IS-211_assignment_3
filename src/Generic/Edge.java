package Generic;

public class Edge<T> {
    private final Vertex<T> start;
    private final Vertex<T> end;
    private boolean isWeighted;
    private final int weight;

    public Edge(Vertex<T> start, Vertex<T> end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        if(weight>0){
            this.isWeighted=true;
        }
    }

    public Vertex<T> getStart() {
        return start;
    }

    public Vertex<T> getEnd() {
        return end;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public int getWeight() {
        return weight;
    }
}
