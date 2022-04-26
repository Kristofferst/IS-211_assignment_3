import Generic.Edge;
import Generic.Graph;
import Generic.Vertex;
import Generic.VertexQueueWrapper;

import java.util.*;

public class Dijkstra<T> {
    Vertex<T> startingVertex;
    Vertex<T> destinationVertex;

    Map<T, Integer> distances;
    Map<T, Vertex<T>> previous;
    PriorityQueue<VertexQueueWrapper<T>> queue;

    public Dijkstra(Graph<T> graph, Vertex<T> startingVertex){
        this.distances = new Hashtable<>();
        this.previous = new Hashtable<>();
        this.queue = new PriorityQueue<>();
        this.startingVertex = startingVertex;

        distances.put(startingVertex.getData(), 0);
        queue.add(new VertexQueueWrapper<>(startingVertex, 0));

        for (Vertex<T> vertex: graph.getVertices()) {
            if(vertex != startingVertex){
                distances.put(vertex.getData(), Integer.MAX_VALUE);
            }
            previous.put(vertex.getData(), new Vertex<>(null));
        }

        while(!queue.isEmpty()){
            Vertex<T> current = queue.poll().getVertex();
            for (Edge<T> e: current.getEdges()) {
                Integer alternate = distances.get(current.getData()) + e.getWeight();
                T neighborValue = e.getEnd().getData();
                if (alternate < distances.get(neighborValue)){
                    distances.put(neighborValue, alternate);
                    previous.put(neighborValue, current);
                    queue.add(new VertexQueueWrapper<>(e.getEnd(), distances.get(neighborValue)));
                }
            }
        }
    }

    public void ShortestPath(Vertex<T> destinationVertex){
        this.destinationVertex = destinationVertex;
        ArrayList<Vertex<T>> path = new ArrayList<>();
        Vertex<T> current = destinationVertex;
        while (current.getData()!=null){
            path.add(0, current);
            current = previous.get(current.getData());
        }
        System.out.println(path);
    }
}