import java.util.*;

class Solution {
    private ArrayList<Integer>[] adj;
    private boolean[] visited;
    private int N, ans;
    
    private int dfs(int now) {
        visited[now] = true;
        int sum = 0;
        
        for (int next : adj[now]) {
            if (!visited[next]) {
                int cnt = dfs(next);
                ans = Math.min(ans, Math.abs(N - cnt * 2));
                sum += cnt;
            }
        }
        
        return sum + 1;
    }
    
    public int solution(int n, int[][] wires) {
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        N = n;
        ans = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            adj[wires[i][0]].add(wires[i][1]);
            adj[wires[i][1]].add(wires[i][0]);
        }
        
        dfs(1);
        return ans;
    }
}