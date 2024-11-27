// Show the adjacency list and adjacency representation of this graph. You can draw on paper and upload screenshot.

//quiz2/src/2DC98639-5D6E-4AE5-A885-5ABB9E391073.jpeg
/* 
Adjacency List:
1 | 2, 3, 4
2 | 1, 3
3 | 1, 2, 5, 6
4 | 1
5 | 3 , 6 
6 | 5
7 | 0

Adjacency Matrix:

   1 2 3 4 5 6 7
1  0 1 1 1 0 0 0
2  1 0 1 0 0 0 0
3  1 1 0 0 1 1 0
4  1 0 0 0 0 0 0
5  0 0 1 0 0 1 0
6  0 0 0 0 1 0 0
7  0 0 0 0 0 0 0 */


//For the graph shown, implement it in Java, you can choose any of the graph representation techniques.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphEntitiesOfGraph<T, V> {
    private HashMap<T, List<V>> adjVertices; 

 public HashMap<T, List<V>> CreateAdjVerticesHashMap(HashMap<T, List<V>> adjVertices) {
    this.adjVertices = adjVertices;
    return adjVertices;
 }

 public HashMap<T, List<V>> getAdjVerticesMap() {
    return adjVertices;
 }

    public void placeSourceAndDestination(T source, V destination) {
        adjVertices.putIfAbsent(source, new ArrayList<>());
        adjVertices.get(source).add(destination);
    }
    public void printGraph() {
        for (Map.Entry<T, List<V>> entry : adjVertices.entrySet()) {
            System.out.println("Source Node: " + entry.getKey() + ": " + "Destination Node: " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        GraphEntitiesOfGraph<Integer, Integer> graphOne = new GraphEntitiesOfGraph<>();
        graphOne.CreateAdjVerticesHashMap(new HashMap<Integer, List<Integer>>());
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
