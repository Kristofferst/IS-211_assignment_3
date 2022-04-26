import Generic.Graph;
import Generic.Vertex;

public class Main {

    public static void main(String[] args) {
        networkManagementProblemA();

    }

    private static void networkManagementProblemA(){
        /*
        A. Network management
         */

        Graph<String> network = new Graph<>();
        // From A
        network.addEdge("A", "B", true, 10);
        network.addEdge("A", "C", true, 5);
        network.addEdge("A", "D", true, 9999);
        network.addEdge("A", "E", true, 3);
        network.addEdge("A", "F", true, 12);
        // From B
        network.addEdge("B", "C", true, 17);
        network.addEdge("B", "D", true, 9);
        network.addEdge("B", "E", true, 17);
        network.addEdge("B", "F", true, 12);
        // From C
        network.addEdge("C", "D", true, 35);
        network.addEdge("C", "E", true, 3);
        network.addEdge("C", "F", true, 12);
        // From D
        network.addEdge("D", "E", true, 9999);
        network.addEdge("D", "F", true, 12);
        // From E
        network.addEdge("E", "F", true, 12);

        for (Vertex<String> vertex: network.getVertices()){
            Dijkstra<String> networkDijkstra = new Dijkstra<>(network, vertex);
            for (Vertex<String> destinationVertex: network.getVertices()){
                networkDijkstra.ShortestPath(destinationVertex);
                networkDijkstra.ResultPrinter();
            }
        }

    }
}
