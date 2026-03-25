import java.util.*;

class Node implements Comparable<Node> {
    int id;
    int x;
    int y;
    Node lt;
    Node rt;

    public Node(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        lt = null;
        rt = null;
    }

    @Override
    public int compareTo(Node o) {
        return this.y != o.y ? o.y - this.y : this.x - o.x;
    }
}

class Solution {
    private static int[][] answer;
    private static int idx = 0;
    public static void preOrder(Node node) {
        if (node == null) return;
        else {
            answer[0][idx++] = node.id;
            preOrder(node.lt);
            preOrder(node.rt);
        }
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        else {
            postOrder(node.lt);
            postOrder(node.rt);
            answer[1][idx++] = node.id;

        }
    }

    public static void insertNode(Node parent, Node child) {
        if (parent.x < child.x) {
            if (parent.rt == null) parent.rt = child;
            else insertNode(parent.rt, child);
        } else {
            if (parent.lt == null) parent.lt = child;
            else insertNode(parent.lt, child);
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> tree = new ArrayList<>();


        for (int i = 0; i < nodeinfo.length; i++) {
            tree.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(tree);
        Node root = tree.get(0);
        // buildTree
        for (int i = 1; i < tree.size(); i++) {
            insertNode(root, tree.get(i));
        }


        answer = new int[2][tree.size()];
        preOrder(root);
        idx = 0;
        postOrder(root);

        /**
        ArrayList<Integer> preOrderList = new ArrayList<>();
        ArrayList<Integer> postOrderList = new ArrayList<>();
        // answer[][]  : 포인터(레퍼런스) 개념
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();
        */
        
        return answer;
    }
    
}
