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
    HashMap<Node, Node> map;
    private Node cloneNode(Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        List<Node> list = new ArrayList<>();
        map.put(node, newNode);
        for(Node i : node.neighbors){
            Node tmp = cloneNode(i);
            list.add(tmp);
        }
        newNode.neighbors = list;
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        this.map = new HashMap<>();
        return cloneNode(node);

    }
}
