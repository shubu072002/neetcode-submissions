/*
Definition for a Node.
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
    private Map<Node, Node> clones = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) 
            return null;

        // Agar node pehle se cloned hai, toh map se wahi return kar do (infinite loop se bachne ke liye)
        if (clones.containsKey(node)) 
            return clones.get(node);

        // Current node ki copy banao
        Node newNode = new Node(node.val);
        clones.put(node, newNode);

        // Sare neighbors ke liye recursive call karo aur unko naye node ke neighbors list mein add karo
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;
    }
} 