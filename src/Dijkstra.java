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
        int distance = distances.get(destinationVertex.getData());

        ArrayList<Vertex<T>> path = new ArrayList<>();
        Vertex<T> current = destinationVertex;
        while (current.getData()!=null){
            path.add(0, current);
            current = previous.get(current.getData());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(Vertex<T> vertex: path){
            stringBuilder.append(vertex.getData()).append(" ");
        }

        System.out.println("Shortest Path between " + startingVertex.getData() + " and " + destinationVertex.getData());
        System.out.println("Path: " + "[ " + stringBuilder + "] " + "Distance: " + distance);

    }

    public void ResultPrinter(){
        System.out.println("Distances:");
        for (Enumeration<T> keys = Collections.enumeration(distances.keySet()); keys.hasMoreElements();){
            T nextKey = keys.nextElement();
            System.out.println(nextKey + ": " + distances.get(nextKey));
        }
        /* Shows the previous visited vertex in the shortest path to all other vertices */
        System.out.println("\nPrevious:");
        for (Enumeration<T> keys = Collections.enumeration(previous.keySet()); keys.hasMoreElements();) {
            T nextKey = keys.nextElement();
            Vertex<T> nextVertex = previous.get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
        System.out.println(" ");

    }
}