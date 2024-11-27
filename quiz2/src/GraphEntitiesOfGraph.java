import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphEntitiesOfGraph {

}

class GraphVertices<T> {
    private Map<T, List<T>> adjVertices;

    public GraphVertices() {
        this.adjVertices = new HashMap<>();
    }

    public void addSourceNode(T sourceNode) {
        adjVertices.putIfAbsent(sourceNode, new ArrayList<>());
    }

    public void placeSourceAndDestination(T source, T destination) {
        adjVertices.get(source).add(destination);
        adjVertices.get(destination).add(source); // For an undirected graph, edges are bidirectional
    }

    public void printGraph() {
        for (Map.Entry<T, List<T>> entry : adjVertices.entrySet()) {
            System.out.println("Source Node: " + entry.getKey() + ": " + "Destination Node: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        GraphVertices<Integer> g = new GraphVertices<>();
        for (int i = 1; i <= 7; i++) {
            g.addSourceNode(i);
        }
        g.placeSourceAndDestination(1, 2);
        g.placeSourceAndDestination(1, 3);
        g.placeSourceAndDestination(1, 4);
        g.placeSourceAndDestination(2, 3);
        g.placeSourceAndDestination(3, 5);
        g.placeSourceAndDestination(3, 6);

        g.printGraph();
    }
}

