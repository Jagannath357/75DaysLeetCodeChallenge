import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // HashMap to map original nodes to their corresponding cloned nodes
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If the node has already been cloned, return the existing clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new node instance with the same value (empty neighbors list initially)
        Node cloneNode = new Node(node.val);
        
        // Map the original node to its newly created clone
        visited.put(node, cloneNode);

        // Recursively clone all neighbors of the current node
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}