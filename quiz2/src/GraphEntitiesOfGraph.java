import java.util.*;

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

    public void addDestination(T source, T destination) {
        adjVertices.get(source).add(destination);
        adjVertices.get(destination).add(source); // For an undirected graph, edges are bidirectional
    }

    public void printGraph() {
        for (Map.Entry<T, List<T>> entry : adjVertices.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        GraphVertices<Integer> g = new GraphVertices<>();
        for (int i = 1; i <= 7; i++) {
            g.addSourceNode(i);
        }
        g.addDestination(1, 2);
        g.addDestination(1, 3);
        g.addDestination(1, 4);
        g.addDestination(2, 3);
        g.addDestination(3, 5);
        g.addDestination(3, 6);

        g.printGraph();
    }
}

