import java.util.*;

class Main {
    static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    // 두 번 탐색하므로 돌아갈 필요 없음
    static void dfs(int node, int dist) {
        checked[node] = true;

        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        if (tree[node] == null) return;
        
        for (Node next : tree[node]) {
            if (!checked[next.dest]) {
                dfs(next.dest, dist + next.cost);

            }
        }

    }

    static ArrayList<Node>[] tree;
    static boolean[] checked;
    static int maxDist = 0;
    static int farthestNode = 1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int s = in.nextInt(); int d = in.nextInt(); int c = in.nextInt();
            tree[s].add(new Node(d, c));
            tree[d].add(new Node(s, c));

        }

        checked = new boolean[n + 1];
        maxDist = 0;
        dfs(1, 0);

        Arrays.fill(checked, false);
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

}