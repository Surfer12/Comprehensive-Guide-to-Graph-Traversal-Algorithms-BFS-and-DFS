
<!-- Research the Depth-First Search (DFS) algorithm for a graph data structure. Implement the algorithm in Java.

Submit a pdf named CIS_233_FIRSTNAME_LASTNAME.

Rubric

Research and Understanding (70%):
Demonstrates a clear understanding of the DFS algorithm.
Provides a concise and accurate summary of the algorithm and its properties.
Code Quality (30%):
Code is well-structured, readable, and follows good programming practices.
Includes meaningful variable names and comments where necessary. -->

#Depth-First Search(DFS)

## Introduction to DFS

## Depth First Search (DFS)
DFS prioritizes exploring a path as deeply as possible before backtracking. Imagine traversing a maze and always taking the
leftmost path until you hit a dead end, then backtracking to the last junction and trying the next path.
General Implementation:
1. Start at the root node (for trees) or a designated starting node (for graphs).
2. Mark the current node as visited.
3. Explore an unvisited neighbor of the current node.
4. Repeat steps 2 and 3 recursively for the neighbor.
5. If all neighbors of the current node have been visited, backtrack to the previous node.
DFS in Java (using a Stack):
public void dfs(Node root) {
   if (root == null) {
       return;
   }
   Stack<Node> stack = new Stack<>();
   stack.push(root);

   while (!stack.isEmpty()) {
       Node node = stack.pop();
       System.out.print(node.data + " "); // Process the node

       if (node.right != null) {
           stack.push(node.right);
       }
       if (node.left != null) {
           stack.push(node.left);
       }
   }
}

DFS with Preorder, Inorder, and Postorder Traversals (for Binary Trees):
These traversals define the order in which the current node is processed relative to its children.
* Preorder: Process node, then left subtree, then right subtree.
* Inorder: Process left subtree, then node, then right subtree.
* Postorder: Process left subtree, then right subtree, then node.
// Preorder
public void preorder(Node node) {
   if (node == null) {
       return;
   }
   System.out.print(node.data + " ");
   preorder(node.left);
   preorder(node.right);
}

// Inorder
public void inorder(Node node) {
   if (node == null) {
       return;
   }
   inorder(node.left);
   System.out.print(node.data + " ");
   inorder(node.right);
}

// Postorder
public void postorder(Node node) {
   if (node == null) {
       return;
   }
   postorder(node.left);
   postorder(node.right);
   System.out.print(node.data + " ");
}

DFS with Adjacency Matrix and Adjacency List (for Graphs):
* Adjacency Matrix: A 2D array where matrix[i][j] is 1 if there's an edge between nodes i and j, and 0 otherwise.
* Adjacency List: An array of lists where list[i] contains the neighbors of node i.
// DFS with Adjacency Matrix
public void dfsMatrix(int[][] matrix, int startNode) {
   boolean[] visited = new boolean[matrix.length];
   dfsUtilMatrix(matrix, startNode, visited);
}

private void dfsUtilMatrix(int[][] matrix, int node, boolean[] visited) {
   visited[node] = true;
   System.out.print(node + " ");

   for (int i = 0; i < matrix[node].length; i++) {
       if (matrix[node][i] == 1 && !visited[i]) {
           dfsUtilMatrix(matrix, i, visited);
       }
   }
}

// DFS with Adjacency List
public void dfsList(List<List<Integer>> adjList, int startNode) {
   boolean[] visited = new boolean[adjList.size()];
   dfsUtilList(adjList, startNode, visited);
}

private void dfsUtilList(List<List<Integer>> adjList, int node, boolean[] visited) {
   visited[node] = true;
   System.out.print(node + " ");

   for (int neighbor : adjList.get(node)) {
       if (!visited[neighbor]) {
           dfsUtilList(adjList, neighbor, visited);
       }
   }
}

##Recursive DFS
```java
class Graph {
    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adjacent : adjacencyList.get(vertex)) {
            if (!visited[adjacent]) {
                dfsRecursive(adjacent, visited);
            }
        }
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsRecursive(startVertex, visited);
    }}```

    ###

    Iterative DFS
```java

    public void dfsIterative(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");

                for (int adjacent : adjacencyList.get(vertex)) {
                    if (!visited[adjacent]) {
                        stack.push(adjacent);
                    }
                }
            }
        }
    }
```

    ###

    Advanced DFS Applications

    ####
    Cycle Detection```java

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (hasCycleUtil(i, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[vertex])
            return true;
        if (visited[vertex])
            return false;

        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (int adjacent : adjacencyList.get(vertex)) {
            if (hasCycleUtil(adjacent, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[vertex] = false;
        return false;
    }```

    ####

    Topological Sorting```java

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
    visited[vertex] = true;
   
    for (int adjacent : adjacencyList.get(vertex)) {
        if (!visited[adjacent]) {
            topologicalSortUtil(adjacent, visited, stack);
        }
    }
   
    stack.push(vertex);
}
``

















##Implementation Approaches

## Comparison and Selection Guidelines


### Time and Space Complexity
- Both DFS and BFS: O(V + E) time complexity
- DFS: O(h) space complexity (h = height of tree/graph)
- BFS: O(w) space complexity (w = maximum width of tree/graph)


### Selection Criteria
Choose DFS when:
- Memory is limited
- Solution is far from root
- Need to detect cycles
- Implementing backtracking algorithms


Choose BFS when:
- Finding shortest path
- Solution is close to root
- Level-order traversal needed
- Testing bipartiteness

###Recursive DFS```java
class Graph {
    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adjacent : adjacencyList.get(vertex)) {
            if (!visited[adjacent]) {
                dfsRecursive(adjacent, visited);
            }
        }
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsRecursive(startVertex, visited);
    }}```

    ###

    Iterative DFS```java

    public void dfsIterative(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");

                for (int adjacent : adjacencyList.get(vertex)) {
                    if (!visited[adjacent]) {
                        stack.push(adjacent);
                    }
                }
            }
        }
    }```

    ###

    Advanced DFS Applications

    ####
    Cycle Detection```java

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (hasCycleUtil(i, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[vertex])
            return true;
        if (visited[vertex])
            return false;

        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (int adjacent : adjacencyList.get(vertex)) {
            if (hasCycleUtil(adjacent, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[vertex] = false;
        return false;
    }```

    ####

    Topological Sorting```java

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
    visited[vertex] = true;
    
    for (int adjacent : adjacencyList.get(vertex)) {
        if (!visited[adjacent]) {
            topologicalSortUtil(adjacent, visited, stack);
        }
    }
    
    stack.push(vertex);
}``
* Applications beyond shortest paths: While BFS excels at finding the shortest path in unweighted graphs, its level-by-level 
exploration is valuable in other scenarios:
   * Finding connected components: BFS can identify all nodes reachable from a starting node, effectively grouping connected 
components in a graph.
   * Testing bipartiteness: BFS can determine if a graph is bipartite (can be colored with two colors such that no adjacent 
nodes have the same color).
   * Crawling web pages: Search engines often use a modified BFS approach to crawl web pages, starting from a seed page and 
following links level by level.
* Variations and optimizations:
   * Bidirectional BFS: When searching for a path between two specific nodes, you can run two BFS searches simultaneously, 
one from each node, potentially finding the path faster.
   * Parallel BFS: For large graphs, BFS can be parallelized to explore multiple branches concurrently, speeding up the 
search.
Depth-First Search (DFS) - Further Exploration
* Applications beyond cycle detection: DFS is versatile and finds use in various graph problems:
   * Topological sorting: In directed acyclic graphs (DAGs), DFS can order nodes such that for every directed edge from node 
A to node B, A appears before B in the ordering.
   * Finding strongly connected components: In directed graphs, DFS can identify groups of nodes where every node is 
reachable from every other node within the group.
   * Solving puzzles with backtracking: DFS is the backbone of backtracking algorithms, used to explore possible solutions 
in problems like Sudoku and the N-Queens puzzle.
* Variations and optimizations:
   * Iterative deepening DFS: Combines the space efficiency of DFS with the completeness of BFS by performing depth-limited 
DFS searches with increasing depth limits.
   * DFS with pruning: In problem-solving scenarios, DFS can be optimized by pruning branches that are guaranteed not to 
lead to a solution.
Comparing BFS and DFS
* Memory usage: DFS generally uses less memory than BFS, especially in deep graphs, as it only needs to store the nodes 
along the current path. BFS, on the other hand, stores all nodes at the current level, which can be memory-intensive for 
wide graphs.
* Speed: The relative speed of BFS and DFS depends on the graph structure and the problem being solved. If the solution is 
likely to be found at shallower depths, BFS might be faster. If the solution is deep within the graph or requires exploring 
a specific path, DFS might be more efficient.
Choosing the right algorithm
The choice between BFS and DFS depends on the specific application and the characteristics of the graph:
* Shortest path: BFS is generally preferred for finding the shortest path in unweighted graphs.
* Connectivity: Both BFS and DFS can be used to find connected components, but BFS might be slightly easier to implement.
* Cycle detection: DFS is typically used for cycle detection.
* Topological sorting: DFS is necessary for topological sorting.
* Memory constraints: If memory is a concern, DFS is generally more memory-efficient.
Depth First Search (DFS) and Breadth First Search (BFS)
Both DFS and BFS are algorithms used to traverse or search through tree or graph data structures. They explore nodes in a 
systematic way, but differ in the order they visit nodes.
Depth First Search (DFS)
DFS prioritizes exploring a path as deeply as possible before backtracking. Imagine traversing a maze and always taking the 
leftmost path until you hit a dead end, then backtracking to the last junction and trying the next path.
General Implementation:
1. Start at the root node (for trees) or a designated starting node (for graphs).
2. Mark the current node as visited.
3. Explore an unvisited neighbor of the current node.
4. Repeat steps 2 and 3 recursively for the neighbor.
5. If all neighbors of the current node have been visited, backtrack to the previous node.
DFS in Java (using a Stack):
public void dfs(Node root) {
   if (root == null) {
       return;
   }
   Stack<Node> stack = new Stack<>();
   stack.push(root);

   while (!stack.isEmpty()) {
       Node node = stack.pop();
       System.out.print(node.data + " "); // Process the node

       if (node.right != null) {
           stack.push(node.right);
       }
       if (node.left != null) {
           stack.push(node.left);
       }
   }
}

DFS with Preorder, Inorder, and Postorder Traversals (for Binary Trees):
These traversals define the order in which the current node is processed relative to its children.
* Preorder: Process node, then left subtree, then right subtree.
* Inorder: Process left subtree, then node, then right subtree.
* Postorder: Process left subtree, then right subtree, then node.
// Preorder
public void preorder(Node node) {
   if (node == null) {
       return;
   }
   System.out.print(node.data + " ");
   preorder(node.left);
   preorder(node.right);
}

// Inorder
public void inorder(Node node) {
   if (node == null) {
       return;
   }
   inorder(node.left);
   System.out.print(node.data + " ");
   inorder(node.right);
}

// Postorder
public void postorder(Node node) {
   if (node == null) {
       return;
   }
   postorder(node.left);
   postorder(node.right);
   System.out.print(node.data + " ");
}

DFS with Adjacency Matrix and Adjacency List (for Graphs):
* Adjacency Matrix: A 2D array where matrix[i][j] is 1 if there's an edge between nodes i and j, and 0 otherwise.
* Adjacency List: An array of lists where list[i] contains the neighbors of node i.
// DFS with Adjacency Matrix
public void dfsMatrix(int[][] matrix, int startNode) {
   boolean[] visited = new boolean[matrix.length];
   dfsUtilMatrix(matrix, startNode, visited);
}

private void dfsUtilMatrix(int[][] matrix, int node, boolean[] visited) {
   visited[node] = true;
   System.out.print(node + " ");

   for (int i = 0; i < matrix[node].length; i++) {
       if (matrix[node][i] == 1 && !visited[i]) {
           dfsUtilMatrix(matrix, i, visited);
       }
   }
}

// DFS with Adjacency List
public void dfsList(List<List<Integer>> adjList, int startNode) {
   boolean[] visited = new boolean[adjList.size()];
   dfsUtilList(adjList, startNode, visited);
}

private void dfsUtilList(List<List<Integer>> adjList, int node, boolean[] visited) {
   visited[node] = true;
   System.out.print(node + " ");

   for (int neighbor : adjList.get(node)) {
       if (!visited[neighbor]) {
           dfsUtilList(adjList, neighbor, visited);
       }
   }
}

Breadth First Search (BFS)
BFS prioritizes exploring nodes level by level. Imagine searching a maze by exploring all immediate paths from your starting 
point, then all paths one step further, and so on.
General Implementation:
1. Start at the root node (for trees) or a designated starting node (for graphs).
2. Add the starting node to a queue.
3. While the queue is not empty:
   * Dequeue a node from the queue.
   * Mark the node as visited.
   * Enqueue all unvisited neighbors of the node.
BFS in Java (using a Queue):
public void bfs(Node root) {
   if (root == null) {
       return;
   }
   Queue<Node> queue = new LinkedList<>();
   queue.offer(root);

   while (!queue.isEmpty()) {
       Node node = queue.poll();
       System.out.print(node.data + " "); // Process the node

       if (node.left != null) {
           queue.offer(node.left);
       }
       if (node.right != null) {
           queue.offer(node.right);
       }
   }
}

BFS with Adjacency Matrix and Adjacency List (for Graphs):
// BFS with Adjacency Matrix
public void bfsMatrix(int[][] matrix, int startNode) {
   boolean[] visited = new boolean[matrix.length];
   Queue<Integer> queue = new LinkedList<>();
   visited[startNode] = true;
   queue.offer(startNode);

   while (!queue.isEmpty()) {
       int node = queue.poll();
       System.out.print(node + " ");

       for (int i = 0; i < matrix[node].length; i++) {
           if (matrix[node][i] == 1 && !visited[i]) {
               visited[i] = true;
               queue.offer(i);
           }
       }
   }
}

// BFS with Adjacency List
public void bfsList(List<List<Integer>> adjList, int startNode) {
   boolean[] visited = new boolean[adjList.size()];
   Queue<Integer> queue = new LinkedList<>();
   visited[startNode] = true;
   queue.offer(startNode);

   while (!queue.isEmpty()) {
       int node = queue.poll();
       System.out.print(node + " ");

       for (int neighbor : adjList.get(node)) {
           if (!visited[neighbor]) {
               visited[neighbor] = true;
               queue.offer(neighbor);
           }
       }
   }
}

Key Differences and Applications:
Feature
	DFS
	BFS
	Data Structure
	Stack (implicit or explicit)
	Queue
	Traversal Order
	Deepest node first
	Level by level
	Applications
	Finding cycles, topological sorting, finding connected components
	Finding shortest paths, testing if a graph is bipartite
	Remember to adapt these code examples to your specific needs and data structures. This detailed breakdown should provide 
a solid foundation for understanding and implementing DFS and BFS in Java.
* Summary of Graph Traversal Algorithms:
Introduction to Graph Theory and Search Algorithms:
Graphs represent relationships between objects using nodes and edges.
Search algorithms explore graphs to find paths or specific nodes.
Core Graph Concepts:
Nodes (vertices) represent entities, edges represent relationships, and properties include direction, weight, etc.
Depth-First Search (DFS):
Explores graphs in a depthward manner, visiting nodes recursively or iteratively.
Applications include cycle detection and topological sorting.
Advanced DFS Applications:
Cycle detection identifies whether a graph contains cycles.
Topological sorting arranges nodes in a linear order while preserving dependencies.
Breadth-First Search (BFS):
Explores graphs layer by layer, visiting all neighbors of a node before moving deeper.
Applications include finding the shortest path in an unweighted graph.
Advanced BFS Applications:
Shortest path algorithms like Dijkstra's and Floyd-Warshall's are based on BFS.
Dijkstra's Algorithm:
Finds the shortest path from a source node to all other nodes in a weighted graph.
Floyd-Warshall Algorithm:
Finds the shortest paths between all pairs of nodes in a weighted graph.
Bellman-Ford Algorithm:
Handles negative weight edges and detects negative cycles in a weighted graph.
A (A-star) Algorithm:*
Combines BFS and DFS to efficiently find the shortest path in a weighted graph with heuristics.