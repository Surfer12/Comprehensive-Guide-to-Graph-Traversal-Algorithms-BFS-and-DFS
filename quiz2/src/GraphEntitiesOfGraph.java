import java.util.HashMap;
import java.util.ArrayList;
public class GraphEntitiesOfGraph<T, V> {
    private HashMap<T, ArrayList<V>> adjVertices; 

 public HashMap<T, ArrayList<V>> CreateAdjVerticesHashMap(HashMap<T, ArrayList<V>> adjVertices) {
    this.adjVertices = adjVertices;
    return adjVertices;
 }

 public HashMap<T, ArrayList<V>> getAdjVerticesMap() {
    return adjVertices;
 }

    public void placeSourceAndDestination(T source, V destination) {
        adjVertices.putIfAbsent(source, new ArrayList<>());
        adjVertices.get(source).add(destination);
    }
    public void printGraph() {
        for (HashMap.Entry<T, ArrayList<V>> entry : adjVertices.entrySet()) {
            System.out.println("Source Node: " + entry.getKey() + ": " + "Destination Node: " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        GraphEntitiesOfGraph<Integer, Integer> graphOne = new GraphEntitiesOfGraph<>();
        graphOne.CreateAdjVerticesHashMap(new HashMap<Integer, ArrayList<Integer>>());
        graphOne.placeSourceAndDestination(1, 2);
        graphOne.placeSourceAndDestination(1, 3);
        graphOne.placeSourceAndDestination(1, 4);
        graphOne.placeSourceAndDestination(2, 1);
        graphOne.placeSourceAndDestination(2, 3);   
        graphOne.placeSourceAndDestination(3, 1);
        graphOne.placeSourceAndDestination(3, 2);
        graphOne.placeSourceAndDestination(3, 5);
        graphOne.placeSourceAndDestination(3, 6);
        graphOne.placeSourceAndDestination(4, 1);
        graphOne.placeSourceAndDestination(5, 3);
        graphOne.placeSourceAndDestination(5, 6);
        graphOne.placeSourceAndDestination(6, 5);
        graphOne.placeSourceAndDestination(7, 0);
        graphOne.getAdjVerticesMap();

        graphOne.printGraph();
    }
}

/* Output : 
Source Node: 1: Destination Node: [2, 3, 4]
Source Node: 2: Destination Node: [1, 3]
Source Node: 3: Destination Node: [1, 2, 5, 6]
Source Node: 4: Destination Node: [1]
Source Node: 5: Destination Node: [3, 6]
Source Node: 6: Destination Node: [5]
Source Node: 7: Destination Node: [0]
*/