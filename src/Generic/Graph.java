package Generic;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Graph<T> {
    HashMap<T, Vertex<T>> graph = new HashMap<>();

    public Vertex<T> addVertex(T data){
        Vertex<T> vertex = new Vertex<>(data);
        graph.put(vertex.getData(), vertex);
        return vertex;
    }

    /**
     * @param isEdgeBidirectional boolean deciding if return from destination to source should be added
     */
    public void addEdge(T sourceVertexData, T destinationVertexData, boolean isEdgeBidirectional, int bidrectionalCost) {
        Vertex<T> sourceVertex = graph.get(sourceVertexData);
        Vertex<T> destinationVertex = graph.get(destinationVertexData);
        if(sourceVertex==null){
            sourceVertex = addVertex(sourceVertexData);
        }
        if (destinationVertex==null){
            destinationVertex = addVertex(destinationVertexData);
        }
        sourceVertex.addEdge(destinationVertex, Math.max(bidrectionalCost, 0));
        if (isEdgeBidirectional){
            destinationVertex.addEdge(sourceVertex, Math.max(bidrectionalCost, 0));
        }
    }

    public Vertex<T> getVertex(T vertexData){
        return graph.get(vertexData);
    }

    public int getVertexCount(){
        return graph.size();
    }

    public boolean graphHasVertex (Vertex<T> vertex){
        return graph.containsValue(vertex);
    }

    public List<Vertex<T>> getVertices(){
        return new ArrayList<>(graph.values());
    }

}
