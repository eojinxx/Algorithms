import java.util.*;

class Solution {
    static class Node {
        int d;
        int cost;
        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }
    }
    
    private static int[] cost;
    private static boolean[] check;
    private static ArrayList<Node>[] adj;
    
    private void dfs(int start, int c) {
        if (c >= cost[start]) return; 
        cost[start] = Math.min(cost[start], c);
         for (Node next : adj[start]) {
            if (!check[next.d]) {
                check[next.d] = true;
                dfs(next.d, c + next.cost);
                check[next.d] = false;
            }
        }
    }
    public int solution(int N, int[][] road, int K) {
        adj = new ArrayList[N + 1];
        cost = new int[N + 1]; check = new boolean[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] arr : road) {
            adj[arr[0]].add(new Node(arr[1], arr[2]));
            adj[arr[1]].add(new Node(arr[0], arr[2]));
        }

        check[1] = true;
        dfs(1, 0);
        
        int answer = 0;
        for (int i : cost) {
            if (i <= K) answer++;
        }
        
        return answer;
    }
}