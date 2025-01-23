import java.util.*;

class Node {
    String name;
    List<Node> adjacent;
    boolean visited;

    Node(String name) {
        this.name = name;
        this.adjacent = new ArrayList<>();
        this.visited = false;
    }

    void addEdge(Node neighbor) {
        adjacent.add(neighbor);
    }
}

public class Code {
    public void dfsTraversal(Node node, Set<String> visited) {
        if (node == null) return;

        // Mark node as visited
        System.out.println("Visited: " + node.name);
        visited.add(node.name);
        node.visited = true;

        // Traverse adjacent nodes
        for (Node neighbor : node.adjacent) {
            if (!neighbor.visited) {
                dfsTraversal(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Create the graph
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        // Add edges
        nodeA.addEdge(nodeB);
        nodeA.addEdge(nodeC);
        nodeB.addEdge(nodeD);
        nodeC.addEdge(nodeE);

        // Perform DFS
        Code dfs = new Code();
        Set<String> visited = new HashSet<>();
        System.out.println("DFS Traversal:");
        dfs.dfsTraversal(nodeA, visited);
    }
}
