import java.util.*;
class Node implements Comparable<Node> {
    int id, x, y;
    Node lt, rt;
    
    Node(int id, int x, int y, Node lt, Node rt) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.lt = lt;
        this.rt = rt;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.y != o.y ? o.y - this.y : this.x - o.x;
    }
}

class Solution {
    private static int[][] ans;
    private static ArrayList<Integer> preorderList = new ArrayList<>();
    private static ArrayList<Integer> postorderList = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        ans = new int[2][nodeinfo.length];
        
        ArrayList<Node> list = new ArrayList<>();
        
        Node root;
        
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }
        
        Collections.sort(list);
        
        root = list.get(0);
        
        for (int i = 1; i < list.size(); i++) {
            buildTree(root, list.get(i));
        }
        preorder(root);
        postorder(root);
        ans[0] = preorderList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        ans[1] = postorderList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return ans;
    }
    
    private static void buildTree(Node parent, Node child) {
        if (parent.x < child.x) {
            if (parent.rt == null) {
                parent.rt = child;
                return;
            }
            buildTree(parent.rt, child);
        } else {
            if (parent.lt == null) {
                parent.lt = child;
                return;
            }
            buildTree(parent.lt, child);
        }
    }
    
    private static void preorder(Node node) {
        if (node == null) return;
        preorderList.add(node.id);
        preorder(node.lt);
        preorder(node.rt);
    } 
    
    private static void postorder(Node node) {
        if (node == null) return;
        postorder(node.lt);
        postorder(node.rt);
        postorderList.add(node.id);
    }
}